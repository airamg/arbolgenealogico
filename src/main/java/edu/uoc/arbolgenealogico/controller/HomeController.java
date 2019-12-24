package edu.uoc.arbolgenealogico.controller;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService userservice;

	/**
	 * Método para el login del usuario
	 * @return ModelAndView
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView displayLogin() {
		ModelAndView model = new ModelAndView("home");
		Usuario user = new Usuario();
		model.addObject("usuario", user);
		return model;
	}

	/**
	 * Método de login que redirige a la página principal del usuario logeado
	 * @param usuario
	 * @return String
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.POST)
	public String executeLogin(@ModelAttribute("usuario") Usuario usuario) {
		String model = null;
		//comprobamos que el usuario existe en la bd
		Usuario user = userservice.getByUsername(usuario.getUsername());
		if(user!=null) {
			//si existe, comprobamos su pass
			if((user.getPass()).equals(usuario.getPass()) && (user.getOnline()==0)) {
				//comprobamos si hay otro usuario online para cerrarle sesion
				Usuario userOnline = userservice.getByOnline();
				if(userOnline!=null) {
					userOnline.setOnline(0);
					userservice.update(userOnline);
				}
				//actualizar la base de datos cambiando online a 1 y la hora de conexion
				user.setUltima_conexion(new Date(Calendar.getInstance().getTime().getTime()));
				user.setOnline(1);
				userservice.update(user);
				model = "redirect:/usuarios/cuenta";						
			} else {
				model = "error";
			}
		} else {
			model = "error";
		}

		return model;
	}
	
}
