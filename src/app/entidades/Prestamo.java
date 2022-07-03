package app.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.resources.Config;
import app.servicio.ServicioPrestamo;

@Entity
@Table(name="PRESTAMOS")
public class Prestamo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BIBLIOTECA_ID")
	private Biblioteca biblioteca;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;
	
	@Column(name="FECHA_PRESTAMO")
	private Date fechaPrestamo;
	@Column(name="CANTIDAD_DIAS")
	private int cantidadDias;
	
	
	
	public Prestamo() {	}

	public Prestamo(int id, Biblioteca biblioteca, Date fechaPrestamo, int cantidadDias, Cliente cliente) {
		super();
		this.id = id;
		this.biblioteca = biblioteca;
		this.fechaPrestamo = fechaPrestamo;
		this.cantidadDias = cantidadDias;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
