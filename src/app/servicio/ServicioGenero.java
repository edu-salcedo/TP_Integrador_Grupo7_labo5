package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.dao.DaoGenero;
import app.entidades.Genero;
import app.interfaces.IABML;

public class ServicioGenero implements IABML<Genero>{
	@Autowired
	@Qualifier("daoGenero")
	private DaoGenero dao;
	
	@Override
	public void create(Genero obj) {
		dao.create(obj);
	}

	@Override
	public Genero readOne(int id) { 
		return dao.readOne(id);
	}

	@Override
	public List<Genero> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Genero> readMany(String param) {
		return dao.readMany(param);
	}

	@Override
	public void update(Genero obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Genero obj) {
		dao.delete(obj);
	}

}
