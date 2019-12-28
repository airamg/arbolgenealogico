package edu.uoc.arbolgenealogico.controller.arbol;
import java.util.ArrayList;
import java.util.Calendar;
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
		if(user!=null){
			
			int anioActual = Calendar.getInstance().get(Calendar.YEAR);
			Miembro miembroVacio = new Miembro();
			Miembro usuario = new Miembro();
			usuario.setNombre(user.getNombre());
			usuario.setRutaImagen(user.getRuta_imagen());
			usuario.setParentesco("Yo");
			usuario.setHistorialMedico("");
			usuario.setAnioNacimiento(user.getAnio_nacimiento());

			//sacar las listas de miembros que pertenecen al arbol del usuario online por cada rama
			List<Miembro> rama0_primospaternos = miembroservice.getByDescendenciaRama(user.getId(), 0, "Rama paterna");
			List<Miembro> rama0_primosmaternos = miembroservice.getByDescendenciaRama(user.getId(), 0, "Rama materna");
			List<Miembro> rama0_hermanos = miembroservice.getByDescendenciaRama(user.getId(), 0, "");
			List<Miembro> rama1_tiospaternos = miembroservice.getByDescendenciaRama(user.getId(), 1, "Rama paterna");
			List<Miembro> rama1_tiosmaternos = miembroservice.getByDescendenciaRama(user.getId(), 1, "Rama materna");
			List<Miembro> rama1_padres = miembroservice.getByDescendenciaRama(user.getId(), 1, "");
			List<Miembro> rama2_abuelospaternos = miembroservice.getByDescendenciaRama(user.getId(), 2, "Rama paterna");
			List<Miembro> rama2_abuelosmaternos = miembroservice.getByDescendenciaRama(user.getId(), 2, "Rama materna");
			String row_Abuelos_TiosPadres_a = "";
			String row_Abuelos_TiosPadres_b = "";
			String row_TiosPadres_PrimosHermanos_a = "";
			String row_TiosPadres_PrimosHermanos_b = "padres_simple.jpg";
			String row_TiosPadres_PrimosHermanos_c = "";

			//RAMA 2			
			if(rama2_abuelospaternos.isEmpty()){
				rama2_abuelospaternos.add(miembroVacio);
				rama2_abuelospaternos.add(miembroVacio);
				rama2_abuelospaternos.add(miembroVacio);
			}else{ 
				row_Abuelos_TiosPadres_a = "abuelos-tios_simple.jpg";
				if(rama2_abuelospaternos.size()==1){
					rama2_abuelospaternos.add(miembroVacio);
					rama2_abuelospaternos.add(miembroVacio);
				}else{
					Miembro a1 = rama2_abuelospaternos.get(0);				
					Miembro a2 = rama2_abuelospaternos.get(1);
					rama2_abuelospaternos.clear();
					rama2_abuelospaternos.add(a1);
					rama2_abuelospaternos.add(miembroVacio);
					rama2_abuelospaternos.add(a2);					
				}
				if(!rama1_tiospaternos.isEmpty()){
					row_Abuelos_TiosPadres_a = "abuelos-tios_izquierda.jpg";
				}				
			}
			if(rama2_abuelosmaternos.isEmpty()){
				rama2_abuelosmaternos.add(miembroVacio);
				rama2_abuelosmaternos.add(miembroVacio);
				rama2_abuelosmaternos.add(miembroVacio);
			}else{ 
				row_Abuelos_TiosPadres_b = "abuelos-tios_simple.jpg";
				if(rama2_abuelosmaternos.size()==1){
					rama2_abuelosmaternos.add(miembroVacio);
					rama2_abuelosmaternos.add(miembroVacio);
				}else{
					Miembro a1 = rama2_abuelosmaternos.get(0);
					Miembro a2 = rama2_abuelosmaternos.get(1);
					rama2_abuelosmaternos.clear();
					rama2_abuelosmaternos.add(a1);
					rama2_abuelosmaternos.add(miembroVacio);
					rama2_abuelosmaternos.add(a2);					
				}	
				if(!rama1_tiosmaternos.isEmpty()){
					row_Abuelos_TiosPadres_b = "abuelos-tios_derecha.jpg";
				}				
			}
			List<Miembro> lista_miembros_rama2 = new ArrayList<Miembro>();
			lista_miembros_rama2.add(miembroVacio);
			lista_miembros_rama2.add(miembroVacio);
			for(Miembro m : rama2_abuelospaternos){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama2.add(m);
			}
			lista_miembros_rama2.add(miembroVacio);
			for(Miembro m : rama2_abuelosmaternos){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama2.add(m);
			}
			lista_miembros_rama2.add(miembroVacio);
			lista_miembros_rama2.add(miembroVacio);
			miemb.addObject("lista_miembros_rama2",lista_miembros_rama2);
			
			//RAMA 1			
			if(rama1_tiospaternos.isEmpty()){
				rama1_tiospaternos.add(miembroVacio);
				rama1_tiospaternos.add(miembroVacio);
				rama1_tiospaternos.add(miembroVacio);
			}else{ 
				row_Abuelos_TiosPadres_a = "abuelos-tios_izquierda.jpg";
				row_TiosPadres_PrimosHermanos_a = "abuelos-tios_simple.jpg";
				if(rama1_tiospaternos.size()==1){
					Miembro t = rama1_tiospaternos.get(0);
					rama1_tiospaternos.clear();
					rama1_tiospaternos.add(miembroVacio);
					rama1_tiospaternos.add(miembroVacio);
					rama1_tiospaternos.add(t);
				}else{
					Miembro t1 = rama1_tiospaternos.get(0);
					Miembro t2 = rama1_tiospaternos.get(1);
					rama1_tiospaternos.clear();
					rama1_tiospaternos.add(t1);
					rama1_tiospaternos.add(miembroVacio);
					rama1_tiospaternos.add(t2);
				}	
				if(!rama0_primospaternos.isEmpty()){
					if(rama0_primospaternos.size()==2){
						row_TiosPadres_PrimosHermanos_a = "abuelos-tios_izquierda.jpg";
					}else if(rama0_primospaternos.size()==3){
						row_TiosPadres_PrimosHermanos_a = "abuelos-tios_completo.jpg";
					}										
				}				
			}
			if(rama1_tiosmaternos.isEmpty()){
				rama1_tiosmaternos.add(miembroVacio);
				rama1_tiosmaternos.add(miembroVacio);
				rama1_tiosmaternos.add(miembroVacio);
			}else{ 
				row_Abuelos_TiosPadres_b = "abuelos-tios_derecha.jpg";
				row_TiosPadres_PrimosHermanos_c = "abuelos-tios_simple.jpg";
				if(rama1_tiosmaternos.size()==1){
					Miembro t = rama1_tiosmaternos.get(0);
					rama1_tiosmaternos.clear();
					rama1_tiosmaternos.add(t);
					rama1_tiosmaternos.add(miembroVacio);
					rama1_tiosmaternos.add(miembroVacio);					
				}else{
					Miembro t1 = rama1_tiosmaternos.get(0);
					Miembro t2 = rama1_tiosmaternos.get(1);
					rama1_tiosmaternos.clear();
					rama1_tiosmaternos.add(t1);
					rama1_tiosmaternos.add(miembroVacio);
					rama1_tiosmaternos.add(t2);
				}	
				if(!rama0_primosmaternos.isEmpty()){
					if(rama0_primosmaternos.size()==2){
						row_TiosPadres_PrimosHermanos_c = "abuelos-tios_derecha.jpg";
					}else if(rama0_primosmaternos.size()==3){
						row_TiosPadres_PrimosHermanos_c = "abuelos-tios_completo.jpg";
					}										
				}				
			}
			if(rama1_padres.isEmpty()){
				rama1_padres.add(miembroVacio);
				rama1_padres.add(miembroVacio);
				rama1_padres.add(miembroVacio);
				rama1_padres.add(miembroVacio);
				rama1_padres.add(miembroVacio);
			}else{				
				if(rama1_padres.size()==1){
					if(rama1_padres.get(0).getParentesco().equals("Padre")){
						Miembro padre = rama1_padres.get(0);
						rama1_padres.clear();
						rama1_padres.add(padre);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
					}else{
						Miembro madre = rama1_padres.get(0);
						rama1_padres.clear();
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(madre);						
					}					
				}else{
					if(rama1_padres.get(0).getParentesco().equals("Padre")){
						Miembro padre = rama1_padres.get(0);
						Miembro madre = rama1_padres.get(1);
						rama1_padres.clear();
						rama1_padres.add(padre);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(madre);
					}else{
						Miembro madre = rama1_padres.get(0);
						Miembro padre = rama1_padres.get(1);
						rama1_padres.clear();
						rama1_padres.add(padre);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(miembroVacio);
						rama1_padres.add(madre);						
					}
				}
				if(!rama0_hermanos.isEmpty()){
					if(rama0_hermanos.size()==1){
						row_TiosPadres_PrimosHermanos_b = "padres_izquierda.jpg";
					}else if(rama0_hermanos.size()==2){
						row_TiosPadres_PrimosHermanos_b = "padres_completo.jpg";
					}										
				}				
			}
			List<Miembro> lista_miembros_rama1 = new ArrayList<Miembro>();
			for(Miembro m : rama1_tiospaternos){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama1.add(m);
			}
			for(Miembro m : rama1_padres){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama1.add(m);
			}
			for(Miembro m : rama1_tiosmaternos){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama1.add(m);
			}
			miemb.addObject("lista_miembros_rama1",lista_miembros_rama1);
			

			//RAMA 0
			if(rama0_primospaternos.isEmpty()){
				rama0_primospaternos.add(miembroVacio);
				rama0_primospaternos.add(miembroVacio);
				rama0_primospaternos.add(miembroVacio);
			}else{ 
				row_Abuelos_TiosPadres_a = "abuelos-tios_izquierda.jpg";
				if(rama0_primospaternos.size()==1){
					row_TiosPadres_PrimosHermanos_a = "abuelos-tios_simple.jpg";
					Miembro p1 = rama0_primospaternos.get(0);
					rama0_primospaternos.clear();
					rama0_primospaternos.add(miembroVacio);
					rama0_primospaternos.add(p1);
					rama0_primospaternos.add(miembroVacio);
				}else if(rama0_primospaternos.size()==2){
					row_TiosPadres_PrimosHermanos_a = "abuelos-tios_izquierda.jpg";
					Miembro p1 = rama0_primospaternos.get(0);
					Miembro p2 = rama0_primospaternos.get(1);
					rama0_primospaternos.clear();
					rama0_primospaternos.add(p1);
					rama0_primospaternos.add(p2);
					rama0_primospaternos.add(miembroVacio);
				}else if(rama0_primospaternos.size()==3){
					row_TiosPadres_PrimosHermanos_a = "abuelos-tios_completo.jpg";
					Miembro p1 = rama0_primospaternos.get(0);
					Miembro p2 = rama0_primospaternos.get(1);
					Miembro p3 = rama0_primospaternos.get(2);
					rama0_primospaternos.clear();
					rama0_primospaternos.add(p1);
					rama0_primospaternos.add(p2);
					rama0_primospaternos.add(p3);
				}
			}
			if(rama0_primosmaternos.isEmpty()){
				rama0_primosmaternos.add(miembroVacio);
				rama0_primosmaternos.add(miembroVacio);
				rama0_primosmaternos.add(miembroVacio);
			}else{ 
				row_Abuelos_TiosPadres_b = "abuelos-tios_derecha.jpg";
				if(rama0_primosmaternos.size()==1){
					row_TiosPadres_PrimosHermanos_c = "abuelos-tios_simple.jpg";
					Miembro p1 = rama0_primosmaternos.get(0);
					rama0_primosmaternos.clear();
					rama0_primosmaternos.add(miembroVacio);
					rama0_primosmaternos.add(p1);
					rama0_primosmaternos.add(miembroVacio);
				}else if(rama0_primosmaternos.size()==2){
					row_TiosPadres_PrimosHermanos_c = "abuelos-tios_derecha.jpg";
					Miembro p1 = rama0_primosmaternos.get(0);
					Miembro p2 = rama0_primosmaternos.get(1);
					rama0_primosmaternos.clear();
					rama0_primosmaternos.add(miembroVacio);
					rama0_primosmaternos.add(p1);
					rama0_primosmaternos.add(p2);					
				}else if(rama0_primosmaternos.size()==3){
					row_TiosPadres_PrimosHermanos_c = "abuelos-tios_completo.jpg";
					Miembro p1 = rama0_primosmaternos.get(0);
					Miembro p2 = rama0_primosmaternos.get(1);
					Miembro p3 = rama0_primosmaternos.get(2);
					rama0_primosmaternos.clear();
					rama0_primosmaternos.add(p3);
					rama0_primosmaternos.add(p1);
					rama0_primosmaternos.add(p2);					
				}				
			}
			if(rama0_hermanos.isEmpty()){
				rama0_hermanos.add(miembroVacio);
				rama0_hermanos.add(usuario);
				rama0_hermanos.add(miembroVacio);
			}else{ 
				if(rama0_hermanos.size()==1){
					row_TiosPadres_PrimosHermanos_b = "padres_izquierda.jpg";
					Miembro h = rama0_hermanos.get(0);
					rama0_hermanos.clear();
					rama0_hermanos.add(h);
					rama0_hermanos.add(usuario);
					rama0_hermanos.add(miembroVacio);
				}else {
					row_TiosPadres_PrimosHermanos_b = "padres_completo.jpg";
					Miembro h1 = rama0_hermanos.get(0);
					Miembro h2 = rama0_hermanos.get(1);
					rama0_hermanos.clear();
					rama0_hermanos.add(h1);
					rama0_hermanos.add(usuario);
					rama0_hermanos.add(h2);					
				}				
			}
			List<Miembro> lista_miembros_rama0 = new ArrayList<Miembro>();
			for(Miembro m : rama0_primospaternos){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama0.add(m);
			}
			lista_miembros_rama0.add(miembroVacio);
			for(Miembro m : rama0_hermanos){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama0.add(m);
			}
			lista_miembros_rama0.add(miembroVacio);
			for(Miembro m : rama0_primosmaternos){
				if(!m.getAnioDefuncion().equals("")){
					m.setEdad("Fallecido en " +m.getAnioDefuncion());
				}else if(!m.getAnioNacimiento().equals("")){
					int edad_m = anioActual - Integer.parseInt(m.getAnioNacimiento());
					m.setEdad(edad_m + " años");
				}
				lista_miembros_rama0.add(m);
			}
			miemb.addObject("lista_miembros_rama0",lista_miembros_rama0);	
			
			miemb.addObject("row_Abuelos_TiosPadres_a",row_Abuelos_TiosPadres_a);
			miemb.addObject("row_Abuelos_TiosPadres_b",row_Abuelos_TiosPadres_b);
			miemb.addObject("row_TiosPadres_PrimosHermanos_a",row_TiosPadres_PrimosHermanos_a);
			miemb.addObject("row_TiosPadres_PrimosHermanos_b",row_TiosPadres_PrimosHermanos_b);
			miemb.addObject("row_TiosPadres_PrimosHermanos_c",row_TiosPadres_PrimosHermanos_c);

			miemb.setViewName("/arbol/arbol");
		} else {
			miemb = new ModelAndView("error");
		}	
		
		return miemb;

	}	
	
}
