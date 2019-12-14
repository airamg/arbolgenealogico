package edu.uoc.arbolgenealogico.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.uoc.arbolgenealogico.model.interfaces.IDescendenciaDAO;
import edu.uoc.arbolgenealogico.model.mappers.DescendenciaMapper;
import edu.uoc.arbolgenealogico.pojo.Descendencia;

@Repository("descendenciaDAO")
public class DescendenciaDAOImpl implements IDescendenciaDAO {

	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public Descendencia getById(int codigo) {
		Descendencia d = null;
		final String SQL = "SELECT id,tipo_rama FROM descendencia WHERE id=?";
		try {
			d = jdbctemplate.queryForObject(SQL, new Object[] { codigo },
					new DescendenciaMapper());
		} catch (EmptyResultDataAccessException e) {
			d = null;
		}
		return d;
	}

	@Override
	public Descendencia getByTipoRama(String tipoRama) {
		Descendencia d = null;
		final String SQL = "SELECT id,tipo_rama FROM descendencia WHERE tipo_rama=?";
		try {
			d = jdbctemplate.queryForObject(SQL, new Object[] { tipoRama },
					new DescendenciaMapper());
		} catch (EmptyResultDataAccessException e) {
			d = null;
		}
		return d;
	}

	@Override
	public List<Descendencia> getAll() {
		List<Descendencia> listd = null;
		final String SQL = "SELECT id,tipo_rama FROM descendencia ORDER BY id";
		try {
			listd = jdbctemplate.query(SQL, new DescendenciaMapper());
		} catch (EmptyResultDataAccessException e) {
			listd = null;
		}
		return listd;
	}

	@Resource(name="myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource=datasource;
		jdbctemplate=new JdbcTemplate(datasource);		
	}
}
