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
import app.controller.PrestamoController;
@Controller
public class PrestamoElegirCliente {
	@Autowired
	@Qualifier("modelAndView")
	private ModelAndView vista;
	
	@RequestMapping("prestamo-elegirCliente{ssoId}.html") //IR A PRESTAMO
	public ModelAndView vistaPrestamoElegirCliente(@PathVariable Integer ssoId, String txtBuscar) {
		vista = new ModelAndView();
		vista.setViewName("prestamo-elegirCliente");
		
		List<Cliente>listaClientes;
		Biblioteca biblioteca=Biblioteca.ReadOne(ssoId);
		if(biblioteca==null) 
			System.out.println("No encontro Biblioteca");
		else
			System.out.println(biblioteca.toString());
		
		if(txtBuscar!=null) {
			listaClientes=Cliente.readMany(txtBuscar);
		}
		else {
			listaClientes=new ArrayList<Cliente>();
		}
		vista.addObject("biblioteca", biblioteca);
		vista.addObject("listaClientes", listaClientes);
		
		return vista;
	}
	@RequestMapping("prestamoFiltrarClientes.html")
	public ModelAndView filtrarClientes(String txtBuscar, Integer txtIdBiblioteca) {
		vista = new ModelAndView();
		
		List<Cliente>lista;
		if(txtBuscar!=null) {
			lista=Cliente.readMany(txtBuscar);
		}
		else {
			lista=Cliente.readAll();
		}
		
		Biblioteca biblioteca=Biblioteca.ReadOne(txtIdBiblioteca);
		if(biblioteca==null) 
			System.out.println("No encontro Biblioteca");
		else
			System.out.println(biblioteca.toString());
		
		vista.setViewName("prestamo-elegirCliente");
		if(lista!=null)
			vista.addObject("listaClientes",lista);
		if(biblioteca!=null) 
			vista.addObject("biblioteca",biblioteca);
		return vista;
	}
	
	//@RequestMapping("PrestamoSeleccionarCliente-{idCliente}.html")
	//public ModelAndView seleccionarCliente(@PathVariable Integer idCliente,Integer txtIdBiblioteca) {
	@RequestMapping("prestamoSeleccionarCliente-{idCliente}-{idBiblioteca}.html")
	public ModelAndView seleccionarCliente(@PathVariable("idCliente") Integer idCliente,@PathVariable("idBiblioteca") Integer idBiblioteca) {
		vista = new ModelAndView();
			
		Cliente c= Cliente.readOne(idCliente);
		if(c==null) {
			System.out.println("No encontro Cliente");
		}
		else {
			System.out.println(c.toString());
		}
		
		
		Biblioteca biblioteca=Biblioteca.ReadOne(idBiblioteca);
		//Biblioteca biblioteca=Biblioteca.ReadOne(txtIdBiblioteca); ->  prestamoSeleccionarCliente32.html
		if(biblioteca==null) 
			System.out.println("No encontro biblioteca");
		else
			System.out.println(biblioteca.toString());
		
		vista.addObject("biblioteca",biblioteca);
		vista.addObject("clienteElegido",c);
		vista.setViewName("prestamo-elegirCliente");
			
		return vista;
	}
	
	@RequestMapping("realizarPrestamo.html")
	public ModelAndView RealizarPrestamo(Integer txtClienteId, Integer txtIdBiblioteca, Integer txtCantidadDias) {
		ModelAndView vista = new ModelAndView();
		try 
		{
			Cliente cliente= Cliente.readOne(txtClienteId);
			Biblioteca biblioteca=Biblioteca.ReadOne(txtIdBiblioteca);
			ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
			Prestamo prestamo= (Prestamo)appContext.getBean("prestamo");
			prestamo.setBiblioteca(biblioteca);
			prestamo.setCliente(cliente);
			prestamo.setCantidadDias(txtCantidadDias);
			prestamo.setFechaPrestamo(new Date(2022,6,26));
			Prestamo.Create(prestamo);
			biblioteca.getEstado().setId(1);
			Biblioteca.Update(biblioteca);
			
			((ConfigurableApplicationContext)(appContext)).close();
			List<Biblioteca>listaBiblioteca = Biblioteca.ReadAll();
			vista.addObject("listaBiblioteca", listaBiblioteca);
			vista.addObject("clienteElegido",cliente);
			vista.addObject("biblioteca",biblioteca);
			vista.setViewName("prestamo");
		} 
		catch (Exception e) 
		{
			vista.setViewName("error");
			
		}
		
		
		if(txtCantidadDias==null) {
			txtCantidadDias=-1;
		}
		
		
			
		return vista;
	}
	
}
