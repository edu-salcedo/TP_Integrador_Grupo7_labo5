package app.controller;
import app.entidades.Autor;
import app.entidades.Biblioteca;
import app.entidades.Cliente;
import app.entidades.Estado;
import app.entidades.Genero;
import app.entidades.Libro;
import app.entidades.Nacionalidad;
import app.entidades.Usuario;
import app.resources.Config;
import app.servicio.ServicioAutor;
import app.servicio.ServicioBiblioteca;
import app.servicio.ServicioCliente;
import app.servicio.ServicioEstado;
import app.servicio.ServicioGenero;
import app.servicio.ServicioLibro;
import app.servicio.ServicioNacionalidad;
import app.servicio.ServicioUsuario;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PaginaController {
	@Autowired @Qualifier("modelAndView")
	private ModelAndView vista;
	@Autowired @Qualifier("servicioNacionalidad")
	private ServicioNacionalidad sn;
	@Autowired @Qualifier("servicioGenero")
	private ServicioGenero sg;
	@Autowired @Qualifier("servicioLibro")
	private ServicioLibro sl;
	@Autowired @Qualifier("servicioAutor")
	private ServicioAutor sa;
	@Autowired @Qualifier("servicioCliente")
	private ServicioCliente sc;
	@Autowired @Qualifier("servicioBiblioteca")
	private ServicioBiblioteca sb;
	@Autowired @Qualifier("servicioUsuario")
	private ServicioUsuario su;
	@Autowired @Qualifier("servicioEstado")
	private ServicioEstado se;
	
	@RequestMapping("iniciar_app.html")
	public ModelAndView iniciarApp() {
		inicializarApp();
		vista.setViewName("index");
		return vista;
	}
	
	private void inicializarApp() {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		sn.create((Nacionalidad)appContext.getBean("nacionalidadArgentino"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadJapones"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadAleman"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadNeozelandes"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadNigeriano"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadIngles"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadAustriaco"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadIndio"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadFrances"));
		sn.create((Nacionalidad)appContext.getBean("nacionalidadNorteAmericano"));
		
		sg.create((Genero)appContext.getBean("generoTerror"));
		sg.create((Genero)appContext.getBean("generoMisterio"));
		sg.create((Genero)appContext.getBean("generoPoesia"));
		sg.create((Genero)appContext.getBean("generoBiografia"));
		sg.create((Genero)appContext.getBean("generoClasico"));
		sg.create((Genero)appContext.getBean("generoCiencia"));
		sg.create((Genero)appContext.getBean("generoPolicial"));
		sg.create((Genero)appContext.getBean("generoNovela"));
		sg.create((Genero)appContext.getBean("generoAdolescente"));
		sg.create((Genero)appContext.getBean("generoAventura"));
		sg.create((Genero)appContext.getBean("generoTecnico"));
		
		sa.create((Autor)appContext.getBean("autorBramStoker"));
		sa.create((Autor)appContext.getBean("autorJoseHernandez"));
		sa.create((Autor)appContext.getBean("autorNagaruTanigawa"));
		sa.create((Autor)appContext.getBean("autorConanDoyle"));
		sa.create((Autor)appContext.getBean("autorDanteAlighieri"));
		sa.create((Autor)appContext.getBean("autorStephenHawking"));
		sa.create((Autor)appContext.getBean("autorRobertStevenson"));
		sa.create((Autor)appContext.getBean("autorDanielLopezRosetti"));
		sa.create((Autor)appContext.getBean("autorRayBradbury"));
		sa.create((Autor)appContext.getBean("autorGeorgeOrwell"));
		sa.create((Autor)appContext.getBean("autorSigmundFreud"));
		
		sl.create((Libro)appContext.getBean("libroDracula"));
		sl.create((Libro)appContext.getBean("libroMartinFierro"));
		sl.create((Libro)appContext.getBean("libroHaruhi"));
		sl.create((Libro)appContext.getBean("libroSherlockHolmes"));
		sl.create((Libro)appContext.getBean("libroLaDivinaComedia"));
		sl.create((Libro)appContext.getBean("libroAgujerosNegros"));
		sl.create((Libro)appContext.getBean("libroLaIslaDelTesoro"));
		sl.create((Libro)appContext.getBean("libroEllas"));
		sl.create((Libro)appContext.getBean("libroFahrenheit451"));
		sl.create((Libro)appContext.getBean("libro1984"));
		sl.create((Libro)appContext.getBean("libroElMalestaDeLaCultura"));
		sl.create((Libro)appContext.getBean("libroPsicologiaDeLasMasas"));
		
		
		se.create((Estado)appContext.getBean("estadoPrestado"));
		se.create((Estado)appContext.getBean("estadoEnBiblioteca"));
		
		sb.create((Biblioteca)appContext.getBean("bibliotecaDracula"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaMartinFierro"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaHaruhi"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaSherlockHolmes"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaLaDivinaComedia"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaAgujerosNegros"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaLaIslaDelTesoro"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaEllas"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaFahrenheit451"));
		sb.create((Biblioteca)appContext.getBean("biblioteca1984"));
		sb.create((Biblioteca)appContext.getBean("bibliotecaElMalestaDeLaCultura"));
		sb.create((Biblioteca)appContext.getBean("bibliotecalibroPsicologiaDeLasMasas"));
		
		sc.create((Cliente)appContext.getBean("clienteCosmeFulanito"));
		sc.create((Cliente)appContext.getBean("clienteHansLanda"));
		sc.create((Cliente)appContext.getBean("clienteGonzaloMartinez"));
		
		su.create((Usuario)appContext.getBean("usuarioAndres"));
		su.create((Usuario)appContext.getBean("usuarioEdu"));
		su.create((Usuario)appContext.getBean("usuarioCris"));
		su.create((Usuario)appContext.getBean("usuarioAle"));
		
		System.out.println("Inicializacion Terminada!");
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
