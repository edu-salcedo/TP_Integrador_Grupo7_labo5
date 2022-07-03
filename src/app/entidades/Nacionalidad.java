package app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.resources.Config;
import app.servicio.ServicioNacionalidad;

@Entity
@Table(name="NACIONALIDADES")
public class Nacionalidad implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	int id;
	
	@Column(name="DESCRIPCION")
	String descripcion;
	
	public Nacionalidad() {}
	public Nacionalidad(int id,String des) {
		
		this.id=id;
		this.descripcion=des;
	}
	public Nacionalidad(String des) {
		
		this.descripcion=des;
	}
	

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

	@Override
	public String toString() {
		return "-Nacionalidad: id nacionalidad=" + id + ", nacionalidad=" + descripcion + "- ";
	}
	
}
