package edu.uoc.arbolgenealogico.model.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.uoc.arbolgenealogico.pojo.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int column) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setUsername(rs.getString("username"));
		usuario.setPass(rs.getString("pass"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setEmail(rs.getString("email"));
		usuario.setRuta_imagen(rs.getString("ruta_imagen"));
		usuario.setOnline(rs.getInt("online"));
		usuario.setUltima_conexion(rs.getDate("ultima_conexion"));
	    return usuario;
	}	
}
