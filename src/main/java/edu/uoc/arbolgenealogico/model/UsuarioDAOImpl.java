package edu.uoc.arbolgenealogico.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.uoc.arbolgenealogico.model.interfaces.IUsuarioDAO;
import edu.uoc.arbolgenealogico.pojo.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAOImpl implements IUsuarioDAO {
	
	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public int create(Usuario u) {
		int codigo = -1;
		return codigo;
	}

	@Override
	public Usuario getById(final int codigo) {
		Usuario u = null;
		return u;
	}
	
	@Override
	public Usuario getByUsername(String username) {
		Usuario u = null;
		return u;
	}

	@Override
	public Usuario getByOnline() {
		Usuario u = null;
		return u;
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		return usuarios;
	}

	@Override
	public int update(Usuario u) {
		int codigo = -1;
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = -1;
		return cod;
	}

	@Resource(name="myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource=datasource;
		jdbctemplate=new JdbcTemplate(datasource);

	}

}
