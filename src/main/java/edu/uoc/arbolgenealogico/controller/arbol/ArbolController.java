package edu.uoc.arbolgenealogico.controller.arbol;
import java.util.ArrayList;
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

			//devolver el tipo de rama para unir cada miembro
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
			
			//ordenar las listas para mostrar cada miembro en su sitio del arbol
			Miembro miembroVacio = new Miembro();
			
			//RAMA 0
			List<Miembro> rama0_primospaternos = new ArrayList<Miembro>();
			List<Miembro> rama0_hermanos = new ArrayList<Miembro>();			
			List<Miembro> rama0_primosmaternos = new ArrayList<Miembro>();
			if(miembros_rama0.isEmpty()){
				rama0_primospaternos.add(miembroVacio);
				rama0_primospaternos.add(miembroVacio);
				rama0_primospaternos.add(miembroVacio);
				rama0_primosmaternos.add(miembroVacio);
				rama0_primosmaternos.add(miembroVacio);
				rama0_primosmaternos.add(miembroVacio);
				rama0_hermanos.add(miembroVacio);
				rama0_hermanos.add(miembroVacio);
			}
			miemb.addObject("usuario",user);
			
			//RAMA 1
			List<Miembro> rama1_tiospaternos = new ArrayList<Miembro>();
			List<Miembro> rama1_padres = new ArrayList<Miembro>();
			List<Miembro> rama1_tiosmaternos = new ArrayList<Miembro>();
			if(miembros_rama1.isEmpty()){
				rama1_tiospaternos.add(miembroVacio);
				rama1_tiospaternos.add(miembroVacio);
				rama1_tiosmaternos.add(miembroVacio);
				rama1_tiosmaternos.add(miembroVacio);
				rama1_padres.add(miembroVacio);
				rama1_padres.add(miembroVacio);
			}
			
			//RAMA 2
			List<Miembro> rama2_abuelospaternos = new ArrayList<Miembro>();
			List<Miembro> rama2_abuelosmaternos = new ArrayList<Miembro>();
			if(miembros_rama2.isEmpty()){
				rama2_abuelospaternos.add(miembroVacio);
				rama2_abuelospaternos.add(miembroVacio);
				rama2_abuelosmaternos.add(miembroVacio);
				rama2_abuelosmaternos.add(miembroVacio);
			}else{
				rama2_abuelospaternos = miembroservice.getByDescendenciaRama(user.getId(), 2, "Rama paterna");
				if(rama2_abuelospaternos.isEmpty()){
					rama2_abuelospaternos.add(miembroVacio);
					rama2_abuelospaternos.add(miembroVacio);
					row_Abuelos_TiosPadres_a = "";
				}else{ 
					if(rama2_abuelospaternos.size()==1){
						rama2_abuelospaternos.add(miembroVacio);
					}	
					if(!rama1_tiospaternos.isEmpty()){
						row_Abuelos_TiosPadres_a = "abuelos-tios_izquierda.jpg";
					}
					row_Abuelos_TiosPadres_a = "abuelos-tios_simple.jpg";
				}
				rama2_abuelosmaternos = miembroservice.getByDescendenciaRama(user.getId(), 2, "Rama materna");
				if(rama2_abuelosmaternos.isEmpty()){
					rama2_abuelosmaternos.add(miembroVacio);
					rama2_abuelosmaternos.add(miembroVacio);
					row_Abuelos_TiosPadres_b = "";
				}else{ 
					if(rama2_abuelosmaternos.size()==1){
						rama2_abuelosmaternos.add(miembroVacio);
					}	
					if(!rama1_tiosmaternos.isEmpty()){
						row_Abuelos_TiosPadres_b = "abuelos-tios_derecha.jpg";
					}
					row_Abuelos_TiosPadres_b = "abuelos-tios_simple.jpg";
				}				
			}
			miemb.addObject("rama2_abuelospaternos",rama2_abuelospaternos);
			miemb.addObject("rama2_abuelosmaternos",rama2_abuelosmaternos);
			miemb.addObject("rama2-1_row_a",row_Abuelos_TiosPadres_a);
			miemb.addObject("rama2-1_row_b",row_Abuelos_TiosPadres_b);

			miemb.setViewName("/arbol/arbol");
		} else {
			miemb = new ModelAndView("error");
		}	
		
		return miemb;

	}	
	
}
