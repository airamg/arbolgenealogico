package edu.uoc.arbolgenealogico.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.uoc.arbolgenealogico.pojo.Parentesco;

public class ParentescoMapper implements RowMapper<Parentesco>{

	@Override
	public Parentesco mapRow(ResultSet rs, int rowNum) throws SQLException {
		Parentesco parentesco = new Parentesco();
		parentesco.setId(rs.getInt("id"));
		parentesco.setDescripcion(rs.getString("descripcion"));
		parentesco.setRama(rs.getInt("rama"));
	    return parentesco;
	}

}
