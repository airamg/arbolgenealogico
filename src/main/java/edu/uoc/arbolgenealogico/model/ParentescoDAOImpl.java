package edu.uoc.arbolgenealogico.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.uoc.arbolgenealogico.model.interfaces.IParentescoDAO;
import edu.uoc.arbolgenealogico.model.mappers.ParentescoMapper;
import edu.uoc.arbolgenealogico.pojo.Parentesco;

@Repository("parentescoDAO")
public class ParentescoDAOImpl implements IParentescoDAO {

	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public Parentesco getById(int codigo) {
		Parentesco p = null;
		final String SQL = "SELECT id,descripcion,rama FROM parentesco WHERE id=?";
		try {
			p = jdbctemplate.queryForObject(SQL, new Object[] { codigo },
					new ParentescoMapper());
		} catch (EmptyResultDataAccessException e) {
			p = null;
		}
		return p;
	}

	@Override
	public Parentesco getByDescripcion(String descripcion) {
		Parentesco p = null;
		final String SQL = "SELECT id,descripcion,rama FROM parentesco WHERE descripcion=?";
		try {
			p = jdbctemplate.queryForObject(SQL, new Object[] { descripcion },
					new ParentescoMapper());
		} catch (EmptyResultDataAccessException e) {
			p = null;
		}
		return p;
	}

	@Override
	public Parentesco getByRama(int rama) {
		Parentesco p = null;
		final String SQL = "SELECT id,descripcion,rama FROM parentesco WHERE rama=?";
		try {
			p = jdbctemplate.queryForObject(SQL, new Object[] { rama },
					new ParentescoMapper());
		} catch (EmptyResultDataAccessException e) {
			p = null;
		}
		return p;
	}

	@Override
	public List<Parentesco> getAll() {
		List<Parentesco> listp = null;
		final String SQL = "SELECT id,descripcion,rama FROM parentesco";
		try {
			listp = jdbctemplate.query(SQL, new ParentescoMapper());
		} catch (EmptyResultDataAccessException e) {
			listp = null;
		}
		return listp;
	}

	@Resource(name="myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource=datasource;
		jdbctemplate=new JdbcTemplate(datasource);		
	}
}
