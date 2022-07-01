package app.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Cliente;
import app.interfaces.IABML;
import app.resources.Util;

public class DaoCliente implements IABML<Cliente>{
	
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	@Override
	public void create(Cliente obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();	
		obj.setNacimiento(Util.FormatDate(obj.getNacimiento()));
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Cliente readOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Cliente cliente = (Cliente)session.get(Cliente.class,id);
		cHibernate.cerrarSession();
		return cliente;
	}

	@Override
	public List<Cliente> readAll() {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		List<Cliente>lista=(List<Cliente>)session.createQuery("FROM Cliente").list();
		cHibernate.cerrarSession();
		return lista;
	}

	@Override
	public List<Cliente> readMany(String param) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		String query="SELECT c FROM Cliente c "+
					"WHERE c.nombre LIKE '%"+param+"%' "+
					"OR c.apellido LIKE '%"+param+"%'";
		List<Cliente>lista=(List<Cliente>)session.createQuery(query).list();
		cHibernate.cerrarSession();
		return lista;
	}

	@Override
	public void update(Cliente obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Cliente obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
}
