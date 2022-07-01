package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Prestamo;
import app.interfaces.IABML;
import app.resources.Util;

public class DaoPrestamo implements IABML<Prestamo>{
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Prestamo obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();	
		obj.setFechaPrestamo(Util.FormatDate(obj.getFechaPrestamo()));
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Prestamo readOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Prestamo p = (Prestamo)session.get(Prestamo.class,id);
		cHibernate.cerrarSession();
		return p;
	}

	@Override
	public List<Prestamo> readAll() {
		return null;
	}

	@Override
	public List<Prestamo> readMany(String param) {
		return null;
	}

	@Override
	public void update(Prestamo obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Prestamo obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

}
