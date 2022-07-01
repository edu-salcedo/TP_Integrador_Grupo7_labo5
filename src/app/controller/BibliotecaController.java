package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.entidades.Biblioteca;
import app.servicio.ServicioBiblioteca;

@Controller
public class BibliotecaController {
	@Autowired
	@Qualifier("modelAndView")
	private ModelAndView vista;
	@Autowired
	@Qualifier("servicioBiblioteca")
	private ServicioBiblioteca servicioBiblioteca;
	
	@RequestMapping("biblioteca.html") //IR A BIBLIOTECA
	public ModelAndView vistaBiblioteca() {
		try 
		{
			List<Biblioteca>listaBiblioteca=servicioBiblioteca.readAll();
			vista.addObject("listaBiblioteca",listaBiblioteca);
			vista.setViewName("biblioteca");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
	
	@RequestMapping("mostrarPorIdEstado-{ssoId}.html") //IR A BIBLIOTECA
	public ModelAndView vistaBibliotecaPorEstado(@PathVariable int ssoId) {
		try 
		{
			List<Biblioteca>lista=servicioBiblioteca.readByIdEstado(ssoId);
			vista.addObject("listaBiblioteca",lista);
			vista.setViewName("biblioteca");
		}
		catch (Exception e)
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		
		return vista;
	}
	@RequestMapping("eliminarBiblioteca-{ssoId}.html") //IR A BIBLIOTECA
	public ModelAndView eliminarBiblioteca(@PathVariable int ssoId) {
		try 
		{
			Biblioteca b=servicioBiblioteca.readOne(ssoId);
			Biblioteca.Delete(b);
		} catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vistaBiblioteca();
	}
	
}
