package edu.uoc.arbolgenealogico.service;

import java.util.List;

import javax.annotation.Resource;

import edu.uoc.arbolgenealogico.model.UsuarioDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Usuario;
import edu.uoc.arbolgenealogico.service.interfaces.IUsuarioService;

public class UsuarioServiceImpl implements IUsuarioService {

	@Resource(name = "usuarioDAO")
	private UsuarioDAOImpl usuarioDAO;

	@Override
	public int create(Usuario u) {
		int codigo = usuarioDAO.create(u);
		return codigo;
	}

	@Override
	public Usuario getById(int codigo) {
		Usuario u= usuarioDAO.getById(codigo);
		return u;
	}
	
	@Override
	public Usuario getByUsername(String username) {
		Usuario u = usuarioDAO.getByUsername(username);
		return u;
	}

	@Override
	public Usuario getByOnline() {
		Usuario u = usuarioDAO.getByOnline();
		return u;
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		usuarios = usuarioDAO.getAll();
		return usuarios;
	}

	@Override
	public int update(Usuario u) {
		int codigo = usuarioDAO.update(u);
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = usuarioDAO.delete(codigo);
		return cod;
	}

	@Override
	public void setUsuarioDAO(UsuarioDAOImpl usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
