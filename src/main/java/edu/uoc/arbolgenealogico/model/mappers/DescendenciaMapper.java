package edu.uoc.arbolgenealogico.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.uoc.arbolgenealogico.pojo.Descendencia;

public class DescendenciaMapper implements RowMapper<Descendencia>{

	@Override
	public Descendencia mapRow(ResultSet rs, int rowNum) throws SQLException {
		Descendencia descendencia = new Descendencia();
		descendencia.setId(rs.getInt("id"));
		descendencia.setTipoRama(rs.getString("tipo_rama"));
	    return descendencia;
	}

}
