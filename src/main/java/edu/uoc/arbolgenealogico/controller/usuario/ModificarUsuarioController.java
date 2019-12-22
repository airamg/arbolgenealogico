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
public class ModificarUsuarioController {

	@Autowired
	@Qualifier ("usuarioService")
	private IUsuarioService userservice;	
	
	/**
	 * Método que lleva a la pagina del usuario con el formulario de modificacion de datos
	 * @return ModelAndView
	 */	
	@RequestMapping(value ="/usuarios/modificar", method = RequestMethod.GET)
	protected ModelAndView modificarusuariocontroller()  {
		
		ModelAndView modeloUsuario = new ModelAndView("/usuario/modificar");
		Usuario usuario = userservice.getByOnline();
		modeloUsuario.addObject("usuario", usuario);
		return modeloUsuario;

	}
	
	/**
	 * Método de modificacion de datos que redirige a la cuenta de usuario
	 * @param usuario
	 * @return String
	 */
	@RequestMapping(value = "/usuarios/modificar", method = RequestMethod.POST)
	public String executeModificarUsuario(@ModelAttribute("usuario") Usuario usuario) {

		String model = null;
		// comprobar quien es el usuario online
		Usuario user = userservice.getByOnline();
		if(user!=null){
			//actualizar la bd con los nuevos datos del usuario		
			if(usuario.getPass().equals("")) {	
				user.setUsername(usuario.getUsername());
				user.setNombre(usuario.getNombre());
				user.setApellidos(usuario.getApellidos());
				user.setEmail(usuario.getEmail());
			} else {
				user.setUsername(usuario.getUsername());
				user.setPass(usuario.getPass());
				user.setNombre(usuario.getNombre());
				user.setApellidos(usuario.getApellidos());
				user.setEmail(usuario.getEmail());
			}	
			userservice.update(user);		
			model = "redirect:/usuarios/cuenta";		
		}else{
			model = "error";
		}

		return model;
	}
}
