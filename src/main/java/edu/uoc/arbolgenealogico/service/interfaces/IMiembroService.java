package edu.uoc.arbolgenealogico.service.interfaces;

import java.util.List;

import edu.uoc.arbolgenealogico.model.MiembroDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Miembro;

public interface IMiembroService {
	
	public int create(Miembro m, int idusuario, int idparentesco);
	
	public Miembro getById(int codigo);
	
	public List<Miembro> getByNombre(int idusuario, String nombre);
	
	public List<Miembro> getByApellido(int idusuario, String apellido);
	
	public List<Miembro> getByAnioNacimiento(int idusuario, int anio);
	
	public List<Miembro> getByAnioDefuncion(int idusuario, int anio);
	
	public List<Miembro> getByHistorialMedico(int idusuario, String enfermedad);
	
	public List<Miembro> getByRamaArbol(int idusuario, int rama);
	
	public List<Miembro> getAll(int idusuario);
	
	public int update(Miembro m);
	
	public int updateUsuarioList(int idmiembro, int idusuario);
	
	public int updateParentescoList(int idmiembro, int idparentesco);
	
	public int delete(int codigo);
	
	public void setMiembroDAO(MiembroDAOImpl miembroDAO);

}
