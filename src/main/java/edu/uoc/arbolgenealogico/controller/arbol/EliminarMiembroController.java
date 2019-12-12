package edu.uoc.arbolgenealogico.controller.arbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.service.interfaces.IMiembroService;

@Controller
public class EliminarMiembroController {

	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;
	
	/**
	 * Método de elimina el miembro seleccionado y redirige a la pagina de gestion de miembros
	 * @return String
	 */
	@RequestMapping(value = "/miembros/eliminar/{id}", method = RequestMethod.GET)
	public String executeBorrarMiembro(@PathVariable(value = "id") int id) {
		String model = null;
		Miembro m = miembroservice.getById(id);
		if(m!=null) {
			miembroservice.delete(m.getId());
			model = "redirect:miembros/index";		
		} else {
			model = "error";	
		}

		return model;
	}

}
