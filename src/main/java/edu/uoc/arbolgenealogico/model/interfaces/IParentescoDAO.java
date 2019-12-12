package edu.uoc.arbolgenealogico.model.interfaces;

import java.util.List;

import javax.sql.DataSource;

import edu.uoc.arbolgenealogico.pojo.Parentesco;

public interface IParentescoDAO {
	
public Parentesco getById(int codigo);
	
	public Parentesco getByDescripcion(String descripcion);

	public Parentesco getByRama(int rama);
	
	public List<Parentesco> getAll();
	
	public void setDatasource(DataSource datasource);

}
