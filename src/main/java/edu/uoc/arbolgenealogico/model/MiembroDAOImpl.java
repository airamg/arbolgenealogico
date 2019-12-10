package edu.uoc.arbolgenealogico.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.uoc.arbolgenealogico.model.interfaces.IMiembroDAO;
import edu.uoc.arbolgenealogico.model.mappers.MiembroMapper;
import edu.uoc.arbolgenealogico.pojo.Miembro;

@Repository("miembroDAO")
public class MiembroDAOImpl implements IMiembroDAO {

	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;


	@Override
	public int create(Miembro m, int idusuario, int idparentesco) {
		int codigo;
		final String SQL = "INSERT INTO miembro(nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,usuario,parentesco) VALUES (?,?,?,?,?,?,?,?)";
		codigo = jdbctemplate.update(SQL, m.getNombre(), m.getApellido(), m.getRutaImagen(), m.getAnioNacimiento(), m.getAnioDefuncion(), m.getHistorialMedico(), idusuario, idparentesco);
		return codigo;
	}

	@Override
	public Miembro getById(int codigo) {
		Miembro miembro = null;
		final String SQL = "SELECT id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,usuario,parentesco FROM miembro WHERE id=?";
		try {
			miembro = jdbctemplate.queryForObject(SQL, new Object[] { codigo },
					new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembro = null;
		}
		return miembro;
	}

	@Override
	public List<Miembro> getByNombre(int idusuario, String nombre) {
		List<Miembro> miembros = null;
		final String SQL = "SELECT miembro.id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,descripcion FROM miembro INNER JOIN parentesco ON miembro.parentesco=parentesco.id WHERE usuario=? and nombre=?";
		try {
			miembros = jdbctemplate.query(SQL, new Object[] { idusuario, nombre }, new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembros = null;
		}
		return miembros;
	}

	@Override
	public List<Miembro> getByApellido(int idusuario, String apellido) {
		List<Miembro> miembros = null;
		final String SQL = "SELECT miembro.id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,descripcion FROM miembro INNER JOIN parentesco ON miembro.parentesco=parentesco.id WHERE usuario=? and apellido=?";
		try {
			miembros = jdbctemplate.query(SQL, new Object[] { idusuario, apellido }, new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembros = null;
		}
		return miembros;
	}

	@Override
	public List<Miembro> getByAnioNacimiento(int idusuario, int anio) {
		List<Miembro> miembros = null;
		final String SQL = "SELECT miembro.id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,descripcion FROM miembro INNER JOIN parentesco ON miembro.parentesco=parentesco.id WHERE usuario=? and anio_nacimiento=?";
		try {
			miembros = jdbctemplate.query(SQL, new Object[] { idusuario, anio }, new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembros = null;
		}
		return miembros;
	}

	@Override
	public List<Miembro> getByAnioDefuncion(int idusuario, int anio) {
		List<Miembro> miembros = null;
		final String SQL = "SELECT miembro.id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,descripcion FROM miembro INNER JOIN parentesco ON miembro.parentesco=parentesco.id WHERE usuario=? and anio_defuncion=?";
		try {
			miembros = jdbctemplate.query(SQL, new Object[] { idusuario, anio }, new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembros = null;
		}
		return miembros;
	}

	@Override
	public List<Miembro> getByHistorialMedico(int idusuario, String enfermedad) {
		List<Miembro> miembros = null;
		final String SQL = "SELECT miembro.id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,descripcion FROM miembro INNER JOIN parentesco ON miembro.parentesco=parentesco.id WHERE usuario=? and historial_medico=?";
		try {
			miembros = jdbctemplate.query(SQL, new Object[] { idusuario, enfermedad }, new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembros = null;
		}
		return miembros;
	}

	@Override
	public List<Miembro> getByRamaArbol(int idusuario, int rama) {
		List<Miembro> miembros = null;
		final String SQL = "SELECT miembro.id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,descripcion FROM miembro INNER JOIN parentesco ON miembro.parentesco=parentesco.id WHERE usuario=? and rama=?";
		try {
			miembros = jdbctemplate.query(SQL, new Object[] { idusuario, rama }, new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembros = null;
		}
		return miembros;
	}

	@Override
	public List<Miembro> getAll(int idusuario) {
		List<Miembro> miembros = null;
		final String SQL = "SELECT id,nombre,apellido,ruta_imagen,anio_nacimiento,anio_defuncion,historial_medico,usuario,parentesco FROM miembro WHERE usuario=?";
		try {
			miembros = jdbctemplate.query(SQL, new Object[] { idusuario }, new MiembroMapper());
		} catch (EmptyResultDataAccessException e) {
			miembros = null;
		}
		return miembros;
	}

	@Override
	public int update(Miembro m) {
		int codigo = -1;
		final String SQL = "UPDATE miembro SET nombre=?,apellido=?,ruta_imagen=?,anio_nacimiento=?,anio_defuncion=?,historial_medico=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, m.getNombre(), m.getApellido(), m.getRutaImagen(), m.getAnioNacimiento(), m.getAnioDefuncion(), m.getHistorialMedico(), m.getId());
		return codigo;
	}

	@Override
	public int updateUsuarioList(int idmiembro, int idusuario) {
		int codigo = -1;
		final String SQL = "UPDATE miembro SET usuario=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, idusuario, idmiembro);
		return codigo;
	}

	@Override
	public int updateParentescoList(int idmiembro, int idparentesco) {
		int codigo = -1;
		final String SQL = "UPDATE miembro SET parentesco=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, idparentesco, idmiembro);
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = -1;
		final String SQL = "DELETE FROM miembro WHERE id=?";
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
