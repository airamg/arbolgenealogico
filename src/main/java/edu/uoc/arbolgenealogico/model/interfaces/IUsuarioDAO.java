package edu.uoc.arbolgenealogico.model.interfaces;

import java.util.List;

import javax.sql.DataSource;

import edu.uoc.arbolgenealogico.pojo.Usuario;

public interface IUsuarioDAO {
	
	public int create(Usuario u);
	
	public Usuario getById(int codigo);
	
	public Usuario getByUsername(String username);
	
	public Usuario getByOnline();
	
	public List<Usuario> getAll();
	
	public int update(Usuario u);
	
	public int delete(int codigo);
	
	public void setDatasource(DataSource datasource);

}
