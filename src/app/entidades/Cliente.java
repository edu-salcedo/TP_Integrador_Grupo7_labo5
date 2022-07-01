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

import app.resources.Config;
import app.servicio.ServicioCliente;

@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name= "NACIONALIDAD_ID")
	private Nacionalidad nacionalidad;
	
	@Column(name="DNI")
	private String dni;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDO")
	private String apellido;
	@Column(name="EMAIL")
	private String email;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="TELEFONO")
	private String telefono;
	@Column(name="LOCALIDAD")
	private String localidad;
	@Column(name="NACIMIENTO")
	private Date nacimiento;
	
	public Cliente() {}
	
	public Cliente(int id, String dni, String nombre, String apellido, Nacionalidad nacionalidad, String email,
			String direccion, String telefono, Date nacimiento) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nacimiento = nacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nacionalidad=" + nacionalidad.toString() + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", email=" + email + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", localidad=" + localidad + ", nacimiento=" + nacimiento + "]";
	}

}
