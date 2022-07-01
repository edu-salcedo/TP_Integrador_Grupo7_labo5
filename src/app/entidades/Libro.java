package app.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.resources.Config;
import app.servicio.ServicioLibro;

@Entity
@Table(name="LIBROS")
public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int isbn;
	private String titulo;
	private Date fechaLanzamiento;
	private String idioma;
	private int cantidadPaginas;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_autor")
	private Autor autor;
	private String descripcion;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="generos_x_libro", joinColumns= {@JoinColumn(name="isbn")}, inverseJoinColumns= {@JoinColumn(name="id_genero")})
	private List<Genero> generos = new ArrayList<Genero>();
	

	//Constructores
	public Libro() {
		super();
	}
	public Libro(int isbn, String titulo, Date fechaLanzamiento, String idioma, int cantidadPaginas, Autor autor,
			String descripcion, List<Genero> generos) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.idioma = idioma;
		this.cantidadPaginas = cantidadPaginas;
		this.autor = autor;
		this.descripcion = descripcion;
		this.generos = generos;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getCantidadPaginas() {
		return cantidadPaginas;
	}
	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	//toString
	@Override
	public String toString() {
		return "Isbn: " + isbn + ", titulo: " + titulo + ", fecha de lanzamiento: " + fechaLanzamiento + ", idioma: "
				+ idioma + ", cantidad de páginas: " + cantidadPaginas + ", autor: " + autor + ", descripción: " + descripcion
				+ ", géneros: " + generos.toString() + ".";
	}
	
	public String toStringLibroPropp() {
		return "Isbn: " + isbn + ", titulo: " + titulo + ", fecha de lanzamiento: " + fechaLanzamiento + ", idioma: "
				+ idioma + ", cantidad de páginas: " + cantidadPaginas + ", descripción: " + descripcion + ".";
	}
	
}
