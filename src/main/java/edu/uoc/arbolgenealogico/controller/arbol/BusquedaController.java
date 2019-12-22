package edu.uoc.arbolgenealogico.controller.arbol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IMiembroService;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

@Controller
public class BusquedaController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioservice;

	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;
	
	/**
	 * Método que muestra la pagina de resultados de busqueda
	 * @param valor
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/miembros/buscar/{historialMedico}", method = RequestMethod.GET)
	public ModelAndView displayBusqueda(@PathVariable(value = "historialMedico") String valor) {
		
		ModelAndView model = new ModelAndView("/arbol/busquedas");
		
		Usuario user = usuarioservice.getByOnline();
		if(user!=null) {
			List<Miembro> lista = miembroservice.getByHistorialMedico(user.getId(), valor);
			int numMiembros = 0;
			boolean sinMiembros = false;
			if(lista.isEmpty()){
				sinMiembros = true;
			}else{
				numMiembros = lista.size();
			}
			model.addObject("enfermedad", valor);
			model.addObject("numMiembros", numMiembros);
			model.addObject("sinMiembros", sinMiembros);
			model.addObject("lista_miembros", lista);			
		} else {
			model = new ModelAndView("error");
		}	

		return model;
	}	

	
	/**
	 * Método de busqueda que recoge el valor y lo redirige a la pagina de resultados
	 * @param miembro
	 * @return String
	 */
	@RequestMapping(value = "/miembros/buscar", method = RequestMethod.POST)
	public String executeBuscarHistorialMedico(@ModelAttribute("miembro") Miembro miembro) {

		return "redirect:/miembros/buscar/" +miembro.getHistorialMedico();
	}

}
