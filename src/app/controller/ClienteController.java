package app.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.entidades.Cliente;
import app.entidades.Nacionalidad;
import app.resources.Config;
import app.resources.Util;
import app.servicio.ServicioCliente;
import app.servicio.ServicioNacionalidad;

@Controller
public class ClienteController {
	@Autowired
	@Qualifier("modelAndView")
	private ModelAndView vista;
	@Autowired
	@Qualifier("servicioCliente")
	private ServicioCliente servicioCliente;
	@Autowired
	@Qualifier("servicioNacionalidad")
	private ServicioNacionalidad servicioNacionalidad;
	@Autowired
	@Qualifier("cliente")
	private Cliente cliente;
	
	@RequestMapping("clientes.html")
	public ModelAndView vistaClientes() {
		try 
		{
			vista.clear();
			List<Cliente>lista=servicioCliente.readAll();
			if(lista!=null)
				vista.addObject("listaClientes",lista);
			vista.setViewName("clientes");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
	@RequestMapping("filtrarClientes.html")
	public ModelAndView filtrarClientes(String txtBuscar) {
		try 
		{
			List<Cliente>lista;
			if(txtBuscar!=null) 
				lista=servicioCliente.readMany(txtBuscar);
			else 
				lista=servicioCliente.readAll();
			if(lista!=null)
				vista.addObject("listaClientes",lista);
			vista.setViewName("clientes");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
	
	@RequestMapping("cliente.html") //IR A CLIENTE
	public ModelAndView vistaCliente() {
		try
		{
			List<Nacionalidad>lista=servicioNacionalidad.readAll();
			vista.clear();
			vista.setViewName("cliente");
			if(lista!=null)
				vista.addObject("listaNacionalidades",lista);
		}
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vista;
	}
	
	@RequestMapping("guardarCliente.html")
	public ModelAndView guardar(
			String txtDni,String txtNombre, String txtApellido,
			Integer cbNacionalidad,String txtNacimiento,
			String txtDireccion,String txtLocalidad,String txtEmail,
			String txtTelefono, Integer txtIdCliente) {
		try 
		{
			cliente.setApellido(txtApellido);
			cliente.setDireccion(txtDireccion);
			cliente.setDni(txtDni);
			cliente.setEmail(txtEmail);
			cliente.setNacimiento(Util.FormatDate(Util.SplitDate(txtNacimiento)));
			cliente.setNombre(txtNombre);
			cliente.setTelefono(txtTelefono);
			cliente.setLocalidad(txtLocalidad);
			cliente.getNacionalidad().setId(cbNacionalidad);
			if(txtIdCliente!=null) {
				cliente.setId(txtIdCliente);
				servicioCliente.update(cliente);
			}
			else {
				servicioCliente.create(cliente);
			}
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
			e.getLocalizedMessage();
		}
		return vistaClientes();
	}
	
	@RequestMapping("modificarCliente-{ssoId}.html")
	public ModelAndView modificarClientes(@PathVariable Integer ssoId) {
		if(ssoId==null)
			vista.setViewName("clientes");
		else {
			try 
			{
				cliente=servicioCliente.readOne(ssoId);
				if(cliente==null)
					vista.setViewName("clientes");
				else {
					List<Nacionalidad>lista=servicioNacionalidad.readAll();
					if(lista!=null)
						vista.addObject("listaNacionalidades",lista);
					vista.addObject("cliente", cliente);
					vista.setViewName("cliente");
				}
			} 
			catch (Exception e) 
			{
				vista.addObject("error",e);
				vista.setViewName("error");
			}
		}
		return vista;
	}
	
	@RequestMapping("eliminarCliente-{ssoId}.html")
	public ModelAndView eliminarClientes(@PathVariable Integer ssoId) {
		try 
		{
			cliente=servicioCliente.readOne(ssoId);
			servicioCliente.delete(cliente);
			vista.setViewName("clientes");
		} 
		catch (Exception e) 
		{
			vista.addObject("error",e);
			vista.setViewName("error");
		}
		return vistaClientes();
	}
	
	@RequestMapping("mostrarCliente-{idCliente}.html") 
	public ModelAndView mostrarClientes(@PathVariable Integer idCliente) {
		if(idCliente==null)
			vista.setViewName("clientes");
		else {
			try 
			{
				cliente=servicioCliente.readOne(idCliente);
				if(cliente==null)
					vista.setViewName("clientes");
				else {
					List<Nacionalidad>lista=servicioNacionalidad.readAll();
					if(lista!=null)
						vista.addObject("listaNacionalidades",lista);
					vista.addObject("cliente", cliente);
					vista.addObject("mostrar",true);
					vista.setViewName("cliente");
				}
			} 
			catch (Exception e) 
			{
				vista.addObject("error",e);
				vista.setViewName("error");
			}
		}
		return vista;
	}
	
}
