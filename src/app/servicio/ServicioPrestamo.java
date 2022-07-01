package app.servicio;

import java.util.List;

import app.dao.DaoPrestamo;
import app.entidades.Prestamo;
import app.interfaces.IABML;

public class ServicioPrestamo implements IABML <Prestamo>{
	private DaoPrestamo dao = new DaoPrestamo();
	
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
