package edu.uoc.arbolgenealogico.controller.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier ("usuarioService")
	private IUsuarioService userservice;	

	/**
	 * M�todo que lleva a la pagina principal de usuarios
	 * @return ModelAndView
	 */	
	@RequestMapping(value ="/usuarios", method = RequestMethod.GET)
	protected ModelAndView usuariocontroller()  {
		
		ModelAndView modeloUsuario = new ModelAndView();
		Usuario user = userservice.getByOnline();
		if(user!=null){
			modeloUsuario.addObject("usuario", user);
			modeloUsuario.setViewName("/usuario/index");
		}else{
			modeloUsuario = new ModelAndView("error");
		}

		return modeloUsuario;

	}
}