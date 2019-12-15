package edu.uoc.arbolgenealogico.controller.arbol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IMiembroService;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

@Controller
public class MiembrosController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioservice;
	
	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;

	/**
	 * Método que se accede desde el menú que lleva al arbol de cada usuario con todos los miembros
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/miembros/index", method = RequestMethod.GET)
	public ModelAndView miembrosIndex() {
		
		ModelAndView miemb = new ModelAndView();
		
		//comprobar quien es el usuario online
		Usuario user = usuarioservice.getByOnline();
		if(user!=null) {
			//sacar la lista de miembros que pertenecen al arbol del usuario online
			List<Miembro> miembros = miembroservice.getAll(user.getId());		
			miemb.addObject("lista_miembros",miembros);
			//si no hay miembros no debe mostrarse el icono de visualizar arbol
			if(miembros.isEmpty()){
				miemb.addObject("sinmiembros", "S");
			}else{
				miemb.addObject("sinmiembros", "N");
			}			
			miemb.setViewName("/arbol/index");
		} else {
			miemb = new ModelAndView("error");
		}	
		
		return miemb;

	}
	
}
