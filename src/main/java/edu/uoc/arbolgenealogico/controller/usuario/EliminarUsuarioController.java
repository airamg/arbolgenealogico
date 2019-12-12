package edu.uoc.arbolgenealogico.controller.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IMiembroService;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

@Controller
public class EliminarUsuarioController {

	@Autowired
	@Qualifier ("usuarioService")
	private IUsuarioService userservice;
	
	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;
	
	/**
	 * Método de elimina el usuario y redirige a la pagina de login
	 * @return String
	 */
	@RequestMapping(value = "/usuarios/borrar", method = RequestMethod.GET)
	public String executeBorrarUsuario() {
		String model = null;
		// comprobar quien es el usuario online
		Usuario user = userservice.getByOnline();
		if(user!=null) {		
			//buscar los miembros asociados a ese usuario
			List<Miembro> miembros = miembroservice.getAll(user.getId());	
			for (Miembro m : miembros) {
				miembroservice.delete(m.getId());
			}
			userservice.delete(user.getId());
			
			model = "redirect:/home";		
		} else {
			model = "error";	
		}

		return model;
	}
}
