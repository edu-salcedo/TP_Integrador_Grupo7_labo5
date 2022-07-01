package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.dao.DaoPrestamo;
import app.entidades.Prestamo;
import app.interfaces.IABML;

public class ServicioPrestamo implements IABML <Prestamo>{
	@Autowired
	@Qualifier("daoPrestamo")
	private DaoPrestamo dao;
	
	@Override
	public void create(Prestamo obj) {
		dao.create(obj);
	}

	@Override
	public Prestamo readOne(int id) {
		return dao.readOne(id);
	}

	@Override
	public List<Prestamo> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Prestamo> readMany(String param) {
		return dao.readMany(param);
	}

	@Override
	public void update(Prestamo obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Prestamo obj) {
		dao.delete(obj);
		
	}

}
