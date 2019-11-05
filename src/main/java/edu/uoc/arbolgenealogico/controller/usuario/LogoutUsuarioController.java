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
public class LogoutUsuarioController {

	@Autowired
	@Qualifier ("usuarioService")
	private IUsuarioService userservice;	
	
	/**
	 * Método que cierra la sesion del usuario conectado
	 * @return ModelAndView
	 */	
	@RequestMapping(value ="/usuarios/logout", method = RequestMethod.GET)
	protected ModelAndView logoutusuariocontroller()  {
		
		ModelAndView modeloUsuario = new ModelAndView();
		Usuario user = userservice.getByOnline();
		if(user!=null){
			user.setOnline(0);
			userservice.update(user);	
			modeloUsuario.setViewName("logout");
		}else{
			modeloUsuario = new ModelAndView("error");
		}

		return modeloUsuario;

	}
}
