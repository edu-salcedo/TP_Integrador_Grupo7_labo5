package app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.entidades.Usuario;
import app.servicio.ServicioUsuario;

@Controller
@SessionAttributes({"usuarioLogeado"})
public class UsuarioController {
	@Autowired
	@Qualifier("modelAndView")
	private ModelAndView vista;
	@Autowired
	@Qualifier("servicioUsuario")
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("login.html")
	public ModelAndView login(String txtUsuario,String txtPassword) {
		try 
		{
			Usuario u= servicioUsuario.login(txtUsuario,txtPassword);
			if(u!=null) { 
				vista.addObject("usuarioLogeado", u.getNombre());
				vista.addObject("mensaje", "usuario logueado!");
			}
			else {
				vista.addObject("usuarioLogeado", "");
			}
			vista.setViewName("index");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
	@RequestMapping("logout.html")
	public ModelAndView logout() {
		vista.setViewName("index");
		vista.addObject("mensaje", "Loguearse por favor!");
		vista.addObject("usuarioLogeado", "");
		return vista;
	}
	
	
}
