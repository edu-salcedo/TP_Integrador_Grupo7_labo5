package app.servicio;

import java.util.List;

import app.dao.DaoCliente;
import app.entidades.Cliente;
import app.interfaces.IABML;

public class ServicioCliente implements IABML<Cliente>{
	private DaoCliente dao= new DaoCliente();
	
	@Override
	public void create(Cliente obj) {
		dao.create(obj);
	}

	@Override
	public Cliente readOne(int id) {
		return dao.readOne(id);
	}

	@Override
	public List<Cliente> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Cliente> readMany(String param) {
		return dao.readMany(param);
	}

	@Override
	public void update(Cliente obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Cliente obj) {
		dao.delete(obj);
	}

}
