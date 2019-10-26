package edu.uoc.arbolgenealogico.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService userservice;

	/**
	 * Método para el login del usuario
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("home");
		Usuario user = new Usuario();
		model.addObject("usuario", user);
		return model;
	}

	/**
	 * Método de login que redirige a la página principal del usuario logeado
	 * @param request
	 * @param response
	 * @param administrador
	 * @return String
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.POST)
	public String executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("usuario") Usuario usuario) {
		String model = null;
		//comprobamos que el usuario existe en la bd
		Usuario user = userservice.getByUsername(usuario.getUsername());
		if(user!=null) {
			//si existe, comprobamos su pass
			if((user.getPass()).equals(usuario.getPass()) && (user.getOnline()==0)) {
				//actualizar la base de datos cambiando online a 1 y la hora de conexion
				//user.setUltima_conexion(new Date(Calendar.getInstance().getTime().getTime()));
				user.setOnline(1);
				userservice.update(user);
				//redirigimos a la pagina principal
				request.setAttribute("usuariousername", usuario.getUsername());
				request.setAttribute("usuariopass", usuario.getPass());
				model = "redirect:usuarios";						
			} else {
				model = "error";
			}
		} else {
			model = "error";
		}

		request.setAttribute("usuariousername", user.getUsername());
		request.setAttribute("usuariopass", user.getPass());
		return model;
	}
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
}
