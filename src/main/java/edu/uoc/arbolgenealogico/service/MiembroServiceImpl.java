package edu.uoc.arbolgenealogico.service;

import java.util.List;

import javax.annotation.Resource;

import edu.uoc.arbolgenealogico.model.MiembroDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Miembro;
import edu.uoc.arbolgenealogico.service.interfaces.IMiembroService;

public class MiembroServiceImpl implements IMiembroService {

	@Resource(name = "miembroDAO")
	private MiembroDAOImpl miembroDAO;

	@Override
	public int create(Miembro m, int idusuario, int idparentesco, int iddescendencia) {
		int codigo=miembroDAO.create(m, idusuario, idparentesco, iddescendencia);
		return codigo;
	}

	@Override
	public Miembro getById(int codigo) {
		Miembro miembro = miembroDAO.getById(codigo);
	    return miembro;
	}

	@Override
	public List<Miembro> getByNombre(int idusuario, String nombre) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getByNombre(idusuario, nombre);
		return miembros;
	}

	@Override
	public List<Miembro> getByApellido(int idusuario, String apellido) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getByApellido(idusuario, apellido);
		return miembros;
	}

	@Override
	public List<Miembro> getByAnioNacimiento(int idusuario, int anio) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getByAnioNacimiento(idusuario, anio);
		return miembros;
	}

	@Override
	public List<Miembro> getByAnioDefuncion(int idusuario, int anio) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getByAnioDefuncion(idusuario, anio);
		return miembros;
	}

	@Override
	public List<Miembro> getByHistorialMedico(int idusuario, String enfermedad) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getByHistorialMedico(idusuario, enfermedad);
		return miembros;
	}

	@Override
	public List<Miembro> getByRamaArbol(int idusuario, int rama) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getByRamaArbol(idusuario, rama);
		return miembros;
	}
	
	@Override
	public List<Miembro> getByDescendenciaRama(int idusuario, int rama, String descendencia) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getByDescendenciaRama(idusuario, rama, descendencia);
		return miembros;
	}

	@Override
	public List<Miembro> getAll(int idusuario) {
		List<Miembro> miembros=null;
		miembros = miembroDAO.getAll(idusuario);
		return miembros;
	}

	@Override
	public int update(Miembro m) {
		int codigo=miembroDAO.update(m);
		return codigo;
	}

	@Override
	public int updateUsuarioList(int idmiembro, int idusuario) {
		int codigo=miembroDAO.updateUsuarioList(idmiembro, idusuario);
		return codigo;
	}

	@Override
	public int updateParentescoList(int idmiembro, int idparentesco) {
		int codigo=miembroDAO.updateParentescoList(idmiembro, idparentesco);
		return codigo;
	}
	
	@Override
	public int updateDescendenciaList(int idmiembro, int iddescendencia) {
		int codigo=miembroDAO.updateDescendenciaList(idmiembro, iddescendencia);
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod=miembroDAO.delete(codigo);
		return cod;
	}

	@Override
	public void setMiembroDAO(MiembroDAOImpl miembroDAO) {
		this.miembroDAO = miembroDAO;
	}

}
