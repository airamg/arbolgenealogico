package edu.uoc.arbolgenealogico.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.uoc.arbolgenealogico.model.interfaces.IUsuarioDAO;
import edu.uoc.arbolgenealogico.model.mappers.UsuarioMapper;
import edu.uoc.arbolgenealogico.pojo.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAOImpl implements IUsuarioDAO {
	
	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public int create(Usuario u) {
		int codigo = -1;
		final String SQL = "INSERT INTO usuario(username,pass,nombre,apellidos,ruta_imagen,online,ultima_conexion) VALUES (?,?,?,?,?,?,?)";
		codigo = jdbctemplate.update(SQL, u.getUsername(), u.getPass(), u.getNombre(),
				u.getApellidos(), u.getRuta_imagen(), u.getOnline(), u.getUltima_conexion());
		return codigo;
	}

	@Override
	public Usuario getById(final int codigo) {
		Usuario u = null;
		final String SQL = "SELECT id,username,pass,nombre,apellidos,ruta_imagen,online,ultima_conexion FROM usuario WHERE id=?";
		try {
			u = jdbctemplate.queryForObject(SQL, new Object[] { codigo },
					new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			u = null;
		}
		return u;
	}
	
	@Override
	public Usuario getByUsername(String username) {
		Usuario u = null;
		final String SQL = "SELECT id,username,pass,nombre,apellidos,ruta_imagen,online,ultima_conexion FROM usuario WHERE username=?";
		try {
			u = jdbctemplate.queryForObject(SQL, new Object[] { username },
					new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			u = null;
		}
		return u;
	}

	@Override
	public Usuario getByOnline() {
		Usuario u = null;
		int online = 1;
		final String SQL = "SELECT id,username,pass,nombre,apellidos,ruta_imagen,online,ultima_conexion FROM usuario WHERE online=?";
		try {
			u = jdbctemplate.queryForObject(SQL, new Object[] { online },
					new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			u = null;
		}
		return u;
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		final String SQL = "SELECT id,username,pass,nombre,apellidos,ruta_imagen,online,ultima_conexion FROM usuario";
		try {
			usuarios = jdbctemplate.query(SQL, new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			usuarios = null;
		}
		return usuarios;
	}

	@Override
	public int update(Usuario u) {
		int codigo = -1;
		final String SQL = "UPDATE usuario SET username=?,pass=?,nombre=?,apellidos=?,ruta_imagen=?,online=?,ultima_conexion=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, u.getUsername(), u.getPass(),
				u.getNombre(), u.getApellidos(), u.getRuta_imagen(),
				u.getOnline(), u.getUltima_conexion(), u.getId());
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = -1;
		final String SQL = "DELETE FROM usuario WHERE id=?";
		cod = jdbctemplate.update(SQL, codigo);
		return cod;
	}

	@Resource(name="myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource=datasource;
		jdbctemplate=new JdbcTemplate(datasource);

	}

}
