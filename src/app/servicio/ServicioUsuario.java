package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.dao.DaoUsuario;
import app.entidades.Usuario;
import app.interfaces.IABML;

public class ServicioUsuario implements IABML <Usuario>{
	@Autowired
	@Qualifier("daoUsuario")
	private DaoUsuario dao;
	
	public Usuario login(String usuario,String password) {
		return dao.login(usuario,password);
	}
	@Override
	public void create(Usuario obj) {
		dao.create(obj);
	}

	@Override
	public Usuario readOne(int id) {
		return dao.readOne(id);
	}
	
	@Override
	public List<Usuario> readAll() {
		return dao.readAll();
	}

	@Override
	public List<Usuario> readMany(String param) {
		// TODO Auto-generated method stub
		return dao.readMany(param);
	}

	@Override
	public void update(Usuario obj) {
		dao.update(obj);
		
	}

	@Override
	public void delete(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

}
