package app.controller;

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
		vista = new ModelAndView();
		vista.setViewName("prestamo");
		
		List<Biblioteca>listaBiblioteca=Biblioteca.ReadAll();
		if(listaBiblioteca==null) 
			System.out.println("No encontro Biblioteca");
		else
			System.out.println(listaBiblioteca.toString());
		if(listaBiblioteca!=null)
			vista.addObject("listaBiblioteca",listaBiblioteca);
		
		return vista;
	}
	
	@RequestMapping("cambiarEstadoBiblioteca-{ssoId}.html")
	public ModelAndView cambiarEstadoBiblioteca(@PathVariable int ssoId) {
		Biblioteca biblioteca= Biblioteca.ReadOne(ssoId);
		if(biblioteca==null) {
			System.out.println("No se encontro");
		}
		else {
			if(biblioteca.getEstado().getId()==1) {
				biblioteca.getEstado().setId(2);
			}
			else {
				biblioteca.getEstado().setId(1);
			}
			Biblioteca.Update(biblioteca);
		}
		return vistaPrestamo();
	} 
	
	@RequestMapping("mostrarPorIdEstadoPrestamo-{ssoId}.html") //IR A BIBLIOTECA
	public ModelAndView vistaBibliotecaPorEstado(@PathVariable int ssoId) {
		vista = new ModelAndView();
		
		List<Biblioteca>lista=Biblioteca.ReadByIdEstado(ssoId);
		if(lista==null) 
			System.out.println("No encontro Biblioteca");
		else
			System.out.println(lista.toString());
		if(lista!=null)
			vista.addObject("listaBiblioteca",lista);
		
		vista.setViewName("prestamo");
		return vista;
	}
}
