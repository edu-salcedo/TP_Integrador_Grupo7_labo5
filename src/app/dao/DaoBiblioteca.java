package app.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Biblioteca;
import app.interfaces.IABML;
import app.resources.Util;
import app.dao.ConfigHibernate;

public class DaoBiblioteca implements IABML<Biblioteca>{
	
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Biblioteca obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();	
		obj.setFechaAlta(obj.getFechaAlta());
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Biblioteca readOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Biblioteca b = (Biblioteca)session.get(Biblioteca.class,id);
		cHibernate.cerrarSession();
		return b;
	}

	@Override
	public List<Biblioteca> readAll() {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		List<Biblioteca>lista=(List<Biblioteca>)session.createQuery("FROM Biblioteca").list();
		cHibernate.cerrarSession();
		return lista;
	}

	@Override
	public List<Biblioteca> readMany(String param) {
		return null;
	}

	@Override
	public void update(Biblioteca obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Biblioteca obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	public List<Biblioteca> readByIdEstado(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		String query="SELECT b FROM Biblioteca b "+
					"WHERE b.estado="+id;
		List<Biblioteca>lista=(List<Biblioteca>)session.createQuery(query).list();
		cHibernate.cerrarSession();
		return lista;
	}

}
