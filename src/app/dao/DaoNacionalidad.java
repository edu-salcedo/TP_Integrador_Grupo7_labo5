package app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Nacionalidad;
import app.interfaces.IABML;
import app.dao.ConfigHibernate;

public class DaoNacionalidad implements IABML<Nacionalidad>{
	
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Nacionalidad obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Nacionalidad readOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Nacionalidad nacionalidad = (Nacionalidad)session.get(Nacionalidad.class,id);
		cHibernate.cerrarSession();
		return nacionalidad;
	}

	@Override
	public List<Nacionalidad> readAll() {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		List<Nacionalidad>lista = (List<Nacionalidad>)session.createQuery("FROM Nacionalidad").list();
		cHibernate.cerrarSession();
		return lista;
	}

	@Override
	public List<Nacionalidad> readMany(String param) {
		return null;
	}

	@Override
	public void update(Nacionalidad obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Nacionalidad obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
		
	}
}
