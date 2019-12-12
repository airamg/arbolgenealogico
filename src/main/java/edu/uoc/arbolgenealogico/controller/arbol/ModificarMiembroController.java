package edu.uoc.arbolgenealogico.controller.arbol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.pojo.Parentesco;
import edu.uoc.arbolgenealogico.service.interfaces.IMiembroService;
import edu.uoc.arbolgenealogico.service.interfaces.IParentescoService;

@Controller
public class ModificarMiembroController {
	
	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;
	
	@Autowired
	@Qualifier ("parentescoService")
	private IParentescoService parentescoservice;

	
	/**
	 * Método que recoge el miembro seleccionado en la pantalla inicial del arbol de usuario y lo modifica
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/miembros/modificar/{id}", method = RequestMethod.GET)
	public ModelAndView modificarMiembroLista(@PathVariable(value = "id") int id) {		
		
		ModelAndView modeloMiembro = new ModelAndView("/arbol/modificarmiembro");
		Miembro miembro = miembroservice.getById(id);
		modeloMiembro.addObject("miembro", miembro);
		
		//lista para el desplegable de parentesco
		List<Parentesco> parentescos = parentescoservice.getAll();
		modeloMiembro.addObject("lista_parentesco", parentescos);
		
		return modeloMiembro;
		
	}

	
	/**
	 * Método de modificacion de datos que redirige a la pantalla inicial del arbol de usuario y lo modifica
	 * @param request
	 * @param response
	 * @param miembro
	 * @return String
	 */
	@RequestMapping(value = "/usuarios/modificar", method = RequestMethod.POST)
	public String executeModificarMiembro(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("miembro") Miembro miembro) {

		String model = null;
		
		//comprobar que el miembro existe
		Miembro m = miembroservice.getById(miembro.getId());
		if(m!=null){			
			//actualizar la bd con los nuevos datos
			m.setNombre(miembro.getNombre());
			m.setApellido(miembro.getApellido());
			m.setAnioNacimiento(miembro.getAnioNacimiento());
			m.setAnioDefuncion(miembro.getAnioDefuncion());
			m.setHistorialMedico(miembro.getHistorialMedico());
			miembroservice.update(m);		
			model = "redirect:miembros/index";		
		}else{
			model = "error";
		}

		return model;
	}

}
