package edu.uoc.arbolgenealogico.model.interfaces;

import java.util.List;

import javax.sql.DataSource;

import edu.uoc.arbolgenealogico.pojo.Descendencia;

public interface IDescendenciaDAO {

	public Descendencia getById(int codigo);
	
	public Descendencia getByTipoRama(String tipoRama);
	
	public List<Descendencia> getAll();
	
	public void setDatasource(DataSource datasource);

}
