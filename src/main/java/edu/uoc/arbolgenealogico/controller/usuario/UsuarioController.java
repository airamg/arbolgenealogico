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
	 * Método que lleva a la pagina principal de usuarios en la que se muestran todos sus datos
	 * @return ModelAndView
	 */	
	@RequestMapping(value ="/usuarios", method = RequestMethod.GET)
	protected ModelAndView usuariocontroller()  {
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
//		return "home";
		
		ModelAndView model = new ModelAndView("/usuario/index");
		Usuario user = new Usuario();
		model.addObject("usuario", user);
		return model;
		

		//TODO comprobar quien es el cliente online
	
	}
}
