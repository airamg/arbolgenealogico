package edu.uoc.arbolgenealogico.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.uoc.arbolgenealogico.pojo.Miembro;

public class MiembroMapper implements RowMapper<Miembro> {

	@Override
	public Miembro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Miembro miembro = new Miembro();
		miembro.setId(rs.getInt("id"));
		miembro.setNombre(rs.getString("nombre"));
		miembro.setApellido(rs.getString("apellido"));
		miembro.setRutaImagen(rs.getString("ruta_imagen"));
		miembro.setAnioNacimiento(rs.getInt("anio_nacimiento"));
		miembro.setAnioDefuncion(rs.getInt("anio_defuncion"));
		miembro.setHistorialMedico(rs.getString("historial_medico"));
	    return miembro;
	}

}
