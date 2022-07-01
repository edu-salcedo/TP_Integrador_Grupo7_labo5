package app.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.resources.Config;
import app.servicio.ServicioUsuario;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String password;
	
	public Usuario() {}
	
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	public Usuario(int id, String nombre, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
	}
	
	public static void Create (Usuario u) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioUsuario servicio= (ServicioUsuario)appContext.getBean("servicioUsuario");
		servicio.create(u);
		
		((ConfigurableApplicationContext)(appContext)).close();
	}
	/*
	public static Usuario Login(Usuario u) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioUsuario servicio= (ServicioUsuario)appContext.getBean("servicioUsuario");
		Usuario usuario=servicio.login(u);
		
		((ConfigurableApplicationContext)(appContext)).close();
		return usuario;
		
	}
	*/
	
}


	