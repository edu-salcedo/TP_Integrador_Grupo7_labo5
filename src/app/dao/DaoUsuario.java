package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.entidades.Usuario;
import app.interfaces.IABML;

public class DaoUsuario implements IABML<Usuario>{
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	public Usuario login(String usuario, String password) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		String query="SELECT u FROM Usuario u "+
				"WHERE u.nombre LIKE '"+usuario+"' "+
				"AND u.password LIKE '"+password+"'";
		Usuario u = (Usuario)session.createQuery(query).uniqueResult();
		cHibernate.cerrarSession();
		return u;
	}
	
	@Override
	public void create(Usuario obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(obj);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public Usuario readOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Usuario u = (Usuario)session.get(Usuario.class,id);
		cHibernate.cerrarSession();
		return u;
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> readMany(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Usuario obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

	@Override
	public void delete(Usuario obj) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
}
