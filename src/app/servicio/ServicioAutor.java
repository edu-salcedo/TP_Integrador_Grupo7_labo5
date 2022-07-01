package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.dao.DaoAutor;
import app.entidades.Autor;
import app.interfaces.IABML;

public class ServicioAutor implements IABML<Autor>{
	@Autowired
	@Qualifier("daoAutor")
	private DaoAutor dao;
	
	@Override
	public void create(Autor obj) {
		dao.create(obj);
	}

	@Override
	public Autor readOne(int id) {
		return dao.readOne(id);
	}

	@Override
	public List<Autor> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Autor> readMany(String param) {
		return null;
	}

	@Override
	public void update(Autor obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Autor obj) {
		dao.delete(obj);
		
	}

}
