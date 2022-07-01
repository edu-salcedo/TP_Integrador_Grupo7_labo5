package app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.resources.Config;
import app.servicio.ServicioGenero;

@Entity
@Table(name="GENEROS")
public class Genero implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	
	//Constructores
	public Genero() {
		super();
	}
	
	public Genero(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public Genero(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//toString
	@Override
	public String toString() {
		return "Id de género: " + id + ", Descripción: " + descripcion + ".";
	}
	
	public static void Create(Genero g) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioGenero sg= (ServicioGenero)appContext.getBean("servicioGenero");
		sg.create(g);
		
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
