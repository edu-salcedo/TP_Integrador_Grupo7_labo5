<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Elegir Cliente</h1>
		<div>
			<h4>Session: ${usuarioLogeado}</h4>
		</div>
		<div class="row">
			<div class="col">
				<h3>Seleccionar Cliente</h3>
				<div>
					<form method=get action="prestamoFiltrarClientes.html">
						<div>
							<input type="text" name="txtBuscar">
						</div>
						<div>
							<input type="submit" value="Buscar">
						</div>
						<div>
							<input type="hidden" name="txtIdBiblioteca" value="${biblioteca.getId()}" readonly>
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
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listaClientes}" var="item">
							<tr>
								<td>${item.getNombre()}</td>
								<td> ${item.getApellido()}</td>
								<td> ${item.getNacionalidad().getDescripcion()}</td>
								<td> ${item.getEmail()}</td>
								
								<td> <a href="<c:url value='prestamoSeleccionarCliente-${item.id}-${biblioteca.getId()}.html' />">Seleccionar</a></td>
							</tr>
						</c:forEach>
						</tbody>
						<tfoot>
						
						</tfoot>
					</table>
					
				</div>
			</div>
		
			<div class="col">
				<h3>Prestamo</h3>
				<form method=get action="realizarPrestamo.html" onsubmit="return validarCantidad();">
					<div>
						<label>Libro</label><br>
						<label>ID: </label>
						<input type="text" name="txtIdBiblioteca" value="${biblioteca.getId()}" readonly>
						<label>Titulo: </label>
						<input type="text" name="txtTitulo" value="${biblioteca.getLibro().getTitulo()}" readonly>
						<label>Autor: </label>
						<input type="text" name="txtAutor" value="${biblioteca.getLibro().getAutor().getNombre()} ${biblioteca.getLibro().getAutor().getApellido()}" readonly>
					</div>
					<div>
						<label>Cliente</label>
						<input type="text" name="txtClienteId" value="${clienteElegido.getId()}" readonly>
						<input type="text" name="txtCliente" value="${clienteElegido.getNombre()} ${clienteElegido.getApellido()}" readonly>
						<input type="text" name="txtTelefono" value="${clienteElegido.getTelefono()}" readonly>
					</div>
					<div>
						<label>Cantidad de dias</label>
						<select name="cbCantidadDias">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
						</select>
					</div>
					<div>
						<input type="submit" value="Finalizar">
					</div>
				</form>
			</div>
		</div>
		<div>
			<a href="index.html">index</a>
			<a href="clientes.html">clientes</a>
			<a href="biblioteca.html">biblioteca</a>
			<a href="cliente.html">cliente</a>
			<a href="libro.html">libro</a>
		</div>
	</div>
</body>

</html>