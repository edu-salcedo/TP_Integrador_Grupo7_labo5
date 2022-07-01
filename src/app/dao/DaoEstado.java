package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Estado;
import app.interfaces.IABML;

public class DaoEstado implements IABML<Estado>{
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Estado obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
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
