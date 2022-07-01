package app.servicio;

import java.util.List;

import app.dao.DaoNacionalidad;
import app.entidades.Nacionalidad;
import app.interfaces.IABML;

public class ServicioNacionalidad implements IABML<Nacionalidad>{
	private DaoNacionalidad dao = new DaoNacionalidad();
	@Override
	public void create(Nacionalidad obj) {
		dao.create(obj);
	}

	@Override
	public Nacionalidad readOne(int id) {
		return dao.readOne(id);
	}

	@Override
	public List<Nacionalidad> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Nacionalidad> readMany(String param) {
		return dao.readMany(param);
	}

	@Override
	public void update(Nacionalidad obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Nacionalidad obj) {
		dao.delete(obj);
	}

}
