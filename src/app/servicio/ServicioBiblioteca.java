package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.dao.DaoBiblioteca;
import app.entidades.Biblioteca;
import app.interfaces.IABML;

public class ServicioBiblioteca implements IABML<Biblioteca> {
	@Autowired
	@Qualifier("daoBiblioteca")
	private DaoBiblioteca dao;
	@Override
	public void create(Biblioteca obj) {
		dao.create(obj);
	}

	@Override
	public Biblioteca readOne(int id) {
		return dao.readOne(id);
	}

	@Override
	public List<Biblioteca> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Biblioteca> readMany(String param) {
		return dao.readMany(param);
	}

	@Override
	public void update(Biblioteca obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Biblioteca obj) {
		dao.delete(obj);
	}

	public List<Biblioteca> readByIdEstado(int id) {
		return dao.readByIdEstado(id);
	}

}
