package edu.uoc.arbolgenealogico.controller.arbol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Descendencia;
import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.pojo.Parentesco;
import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IDescendenciaService;
import edu.uoc.arbolgenealogico.service.interfaces.IMiembroService;
import edu.uoc.arbolgenealogico.service.interfaces.IParentescoService;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

@Controller
public class NuevoMiembroController {
	
	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioservice;
	
	@Autowired
	@Qualifier ("parentescoService")
	private IParentescoService parentescoservice;
	
	@Autowired
	@Qualifier ("descendenciaService")
	private IDescendenciaService descendenciaservice;

	/**
	 * Método que muestra la pagina de nuevo miembro
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/miembros/nuevo", method = RequestMethod.GET)
	public ModelAndView displayNuevoMiembro() {
		
		ModelAndView model = new ModelAndView("/arbol/nuevomiembro");
		Miembro miembro = new Miembro();
		model.addObject("miembro", miembro);
		
		//lista para el desplegable de parentesco
		List<Parentesco> parentescos = parentescoservice.getAll();
		model.addObject("lista_parentesco", parentescos);
		
		//lista para el desplegable de descendencia
		List<Descendencia> descendencias = descendenciaservice.getAll();
		model.addObject("lista_descendencia", descendencias);

		return model;
	}

	/**
	 * Método que crea un nuevo miembro y redirige a la página inicial arbol de cada usuario con todos los miembros
	 * @param miembro
	 * @return String
	 */
	@RequestMapping(value = "/miembros/nuevo", method = RequestMethod.POST)
	public String executeNuevoMiembro(@ModelAttribute("miembro") Miembro miembro) {
		
		String model = null;

		//comprobar quien esta online
		Usuario user = usuarioservice.getByOnline();
		if(user!=null) {
			//guardar en la bd el nuevo miembro
			Miembro miem = new Miembro();	
			miem.setNombre(miembro.getNombre());
			miem.setApellido(miembro.getApellido());
			//numero de foto que corresponda con el parentesco que haya elegido el usuario
			String foto = "";
			switch(miembro.getIdParentesco()){
				case 1: case 2:
					foto = "1";
					break;
				case 3: case 4:
					foto = "2";
					break;
				case 5: case 6:
					foto = "3";
					break;
				case 7: case 8:
					foto = "4";
					break;
				case 9: case 10:
					foto = "5";
					break;
				default:
					foto = "";
					break;
			}
			miem.setRutaImagen("resources/images/arbol/miembro"+foto+".png");
			miem.setAnioNacimiento(miembro.getAnioNacimiento());
			miem.setAnioDefuncion(miembro.getAnioDefuncion());
			miem.setHistorialMedico(miembro.getHistorialMedico());
			miembroservice.create(miem, user.getId(), miembro.getIdParentesco(), miembro.getIdDescendencia());
			model = "redirect:/miembros/index";	
		} else {
			model = "error";	
		}		
		
		return model;
	}

}
