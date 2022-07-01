<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	 crossorigin="anonymous">
	 <!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	 integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	  crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div>
			<h4>Session: ${usuarioLogeado}</h4>
		</div>
		<div>
			<h1>Clientes</h1>
		</div>
		<div>
			<form method=get action="filtrarClientes.html">
				<div>
					<input type="text" name="txtBuscar">
				</div>
				<div>
					<input type="submit" value="Buscar">
				</div>
			</form>
			
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Nacionalidad</th>
						<th>Email</th>
						<th>Accion1</th>
						<th>Accion2</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listaClientes}" var="item">
					<tr>
						<td>${item.getNombre()}</td>
						<td> ${item.getApellido()}</td>
						<td> ${item.getNacionalidad().getDescripcion()}</td>
						<td> ${item.getEmail()}</td>
						<td> <a href="<c:url value='modificarCliente-${item.id}.html' />">modificar</a></td>
						<td> <a href="<c:url value='eliminarCliente-${item.id}.html' />"  >eliminar</a></td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				
				</tfoot>
			</table>
			
		</div>
		<div>
			<a href="index.html">index</a>
			<a href="biblioteca.html">biblioteca</a>
			<a href="cliente.html">cliente</a>
			<a href="prestamo.html">prestamo</a>
		</div>
	</div>
</body>
</html>