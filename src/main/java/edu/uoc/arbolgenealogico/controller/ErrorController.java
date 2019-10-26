package edu.uoc.arbolgenealogico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/error")
@Controller
public class ErrorController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String error() {		
		return "error";
	}

}
