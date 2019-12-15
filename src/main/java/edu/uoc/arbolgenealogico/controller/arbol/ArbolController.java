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
public class ArbolController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioservice;
	
	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;
	
	/**
	 * Método que se accede la pagina de todos los miembros y muestra el arbol completo
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/miembros/arbol", method = RequestMethod.GET)
	public ModelAndView miembrosIndex() {
		
		ModelAndView miemb = new ModelAndView();
		//comprobar quien es el usuario online
		Usuario user = usuarioservice.getByOnline();
		if(user!=null) {
			
			//sacar las listas de miembros que pertenecen al arbol del usuario online por cada rama
			List<Miembro> miembros_rama0 = miembroservice.getByRamaArbol(user.getId(), 0);
			List<Miembro> miembros_rama1 = miembroservice.getByRamaArbol(user.getId(), 1);
			List<Miembro> miembros_rama2 = miembroservice.getByRamaArbol(user.getId(), 2);
			miemb.addObject("lista_miembros_rama0",miembros_rama0);
			miemb.addObject("lista_miembros_rama1",miembros_rama1);
			miemb.addObject("lista_miembros_rama2",miembros_rama2);
			miemb.addObject("usuario",user);
			
			//devolver tambien que tipo de rama tiene que mostrar para unir cada miembro
			String row_Abuelos_TiosPadres_a = "";
			String row_Abuelos_TiosPadres_b = "";
			if(!miembros_rama2.isEmpty()){
				row_Abuelos_TiosPadres_a = "abuelos-tios_izquierda.jpg";
				row_Abuelos_TiosPadres_a = "abuelos-tios_derecha.jpg";				
			}			
			miemb.addObject("row_Abuelos_TiosPadres_a",row_Abuelos_TiosPadres_a);
			miemb.addObject("row_Abuelos_TiosPadres_b",row_Abuelos_TiosPadres_b);
			
			String row_TiosPadres_PrimosHermanos_a = "";
			String row_TiosPadres_PrimosHermanos_b = "";
			String row_TiosPadres_PrimosHermanos_c = "";
			if(!miembros_rama1.isEmpty()){
				for (Miembro m : miembros_rama0) {
					if(m.getDescendencia().equals("Rama paterna") && (m.getParentesco().equals("Primo") || m.getParentesco().equals("Prima"))) {
						row_TiosPadres_PrimosHermanos_a = "abuelos-tios_completo.jpg";
						break;
					}else{
						row_TiosPadres_PrimosHermanos_a = "abuelos-tios_simple.jpg";
					}
				}				
				for (Miembro m : miembros_rama0) {
					if(m.getParentesco().equals("Hermano") || m.getParentesco().equals("Hermana")) {
						row_TiosPadres_PrimosHermanos_b = "padres_completo.jpg";
						break;
					}else{
						row_TiosPadres_PrimosHermanos_b = "padres_simple.jpg";
					}
				}				
				for (Miembro m : miembros_rama0) {
					if(m.getDescendencia().equals("Rama materna") && (m.getParentesco().equals("Primo") || m.getParentesco().equals("Prima"))) {
						row_TiosPadres_PrimosHermanos_c = "abuelos-tios_completo.jpg";
						break;
					}else{
						row_TiosPadres_PrimosHermanos_c = "abuelos-tios_simple.jpg";
					}
				}				
			}
			miemb.addObject("row_TiosPadres_PrimosHermanos_a",row_TiosPadres_PrimosHermanos_a);
			miemb.addObject("row_TiosPadres_PrimosHermanos_b",row_TiosPadres_PrimosHermanos_b);
			miemb.addObject("row_TiosPadres_PrimosHermanos_c",row_TiosPadres_PrimosHermanos_c);
			
			//TODO lista completas ordenadas por descendencia			
			
			miemb.setViewName("/arbol/arbol");
		} else {
			miemb = new ModelAndView("error");
		}	
		
		return miemb;

	}	
	
}
