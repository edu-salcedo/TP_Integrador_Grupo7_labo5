<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>Cliente</h1>
		</div>
		<div>
	   		<form action="guardarCliente.html" method="post">
	   		<c:choose>
	   			<c:when test="${ cliente!=null && cliente!='' }">
	   				<div>
						<label>DNI</label>
						<input type="hidden" value="${cliente.getId()}" name= "txtIdCliente">
						<input type="text" value="${cliente.getDni()}" name="txtDni">
					</div>
					<div>
						<label>Nombre</label>
						<input type="text" value="${cliente.getNombre()}" name="txtNombre">
					</div>
					<div>
						<label>Apellido</label>
						<input type="text" value="${cliente.getApellido()}" name="txtApellido" >
					</div>
					<div>
						<label>Nacionalidad</label>
						
						<select name="cbNacionalidad">
							<c:forEach items="${listaNacionalidades}" var="item">
								
								<c:choose>
								   <c:when test="${item.id == cliente.getNacionalidad().getId() }">
								   		<option value="${item.id}" selected >${item.descripcion}</option>
								   </c:when> 
								   <c:otherwise>
								   		<option value="${item.id}" >${item.descripcion}</option>
								   </c:otherwise>   
								</c:choose>
								
							</c:forEach>
						</select>
					</div>
					<div>
						<label>Fecha Nacimiento</label>
						<input type="date" value="${cliente.getNacimiento().toString()}" name="txtNacimiento">
					</div>
					<div>
						<label>Direccion</label>
						<input type="text" value="${cliente.getDireccion()}" name="txtDireccion">
					</div>
					<div>
						<label>Localidad</label>
						<input type="text" value="${cliente.getLocalidad()}" name="txtLocalidad">
					</div>
					<div>
						<label>Email</label>
						<input type="text" value="${cliente.getEmail()}" name="txtEmail">
					</div>
					<div>
						<label>Telefono</label>
						<input type="text" value="${cliente.getTelefono()}" name="txtTelefono">
					</div>
	   			</c:when>
	   			
	   			<c:otherwise>
	   				<div>
						<label>DNI</label>
						<input type="text" name="txtDni">
					</div>
					<div>
						<label>Nombre</label>
						<input type="text" name="txtNombre">
					</div>
					<div>
						<label>Apellido</label>
						<input type="text" name="txtApellido" >
					</div>
					<div>
						<label>Nacionalidad</label>
						
						<select name="cbNacionalidad">
							<c:forEach items="${listaNacionalidades}" var="item">
						   		<option value="${item.id}" >${item.descripcion}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label>Fecha Nacimiento</label>
						<input type="date" name="txtNacimiento">
					</div>
					<div>
						<label>Direccion</label>
						<input type="text" name="txtDireccion">
					</div>
					<div>
						<label>Localidad</label>
						<input type="text" name="txtLocalidad">
					</div>
					<div>
						<label>Email</label>
						<input type="text" name="txtEmail">
					</div>
					<div>
						<label>Telefono</label>
						<input type="text" name="txtTelefono">
					</div>
	   			</c:otherwise>
	   		</c:choose>
				<div>
					<input type="submit" value="Aceptar" name="btnAceptar">
				</div>
			</form>
		</div>
		<div>
			<h5>Nombre: ${cliente.getNombre()}</h5>
			<h5>Apellido: ${cliente.getApellido()}</h5>
			<h5>Direccion: ${cliente.getDireccion()}</h5>
			<h5>DNI: ${cliente.getDni()}</h5>
			<h5>Email: ${cliente.getEmail()}</h5>
			<h5>Telefono: ${cliente.getTelefono()}</h5>
			<h5>Nacimiento: ${cliente.getNacimiento().toString()}</h5>
			<h5>Nacionalidad: ${cliente.getNacionalidad().getId()}</h5>
		</div>
		<div>
			<h4>Session: ${usuarioLogeado}</h4>
		</div>
		
		<div>
			<a href="index.html">index</a>
			<a href="clientes.html">clientes</a>
			<a href="biblioteca.html">biblioteca</a>
			<a href="prestamo.html">prestamo</a>
			<a href="libro.html">libro</a>
		</div>
		
	</div>
	
</body>
</html>