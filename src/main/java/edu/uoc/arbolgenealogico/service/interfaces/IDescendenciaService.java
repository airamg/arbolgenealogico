package edu.uoc.arbolgenealogico.service.interfaces;

import java.util.List;

import edu.uoc.arbolgenealogico.model.DescendenciaDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Descendencia;

public interface IDescendenciaService {
	
	public Descendencia getById(int codigo);
	
	public Descendencia getByTipoRama(String tipoRama);
	
	public List<Descendencia> getAll();
	
	public void setDescendenciaDAO(DescendenciaDAOImpl descendenciaDAO);

}
