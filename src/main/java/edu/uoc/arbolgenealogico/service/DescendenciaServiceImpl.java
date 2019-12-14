package edu.uoc.arbolgenealogico.service;

import java.util.List;

import javax.annotation.Resource;

import edu.uoc.arbolgenealogico.model.DescendenciaDAOImpl;
import edu.uoc.arbolgenealogico.pojo.Descendencia;
import edu.uoc.arbolgenealogico.service.interfaces.IDescendenciaService;

public class DescendenciaServiceImpl implements IDescendenciaService {

	@Resource(name = "descendenciaDAO")
	private DescendenciaDAOImpl descendenciaDAO;

	@Override
	public Descendencia getById(int codigo) {
		Descendencia d = descendenciaDAO.getById(codigo);
		return d;
	}

	@Override
	public Descendencia getByTipoRama(String tipoRama) {
		Descendencia d = descendenciaDAO.getByTipoRama(tipoRama);
		return d;
	}

	@Override
	public List<Descendencia> getAll() {
		List<Descendencia> descendencias = null;
		descendencias = descendenciaDAO.getAll();
		return descendencias;
	}

	@Override
	public void setDescendenciaDAO(DescendenciaDAOImpl descendenciaDAO) {
		this.descendenciaDAO = descendenciaDAO;		
	}
	

}
