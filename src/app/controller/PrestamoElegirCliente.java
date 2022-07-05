package app.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.entidades.Biblioteca;
import app.entidades.Cliente;
import app.entidades.Prestamo;
import app.resources.Config;
import app.resources.Util;
import app.servicio.ServicioBiblioteca;
import app.servicio.ServicioCliente;
import app.servicio.ServicioPrestamo;
import app.controller.PrestamoController;
@Controller
public class PrestamoElegirCliente {
	@Autowired
	@Qualifier("modelAndView")
	private ModelAndView vista;
	@Autowired
	@Qualifier("servicioBiblioteca")
	private ServicioBiblioteca servicioBiblioteca;
	@Autowired
	@Qualifier("servicioCliente")
	private ServicioCliente servicioCliente;
	@Autowired
	@Qualifier("servicioPrestamo")
	private ServicioPrestamo servicioPrestamo;
	
	
	@RequestMapping("prestamo-elegirCliente{ssoId}.html") //IR A PRESTAMO
	public ModelAndView vistaPrestamoElegirCliente(@PathVariable Integer ssoId, String txtBuscar) {
		
		try 
		{
			Biblioteca biblioteca=servicioBiblioteca.readOne(ssoId);
			if(biblioteca!=null) 
				vista.addObject("biblioteca", biblioteca);
			
			List<Cliente>listaClientes;
			if(txtBuscar!=null)
				listaClientes=servicioCliente.readMany(txtBuscar);
			else
				listaClientes=servicioCliente.readAll();
			
			if(listaClientes!=null)
				vista.addObject("listaClientes", listaClientes);
			vista.addObject("listaClientes", listaClientes);
			vista.setViewName("prestamo-elegirCliente");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		
		return vista;
	}
	@RequestMapping("prestamoFiltrarClientes.html")
	public ModelAndView filtrarClientes(String txtBuscar, Integer txtIdBiblioteca) {
		try 
		{
			List<Cliente>listaClientes;
			if(txtBuscar!=null) 
				listaClientes=servicioCliente.readMany(txtBuscar);
			else 
				listaClientes=servicioCliente.readAll();
			if(listaClientes!=null)
				vista.addObject("listaClientes",listaClientes);

			Biblioteca biblioteca=servicioBiblioteca.readOne(txtIdBiblioteca);
			if(biblioteca!=null) 
				vista.addObject("biblioteca",biblioteca);
			vista.setViewName("prestamo-elegirCliente");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
	
	@RequestMapping("prestamoSeleccionarCliente-{idCliente}-{idBiblioteca}.html")
	public ModelAndView seleccionarCliente(@PathVariable("idCliente") Integer idCliente,@PathVariable("idBiblioteca") Integer idBiblioteca) {
		try 
		{
			Cliente c= servicioCliente.readOne(idCliente);
			Biblioteca biblioteca=servicioBiblioteca.readOne(idBiblioteca);
			if(biblioteca!=null)
				vista.addObject("biblioteca",biblioteca);
			if(c!=null)
				vista.addObject("clienteElegido",c);
			vista.setViewName("prestamo-elegirCliente");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}	
		return vista;
	}
	
	@RequestMapping("realizarPrestamo.html")
	public ModelAndView RealizarPrestamo(Integer txtClienteId, Integer txtIdBiblioteca, Integer cbCantidadDias) {
		try 
		{
			Cliente cliente= servicioCliente.readOne(txtClienteId);
			Biblioteca biblioteca=servicioBiblioteca.readOne(txtIdBiblioteca);
			ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
			Prestamo prestamo= (Prestamo)appContext.getBean("prestamo");
			prestamo.setBiblioteca(biblioteca);
			prestamo.setCliente(cliente);
			prestamo.setCantidadDias(cbCantidadDias);
			prestamo.setFechaPrestamo(Util.Now());
			servicioPrestamo.create(prestamo);
			biblioteca.getEstado().setId(1);
			servicioBiblioteca.update(biblioteca);
			
			((ConfigurableApplicationContext)(appContext)).close();
			
			List<Biblioteca>listaBiblioteca = servicioBiblioteca.readAll();
			vista.addObject("listaBiblioteca", listaBiblioteca);
			vista.addObject("clienteElegido",cliente);
			vista.addObject("biblioteca",biblioteca);
			vista.setViewName("prestamo");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}	
		return vista;
	}
	
}
