package app.resources;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

import app.dao.ConfigHibernate;
import app.dao.DaoAutor;
import app.dao.DaoCliente;
import app.dao.DaoEstado;
import app.dao.DaoGenero;
import app.dao.DaoLibro;
import app.dao.DaoNacionalidad;
import app.dao.DaoPrestamo;
import app.dao.DaoUsuario;
import app.dao.DaoBiblioteca;
import app.entidades.Autor;
import app.entidades.Biblioteca;
import app.entidades.Cliente;
import app.entidades.Estado;
import app.entidades.Genero;
import app.entidades.Libro;
import app.entidades.Nacionalidad;
import app.entidades.Prestamo;
import app.entidades.Usuario;
import app.servicio.ServicioAutor;
import app.servicio.ServicioBiblioteca;
import app.servicio.ServicioCliente;
import app.servicio.ServicioEstado;
import app.servicio.ServicioGenero;
import app.servicio.ServicioLibro;
import app.servicio.ServicioNacionalidad;
import app.servicio.ServicioPrestamo;
import app.servicio.ServicioUsuario;


@Configuration
public class Config {
	
	//ENTIDADES
	@Bean
	public Nacionalidad nacionalidad() {
		return new Nacionalidad();
	}
	
	@Bean
	public Autor autor() {
		Autor a= new Autor();
		a.setNacionalidad(nacionalidad());
		return a;
	}
	@Bean
	public Biblioteca biblioteca() {
		Biblioteca b=new Biblioteca();
		b.setLibro(libro());
		return b;
	}
	@Bean
	public Cliente cliente() {
		Cliente c= new Cliente();
		c.setNacionalidad(nacionalidad());
		return c;
	}
	@Bean
	public Genero genero() {
		return new Genero();
	}
	@Bean
	public Libro libro() {
		Libro l= new Libro();
		l.setAutor(autor());
		l.setGeneros(new ArrayList<Genero>());
		return l;
	}
	@Bean
	public Prestamo prestamo() {
		Prestamo p= new Prestamo();
		p.setBiblioteca(biblioteca());
		p.setCliente(cliente());
		return p;
	}
	@Bean
	public Usuario usuario() {
		return new Usuario();
	}
	
