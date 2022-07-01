package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.dao.DaoEstado;
import app.entidades.Estado;
import app.interfaces.IABML;

public class ServicioEstado implements IABML<Estado>{
	@Autowired
	@Qualifier("daoEstado")
	private DaoEstado dao;
	@Override
	public void create(Estado obj) {
		dao.create(obj);
	}

	@Override
	public Estado readOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> readMany(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Estado obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Estado obj) {
		// TODO Auto-generated method stub
		
	}
}
