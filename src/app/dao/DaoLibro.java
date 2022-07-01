package app.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Biblioteca;
import app.entidades.Libro;
import app.interfaces.IABML;
import app.resources.Util;
import app.dao.ConfigHibernate;

public class DaoLibro implements IABML<Libro>{
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Libro obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		obj.setFechaLanzamiento(Util.FormatDate(obj.getFechaLanzamiento()));		
		session.beginTransaction();		
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Libro readOne(int isbn) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Libro libro = (Libro)session.get(Libro.class,isbn);
		cHibernate.cerrarSession();
		return libro;
	}

	@Override
	public List<Libro> readAll() {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		List<Libro>lista=(List<Libro>)session.createQuery("FROM Libro").list();
		cHibernate.cerrarSession();
		return lista;
	}

	@Override
	public List<Libro> readMany(String param) {
		return null;
	}

	@Override
	public void update(Libro obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		obj.setFechaLanzamiento(Util.FormatDate(obj.getFechaLanzamiento()));
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Libro obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
}
