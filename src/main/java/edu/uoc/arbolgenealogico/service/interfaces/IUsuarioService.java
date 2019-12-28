package edu.uoc.arbolgenealogico.service.interfaces;

import java.util.List;

import edu.uoc.arbolgenealogico.model.UsuarioDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Usuario;

public interface IUsuarioService {
	
	public int create(Usuario u);

	public Usuario getById(int codigo);
	
	public Usuario getByUsername(String username);

	public Usuario getByOnline();

	public List<Usuario> getAll();
	
	public int update(Usuario u);
	
	public int delete(int codigo);
	
	public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO);

}
