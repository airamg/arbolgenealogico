package edu.uoc.arbolgenealogico.service;

import java.util.List;

import javax.annotation.Resource;

import edu.uoc.arbolgenealogico.model.ParentescoDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Parentesco;
import edu.uoc.arbolgenealogico.service.interfaces.IParentescoService;

public class ParentescoServiceImpl implements IParentescoService {

	@Resource(name = "parentescoDAO")
	private ParentescoDAOImpl parentescoDAO;

	@Override
	public Parentesco getById(int codigo) {
		Parentesco p= parentescoDAO.getById(codigo);
		return p;
	}

	@Override
	public Parentesco getByDescripcion(String descripcion) {
		Parentesco p= parentescoDAO.getByDescripcion(descripcion);
		return p;
	}

	@Override
	public Parentesco getByRama(int rama) {
		Parentesco p= parentescoDAO.getByRama(rama);
		return p;
	}

	@Override
	public List<Parentesco> getAll() {
		List<Parentesco> parentescos = null;
		parentescos = parentescoDAO.getAll();
		return parentescos;
	}

	@Override
	public void setParentescoDAO(ParentescoDAOImpl parentescoDAO) {
		this.parentescoDAO = parentescoDAO;		
	}

}
