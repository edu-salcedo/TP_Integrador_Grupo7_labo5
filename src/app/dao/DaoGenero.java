package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Genero;
import app.interfaces.IABML;
import app.dao.ConfigHibernate;

public class DaoGenero implements IABML<Genero>{
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Genero obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Genero readOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Genero genero = (Genero)session.get(Genero.class,id);
		cHibernate.cerrarSession();
		return genero;
	}

	@Override
	public List<Genero> readAll() {
		return null;
	}

	@Override
	public List<Genero> readMany(String param) {
		return null;
	}

	@Override
	public void update(Genero obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Genero obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
		
	}

}