	//ENTIDADES INICIADAS
	@Bean
	public Nacionalidad nacionalidadArgentino() {
		return new Nacionalidad("argentino");
	}
	@Bean
	public Nacionalidad nacionalidadJapones() {
		return new Nacionalidad("japones");
	}
	@Bean
	public Nacionalidad nacionalidadAleman() {
		return new Nacionalidad("aleman");
	}
	@Bean
	public Nacionalidad nacionalidadNeozelandes() {
		return new Nacionalidad("neo zelandez");
	}
	@Bean
	public Nacionalidad nacionalidadNigeriano() {
		return new Nacionalidad("nigeriano");
	}
	@Bean
	public Nacionalidad nacionalidadIngles() {
		return new Nacionalidad("ingles");
	}
	@Bean
	public Nacionalidad nacionalidadNorteAmericano() {
		return new Nacionalidad("norte americano");
	}
	@Bean
	public Nacionalidad nacionalidadAustriaco() {
		return new Nacionalidad("austriaco");
	}
	@Bean
	public Nacionalidad nacionalidadIndio() {
		return new Nacionalidad("indio");
	}
	@Bean
	public Nacionalidad nacionalidadFrances() {
		return new Nacionalidad("frances");
	}
	@Bean
	public Genero generoTerror() {
		return new Genero("terror");
	}
	@Bean
	public Genero generoMisterio() {
		return new Genero("misterio");
	}
	@Bean
	public Genero generoPoesia() {
		return new Genero("poesia");
	}
	@Bean
	public Genero generoBiografia() {
		return new Genero("biografia");
	}
	@Bean
	public Genero generoClasico() {
		return new Genero("clasico");
	}
	@Bean
	public Genero generoPolicial() {
		return new Genero("policial");
	}
	@Bean
	public Genero generoCiencia() {
		return new Genero("ciencia");
	}
	@Bean
	public Genero generoNovela() {
		return new Genero("novela");
	}
	@Bean
	public Genero generoAdolescente() {
		return new Genero("adolescente");
	}
	@Bean
	public Genero generoAventura() {
		return new Genero("aventura");
	}
	@Bean
	public Genero generoTecnico() {
		return new Genero("tecnico");
	}
	@Bean
	public ArrayList<Genero> listaGeneros1(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoTerror());
		lista.add(generoClasico());
		lista.add(generoMisterio());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros2(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoPoesia());
		lista.add(generoClasico());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros3(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoMisterio());
		lista.add(generoTerror());
		lista.add(generoAdolescente());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros4(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoPolicial());
		lista.add(generoMisterio());
		lista.add(generoNovela());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros5(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoClasico());
		lista.add(generoNovela());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros6(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoCiencia());
		lista.add(generoBiografia());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros7(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoAventura());
		lista.add(generoNovela());
		lista.add(generoClasico());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros8(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoCiencia());
		lista.add(generoTecnico());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros9(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoNovela());
		lista.add(generoClasico());
		lista.add(generoMisterio());
		return lista;
	}
	@Bean
	public ArrayList<Genero> listaGeneros10(){
		ArrayList<Genero> lista= new ArrayList<Genero>();
		lista.add(generoTecnico());
		lista.add(generoCiencia());
		return lista;
	}
	
	@Bean
	public Autor autorBramStoker() {
		Autor a= new Autor();
		a.setNombre("Bram");
		a.setApellido("Stoker");
		a.setEmail("bramstoker@gmail.com");
		a.setNacionalidad(nacionalidadAleman());
		return a;
	}
	@Bean
	public Autor autorJoseHernandez() {
		Autor a= new Autor();
		a.setNombre("jose");
		a.setApellido("Hernandez");
		a.setEmail("josehernandez@gmail.com");
		a.setNacionalidad(nacionalidadArgentino());
		return a;
	}
	@Bean
	public Autor autorNagaruTanigawa() {
		Autor a= new Autor();
		a.setNombre("Nagaru");
		a.setApellido("Tanigawa");
		a.setEmail("nagatani@gmail.com");
		a.setNacionalidad(nacionalidadJapones());
		return a;
	}
	@Bean
	public Autor autorConanDoyle() {
		Autor a= new Autor();
		a.setNombre("Conan");
		a.setApellido("Doyle");
		a.setEmail("Conan@yahoo.com");
		a.setNacionalidad(nacionalidadNigeriano());
		return a;
	}
	@Bean
	public Autor autorDanteAlighieri() {
		Autor a= new Autor();
		a.setNombre("Dante");
		a.setApellido("Alighieri");
		a.setEmail("Dante@live.com");
		a.setNacionalidad(nacionalidadIngles());
		return a;
	}
	@Bean
	public Autor autorStephenHawking() {
		Autor a= new Autor();
		a.setNombre("Stephen");
		a.setApellido("Hawking");
		a.setEmail("stephenhawking@gmail.com");
		a.setNacionalidad(nacionalidadNeozelandes());
		return a;
	}
	@Bean
	public Autor autorRobertStevenson() {
		Autor a= new Autor();
		a.setNombre("Robert");
		a.setApellido("Stevenson");
		a.setEmail("robertstevenson@hotmail.com");
		a.setNacionalidad(nacionalidadIngles());
		return a;
	}
	@Bean
	public Autor autorDanielLopezRosetti() {
		Autor a= new Autor();
		a.setNombre("Daniel");
		a.setApellido("Lopez Rosetti");
		a.setEmail("danielrosetti@gmail.com");
		a.setNacionalidad(nacionalidadArgentino());
		return a;
	}
	@Bean
	public Autor autorRayBradbury() {
		Autor a= new Autor();
		a.setNombre("Ray");
		a.setApellido("Bradbury");
		a.setEmail("raybradbury@yahoo.com");
		a.setNacionalidad(nacionalidadNorteAmericano());
		return a;
	}
	@Bean
	public Autor autorGeorgeOrwell() {
		Autor a= new Autor();
		a.setNombre("George");
		a.setApellido("Orwell");
		a.setEmail("georgeOrwell@hotmail.com");
		a.setNacionalidad(nacionalidadIndio());
		return a;
	}
	@Bean
	public Autor autorSigmundFreud() {
		Autor a= new Autor();
		a.setNombre("Sigmund");
		a.setApellido("Freud");
		a.setEmail("freud-atr@hotmail.com");
		a.setNacionalidad(nacionalidadAustriaco());
		return a;
	}
	@Bean
	public Libro libroDracula() {
		Libro l= new Libro();
		l.setAutor(autorBramStoker());
		l.setCantidadPaginas(700);
		l.setDescripcion("Libro de Terror");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1822,6,5)));
		l.setIdioma("ingles");
		l.setIsbn(11111);
		l.setTitulo("Dracula");
		l.setGeneros(listaGeneros1());
		return l;
	}
	@Bean
	public Libro libroMartinFierro() {
		Libro l= new Libro();
		l.setAutor(autorJoseHernandez());
		l.setCantidadPaginas(300);
		l.setDescripcion("Libro de poesia clasico");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1872,4,8)));
		l.setIdioma("español");
		l.setIsbn(22222);
		l.setTitulo("El Martin Fierro");
		l.setGeneros(listaGeneros2());
		return l;
	}
	@Bean
	public Libro libroHaruhi() {
		Libro l= new Libro();
		l.setAutor(autorNagaruTanigawa());
		l.setCantidadPaginas(200);
		l.setDescripcion("novela ligera");
		l.setFechaLanzamiento(Util.FormatDate(new Date(2002,8,1)));
		l.setIdioma("japones");
		l.setIsbn(33333);
		l.setTitulo("La melancolia de haruhi");
		l.setGeneros(listaGeneros3());
		return l;
	}
	@Bean
	public Libro libroSherlockHolmes() {
		Libro l= new Libro();
		l.setAutor(autorConanDoyle());
		l.setCantidadPaginas(300);
		l.setDescripcion("novela policial de misterio");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1902,10,4)));
		l.setIdioma("ingles");
		l.setIsbn(44444);
		l.setTitulo("Sherlock Holmes");
		l.setGeneros(listaGeneros4());
		return l;
	}
	@Bean
	public Libro libroLaDivinaComedia() {
		Libro l= new Libro();
		l.setAutor(autorDanteAlighieri());
		l.setCantidadPaginas(600);
		l.setDescripcion("novela clasica que no tiene nada de comico");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1842,11,11)));
		l.setIdioma("ingles");
		l.setIsbn(55555);
		l.setTitulo("La Divina Comedia");
		l.setGeneros(listaGeneros5());
		return l;
	}
	@Bean
	public Libro libroAgujerosNegros() {
		Libro l= new Libro();
		l.setAutor(autorStephenHawking());
		l.setCantidadPaginas(250);
		l.setDescripcion("Libro de ciencia sobre agujeros negros");
		l.setFechaLanzamiento(Util.FormatDate(new Date(2012,10,12)));
		l.setIdioma("español");
		l.setIsbn(66666);
		l.setTitulo("Agujeros Negros");
		l.setGeneros(listaGeneros6());
		return l;
	}
	@Bean
	public Libro libroLaIslaDelTesoro() {
		Libro l= new Libro();
		l.setAutor(autorRobertStevenson());
		l.setCantidadPaginas(290);
		l.setDescripcion("novela de aventura con piratas y tesoros");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1912,10,19)));
		l.setIdioma("español");
		l.setIsbn(77777);
		l.setTitulo("La isla del tesoro");
		l.setGeneros(listaGeneros7());
		return l;
	}
	@Bean
	public Libro libroEllas() {
		Libro l= new Libro();
		l.setAutor(autorDanielLopezRosetti());
		l.setCantidadPaginas(270);
		l.setDescripcion("Libro sobre psicologia, historia y biologia de la mujer");
		l.setFechaLanzamiento(Util.FormatDate(new Date(2012,9,22)));
		l.setIdioma("español");
		l.setIsbn(88888);
		l.setTitulo("Ellas");
		l.setGeneros(listaGeneros8());
		return l;
	}
	@Bean
	public Libro libroFahrenheit451() {
		Libro l= new Libro();
		l.setAutor(autorRayBradbury());
		l.setCantidadPaginas(180);
		l.setDescripcion("Libro de misterio clasico donde aprendemos a que temperatura se prende fuego el papel");
		l.setFechaLanzamiento(Util.FormatDate(new Date(2000,8,20)));
		l.setIdioma("ingles");
		l.setIsbn(99999);
		l.setTitulo("Fahrenheit 451");
		l.setGeneros(listaGeneros9());
		return l;
	}
	@Bean
	public Libro libro1984() {
		Libro l= new Libro();
		l.setAutor(autorGeorgeOrwell());
		l.setCantidadPaginas(348);
		l.setDescripcion("Libro de misterio clasico donde todos nos observan, a toda hora, en todo momento");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1970,1,7)));
		l.setIdioma("ingles");
		l.setIsbn(1010);
		l.setTitulo("1984");
		l.setGeneros(listaGeneros9());
		return l;
	}
	@Bean
	public Libro libroElMalestaDeLaCultura() {
		Libro l= new Libro();
		l.setAutor(autorSigmundFreud());
		l.setCantidadPaginas(302);
		l.setDescripcion("Libro tecnico de psicologia para estudiantes universitarios");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1944,4,14)));
		l.setIdioma("español");
		l.setIsbn(1111);
		l.setTitulo("El malestar de la cultura");
		l.setGeneros(listaGeneros10());
		return l;
	}
	@Bean
	public Libro libroPsicologiaDeLasMasas() {
		Libro l= new Libro();
		l.setAutor(autorSigmundFreud());
		l.setCantidadPaginas(233);
		l.setDescripcion("Libro tecnico de psicologia para estudiantes universitarios");
		l.setFechaLanzamiento(Util.FormatDate(new Date(1955,5,19)));
		l.setIdioma("español");
		l.setIsbn(1212);
		l.setTitulo("Psicologia de las Masas");
		l.setGeneros(listaGeneros10());
		return l;
	}
	@Bean
	public Usuario usuarioAndres() {
		return new Usuario("andy","1234");
	}
	@Bean
	public Usuario usuarioEdu() {
		return new Usuario("edu","1234");
	}
	@Bean
	public Usuario usuarioCris() {
		return new Usuario("cris","1234");
	}
	@Bean
	public Usuario usuarioAle() {
		return new Usuario("ale","1234");
	}
	@Bean
	public Estado estadoPrestado() {
		return new Estado("prestado");
	}
	@Bean
	public Estado estadoEnBiblioteca() {
		return new Estado("en biblioteca");
	}
	@Bean
	public Biblioteca bibliotecaDracula() {
		return new Biblioteca(libroDracula(),Util.FormatDate(new Date(2022,6,23)),estadoEnBiblioteca());
	}
	@Bean
	public Biblioteca bibliotecaMartinFierro() {
		return new Biblioteca(libroMartinFierro(),Util.FormatDate(new Date(2022,6,23)),estadoPrestado());
	}
	@Bean
	public Biblioteca bibliotecaHaruhi() {
		return new Biblioteca(libroHaruhi(),Util.FormatDate(new Date(2022,6,23)),estadoEnBiblioteca());
	}
	@Bean
	public Biblioteca bibliotecaSherlockHolmes() {
		return new Biblioteca(libroSherlockHolmes(),Util.FormatDate(new Date(2022,6,23)),estadoPrestado());
	}
	@Bean
	public Biblioteca bibliotecaLaDivinaComedia() {
		return new Biblioteca(libroLaDivinaComedia(),Util.FormatDate(new Date(2022,6,23)),estadoPrestado());
	}
	@Bean
	public Biblioteca bibliotecaAgujerosNegros() {
		return new Biblioteca(libroAgujerosNegros(),Util.FormatDate(new Date(2022,6,23)),estadoEnBiblioteca());
	}
	@Bean
	public Biblioteca bibliotecaLaIslaDelTesoro() {
		return new Biblioteca(libroLaIslaDelTesoro(),Util.FormatDate(new Date(2022,6,23)),estadoEnBiblioteca());
	}
	@Bean
	public Biblioteca bibliotecaEllas() {
		return new Biblioteca(libroEllas(),Util.FormatDate(new Date(2022,6,23)),estadoPrestado());
	}
	@Bean
	public Biblioteca bibliotecaFahrenheit451() {
		return new Biblioteca(libroFahrenheit451(),Util.FormatDate(new Date(2022,6,23)),estadoEnBiblioteca());
	}
	@Bean
	public Biblioteca biblioteca1984() {
		return new Biblioteca(libro1984(),Util.FormatDate(new Date(2022,6,23)),estadoPrestado());
	}
	@Bean
	public Biblioteca bibliotecaElMalestaDeLaCultura() {
		return new Biblioteca(libroElMalestaDeLaCultura(),Util.FormatDate(new Date(2022,6,23)),estadoEnBiblioteca());
	}
	@Bean
	public Biblioteca bibliotecaPsicologiaDeLasMasas() {
		return new Biblioteca(libroPsicologiaDeLasMasas(),Util.FormatDate(new Date(2022,6,23)),estadoPrestado());
	}
	
	@Bean
	public Cliente clienteCosmeFulanito() {
		Cliente c = new Cliente();
		c.setNombre("Cosme");
		c.setApellido("Fulanito");
		c.setDireccion("Calle falsa 123");
		c.setDni("30222333");
		c.setEmail("cosme@hotmail.com");
		c.setNacimiento(Util.FormatDate(new Date(1988,12,19)));
		c.setNacionalidad(nacionalidadArgentino());
		c.setTelefono("1511112222");
		c.setLocalidad("Tigre");
		return c;
	}
	@Bean
	public Cliente clienteHansLanda() {
		Cliente c = new Cliente();
		c.setNombre("Hans");
		c.setApellido("Landa");
		c.setDireccion("berlin 123");
		c.setDni("30111222");
		c.setEmail("landa@gmail.com");
		c.setNacimiento(Util.FormatDate(new Date(1981,5,5)));
		c.setNacionalidad(nacionalidadAleman());
		c.setTelefono("1531133223");
		c.setLocalidad("frankfurt");
		return c;
	}
	@Bean
	public Cliente clienteGonzaloMartinez() {
		Cliente c = new Cliente();
		c.setNombre("Gonzalo");
		c.setApellido("Martinez");
		c.setDireccion("Madrid 912");
		c.setDni("30333333");
		c.setEmail("pity@hotmail.com");
		c.setNacimiento(Util.FormatDate(new Date(1993,12,9)));
		c.setNacionalidad(nacionalidadArgentino());
		c.setTelefono("1533114222");
		c.setLocalidad("Parque Patricios");
		return c;
	}
	
	@Bean
	public Prestamo PrestamoMartinFierro() {
		return new Prestamo(bibliotecaMartinFierro(),Util.Now(),4,clienteGonzaloMartinez());
	}
	
	@Bean
	public Prestamo prestamoSherlockHolmes() {
		return new Prestamo(bibliotecaSherlockHolmes(),Util.Now(),3,clienteGonzaloMartinez());
	}
	@Bean
	public Prestamo prestamoLaDivinaComedia() {
		return new Prestamo(bibliotecaLaDivinaComedia(),Util.Now(),2,clienteCosmeFulanito());
	}
	@Bean
	public Prestamo prestamoEllas() {
		return new Prestamo(bibliotecaEllas(),Util.Now(),5,clienteCosmeFulanito());
	}
	@Bean
	public Prestamo prestamo1984() {
		return new Prestamo(biblioteca1984(),Util.Now(),1,clienteHansLanda());
	}
	@Bean
	public Prestamo prestamoPsicologiaDeLasMasas() {
		return new Prestamo(bibliotecaPsicologiaDeLasMasas(),Util.Now(),2,clienteHansLanda());
	}
	
	//SERVICIOS
	@Bean
	public ServicioNacionalidad servicioNacionalidad() {
		return new ServicioNacionalidad();
	}
	@Bean
	public ServicioGenero servicioGenero() {
		return new ServicioGenero();
	}
	@Bean
	public ServicioLibro servicioLibro() {
		return new ServicioLibro();
	}
	@Bean
	public ServicioAutor servicioAutor() {
		return new ServicioAutor();
	}
	@Bean
	public ServicioCliente servicioCliente() {
		return new ServicioCliente();
	}
	@Bean
	public ServicioBiblioteca servicioBiblioteca() {
		return new ServicioBiblioteca();
	}
	@Bean
	public ServicioPrestamo servicioPrestamo() {
		return new ServicioPrestamo();
	}
	@Bean
	public ServicioUsuario servicioUsuario() {
		return new ServicioUsuario();
	}
	@Bean
	public ServicioEstado servicioEstado() {
		return new ServicioEstado();
	}
	
	
	//DAOS
	@Bean
	public DaoNacionalidad daoNacionalidad() {
		return new DaoNacionalidad();
	}
	
	@Bean
	public DaoAutor daoAutor() {
		return new DaoAutor();
	}
	@Bean
	public DaoBiblioteca daoBiblioteca() {
		return new DaoBiblioteca();
	}
	@Bean
	public DaoCliente daoCliente() {
		return new DaoCliente();
	}
	@Bean
	public DaoGenero daoGenero() {
		return new DaoGenero();
	}
	@Bean
	public DaoLibro daoLibro() {
		return new DaoLibro();
	}
	@Bean
	public DaoPrestamo daoPrestamo() {
		return new DaoPrestamo();
	}
	@Bean
	public DaoUsuario daoUsuario() {
		return new DaoUsuario();
	}
	@Bean
	public DaoEstado daoEstado() {
		return new DaoEstado();
	}
	@Bean
	public ModelAndView modelAndView() {
		return new ModelAndView();
	}
	//HIBERNATE
	/*
	@Bean
	 public ConfigHibernate configHibernate() {
		ConfigHibernate cf= new ConfigHibernate();
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure();
        ServiceRegistry serviceregistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        cf.setSessionFactory(configuration.buildSessionFactory(serviceregistry));
        return cf;
        
    }
    */
	
}
