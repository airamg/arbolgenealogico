package edu.uoc.arbolgenealogico.service.interfaces;

import java.util.List;

import edu.uoc.arbolgenealogico.model.ParentescoDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Parentesco;

public interface IParentescoService {

	public Parentesco getById(int codigo);
	
	public Parentesco getByDescripcion(String descripcion);

	public Parentesco getByRama(int rama);
	
	public List<Parentesco> getAll();
	
	public void setParentescoDAO(ParentescoDAOImpl parentescoDAO);

}
