package edu.uoc.arbolgenealogico.controller.usuario;

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
public class CuentaUsuarioController {

	@Autowired
	@Qualifier ("usuarioService")
	private IUsuarioService userservice;
	
	@Autowired
	@Qualifier ("miembroService")
	private IMiembroService miembroservice;
	
	/**
	 * Método que lleva a la cuenta personal del usuario online en la que se muestran todos sus datos
	 * @return ModelAndView
	 */	
	@RequestMapping(value ="/usuarios/cuenta", method = RequestMethod.GET)
	protected ModelAndView cuentausuariocontroller()  {
		
		ModelAndView modeloUsuario = new ModelAndView();
		Usuario user = userservice.getByOnline();
		if(user!=null){
			modeloUsuario.addObject("usuario", user);
			List<Miembro> miembros = miembroservice.getAll(user.getId());		
			modeloUsuario.addObject("lista_miembros",miembros);
			boolean listaMiembrosVacia = false;
			if(miembros.isEmpty()){
				listaMiembrosVacia = true;
			}
			modeloUsuario.addObject("listaMiembrosVacia",listaMiembrosVacia);
			
			modeloUsuario.setViewName("/usuario/cuenta");
		}else{
			modeloUsuario = new ModelAndView("error");
		}

		return modeloUsuario;

	}
}
