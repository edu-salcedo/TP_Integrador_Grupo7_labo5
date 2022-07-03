package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.dao.DaoLibro;
import app.entidades.Libro;
import app.interfaces.IABML;

public class ServicioLibro implements IABML<Libro>{
	@Autowired
	@Qualifier("daoLibro")
	private DaoLibro dao;
	
	@Override
	public void create(Libro obj) {
		dao.create(obj);
	}

	@Override
	public Libro readOne(int isbn) {
		return dao.readOne(isbn);
	}

	@Override
	public List<Libro> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Libro> readMany(String param) {
		return dao.readMany(param);
	}

	@Override
	public void update(Libro obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Libro obj) {
		dao.delete(obj);
	}

}
