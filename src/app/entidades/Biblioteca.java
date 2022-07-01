package app.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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

import app.entidades.Libro;
import app.resources.Config;
import app.servicio.ServicioBiblioteca;
import app.servicio.ServicioCliente;

@Entity
@Table(name="BIBLIOTECA")
public class Biblioteca implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BIBLIOTECA_ID")
	private int id;
	//@ManyToOne(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="LIBRO_ISBN")
	private Libro libro;
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ESTADO_ID")
	private Estado estado;
	
	public Biblioteca() {}
	
	public Biblioteca(Libro libro, Date fechaAlta, Estado estado) {
		super();
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}

	public Biblioteca(int id, Libro libro, Date fechaAlta, Estado estado) {
		super();
		this.id = id;
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	
	@Override
	public String toString() {
		return "Biblioteca [id=" + id + ", libro=" + libro + ", fechaAlta=" + fechaAlta + ", estado=" + estado.toString() + "]";
	}

	public static void Create(Biblioteca b) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioBiblioteca servicio= (ServicioBiblioteca)appContext.getBean("servicioBiblioteca");
		servicio.create(b);
		
		((ConfigurableApplicationContext)(appContext)).close();
	}

	public static List<Biblioteca> ReadAll() {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioBiblioteca servicio= (ServicioBiblioteca)appContext.getBean("servicioBiblioteca");
		List<Biblioteca>lista=servicio.readAll();
		
		((ConfigurableApplicationContext)(appContext)).close();
		return lista;
	}
	
	public static List<Biblioteca> ReadByIdEstado(int id){
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioBiblioteca servicio= (ServicioBiblioteca)appContext.getBean("servicioBiblioteca");
		List<Biblioteca> lista =servicio.readByIdEstado(id);
		
		((ConfigurableApplicationContext)(appContext)).close();
		
		if(lista==null) 
			System.out.println("No encontro");
		else
			System.out.println(lista.toString());
		
		return lista;
	}

	public static Biblioteca ReadOne(int id) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioBiblioteca servicio= (ServicioBiblioteca)appContext.getBean("servicioBiblioteca");
		Biblioteca b =servicio.readOne(id);
		
		((ConfigurableApplicationContext)(appContext)).close();
		
		if(b==null) 
			System.out.println("No encontro");
		else
			System.out.println(b.toString());
		
		return b;
	}
	public static void Delete(Biblioteca b) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioBiblioteca servicio= (ServicioBiblioteca)appContext.getBean("servicioBiblioteca");
		servicio.delete(b);
		
		((ConfigurableApplicationContext)(appContext)).close();
	}

	public static void Update(Biblioteca b) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		ServicioBiblioteca servicio= (ServicioBiblioteca)appContext.getBean("servicioBiblioteca");
		servicio.update(b);
		
		((ConfigurableApplicationContext)(appContext)).close();
		
	}
}
