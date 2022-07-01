package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.entidades.Biblioteca;

@Controller
public class PrestamoController {
	@Autowired
	@Qualifier("modelAndView")
	private ModelAndView vista;
	
	@RequestMapping("prestamo.html") //IR A PRESTAMO
	public ModelAndView vistaPrestamo() {
		try 
		{
			List<Biblioteca>listaBiblioteca=Biblioteca.ReadAll();
			if(listaBiblioteca==null) 
				listaBiblioteca= new ArrayList<Biblioteca>();
			vista.addObject("listaBiblioteca",listaBiblioteca);
			vista.setViewName("prestamo");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
	
	@RequestMapping("cambiarEstadoBiblioteca-{ssoId}.html")
	public ModelAndView cambiarEstadoBiblioteca(@PathVariable int ssoId) {
		try 
		{
			Biblioteca biblioteca= Biblioteca.ReadOne(ssoId);
			if(biblioteca.getEstado().getId()==1) {
				biblioteca.getEstado().setId(2);
			}
			else {
				biblioteca.getEstado().setId(1);
			}
			Biblioteca.Update(biblioteca);
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		
		return vistaPrestamo();
	} 
	
	@RequestMapping("mostrarPorIdEstadoPrestamo-{ssoId}.html") //IR A BIBLIOTECA
	public ModelAndView vistaBibliotecaPorEstado(@PathVariable int ssoId) {
		try 
		{
			List<Biblioteca>lista=Biblioteca.ReadByIdEstado(ssoId);
			vista.addObject("listaBiblioteca",lista);
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
