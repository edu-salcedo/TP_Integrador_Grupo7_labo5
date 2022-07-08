package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.entidades.Biblioteca;
import app.servicio.ServicioBiblioteca;

@Controller
public class LibroController {
	@Autowired
	@Qualifier("modelAndView")
	private ModelAndView vista;
	@Autowired
	@Qualifier("servicioBiblioteca")
	private ServicioBiblioteca servicioBiblioteca;
	
	@RequestMapping("libro-{idBiblioteca}.html") //IR A BIBLIOTECA
	public ModelAndView vistaLibro(@PathVariable Integer idBiblioteca) {
		try 
		{
			if(idBiblioteca==null)
				vista.setViewName("biblioteca");
			else {
				Biblioteca biblioteca=servicioBiblioteca.readOne(idBiblioteca);
				if(biblioteca==null)
					vista.setViewName("biblioteca");
				else {
					vista.addObject("biblioteca",biblioteca);
					vista.setViewName("libro");
				}
				/*
				biblioteca.getId();
				biblioteca.getLibro().getIsbn();
				biblioteca.getLibro().getAutor().getNombre();
				biblioteca.getLibro().getAutor().getApellido();
				biblioteca.getLibro().getTitulo();
				biblioteca.getLibro().getDescripcion();
				biblioteca.getLibro().getCantidadPaginas();
				biblioteca.getLibro().getIdioma();
				biblioteca.getLibro().getFechaLanzamiento();
				biblioteca.getFechaAlta();
				biblioteca.getLibro().getGeneros().toString();
				*/
			}
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
}
