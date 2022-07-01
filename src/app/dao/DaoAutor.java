package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Autor;
import app.entidades.Biblioteca;
import app.interfaces.IABML;
import app.dao.ConfigHibernate;

public class DaoAutor implements IABML<Autor>{
	
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Autor obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Autor readOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Autor autor = (Autor)session.get(Autor.class,id);
		cHibernate.cerrarSession();
		return autor;
	}

	@Override
	public List<Autor> readAll() {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		List<Autor>lista=(List<Autor>)session.createQuery("FROM Autor").list();
		cHibernate.cerrarSession();
		return lista;
	}

	@Override
	public List<Autor> readMany(String param) {
		return null;
	}

	@Override
	public void update(Autor obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Autor obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
		
	}
}
