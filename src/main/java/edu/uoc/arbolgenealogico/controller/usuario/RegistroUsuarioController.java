package edu.uoc.arbolgenealogico.controller.usuario;

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
public class RegistroUsuarioController {

	@Autowired
	@Qualifier ("usuarioService")
	private IUsuarioService userservice;

	/**
	 * Método para la página principal con el registro de usuario
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/registrousuario", method = RequestMethod.GET)
	public ModelAndView displayRegistroCliente() {
		ModelAndView model = new ModelAndView("/usuario/registro");
		Usuario usuario = new Usuario();
		model.addObject("usuario", usuario);
		return model;
	}

	/**
	 * Método de registro que redirige a la página de usuarios
	 * @param usuario
	 * @return String
	 */
	@RequestMapping(value = "/registrousuario", method = RequestMethod.POST)
	public String executeRegistroUsuario(@ModelAttribute("usuario") Usuario usuario) {
		
		String model = null;

		//comprobar que el nuevo usuario no este repetido
		Usuario u = userservice.getByUsername(usuario.getUsername());
		if(u==null) {
			//comprobamos si hay otro usuario online para cerrarle sesion
			Usuario userOnline = userservice.getByOnline();
			if(userOnline!=null) {
				userOnline.setOnline(0);
				userservice.update(userOnline);
			}			
			//guardar en la bd el nuevo usuario
			Usuario usu = new Usuario();			
			usu.setUsername(usuario.getUsername());
			usu.setPass(usuario.getPass());
			usu.setNombre(usuario.getNombre());
			usu.setApellidos(usuario.getApellidos());
			usu.setOnline(1);
			userservice.create(usu);
			model = "redirect:/usuarios/cuenta";		
		} else {
			model = "error";	
		}		
		
		return model;
	}
}
