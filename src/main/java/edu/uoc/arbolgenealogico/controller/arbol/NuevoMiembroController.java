package edu.uoc.arbolgenealogico.controller.arbol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.pojo.Parentesco;
import edu.uoc.arbolgenealogico.pojo.Usuario;
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

	/**
	 * Método que muestra la pagina de nuevo miembro
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/miembros/nuevo", method = RequestMethod.GET)
	public ModelAndView displayNuevoMiembro(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("/arbol/nuevomiembro");
		Miembro miembro = new Miembro();
		model.addObject("miembro", miembro);
		//lista para el desplegable de parentesco
		List<Parentesco> parentescos = parentescoservice.getAll();
		model.addObject("lista_parentesco", parentescos);
		return model;
	}

	/**
	 * Método que crea un nuevo miembro y redirige a la página inicial arbol de cada usuario con todos los miembros
	 * @param request
	 * @param response
	 * @param miembro
	 * @return String
	 */
	@RequestMapping(value = "/miembros/nuevo", method = RequestMethod.POST)
	public String executeNuevoMiembro(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("miembro") Miembro miembro) {
		
		String model = null;

		//comprobar quien esta online
		Usuario user = usuarioservice.getByOnline();
		if(user!=null) {
			//guardar en la bd el nuevo miembro
			Miembro miem = new Miembro();			
			miem.setNombre(miembro.getNombre());
			miem.setApellido(miembro.getApellido());
			//TODO hacer que coja numero aleatorio para que sea de diferente color la foto
			miem.setRutaImagen("resources/images/arbol/miembro.png");
			miem.setAnioNacimiento(miembro.getAnioNacimiento());
			miem.setAnioDefuncion(miembro.getAnioDefuncion());
			miem.setHistorialMedico(miembro.getHistorialMedico());
			//TODO cambiar el 1 por el id del parentesco que habra que pasar como parametro
			miembroservice.create(miem, user.getId(), 1);
			model = "redirect:miembros/index";	
		} else {
			model = "error";	
		}		
		request.setAttribute("miembronombre", miembro.getNombre());
		request.setAttribute("miembroapellido", miembro.getApellido());
		request.setAttribute("miembroanionacimiento", miembro.getAnioNacimiento());
		request.setAttribute("miembroaniodefuncion", miembro.getAnioDefuncion());
		request.setAttribute("miembrohistorialmedico", miembro.getHistorialMedico());
		
		return model;
	}

}
