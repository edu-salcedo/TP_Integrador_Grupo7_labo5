<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Biblioteca</h1>
		<div>
			<h4>Session:${usuarioLogeado}</h4>
		</div>
		<div>
			<a href="<c:url value='mostrarPorIdEstado-${1}.html' />">Prestado</a>
			<a href="<c:url value='mostrarPorIdEstado-${2}.html' />">En biblioteca</a>
			<a href="biblioteca.html">Todos</a>
		</div>
		
		<div>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Libro</th>
						<th>Fecha de Alta</th>
						<th>Estado</th>
						<th>Accion</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listaBiblioteca}" var="item">
					<tr>
						<td>${item.getId()}</td>
						<td> ${item.getLibro().getTitulo()}</td>
						<td> ${item.getFechaAlta()}</td>
						<td> ${item.getEstado().getDescripcion()}</td>
						<td> <a href="<c:url value='eliminarBiblioteca-${item.id}.html' />"  >eliminar</a></td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				
				</tfoot>
			</table>
		</div>
		<div>
			<a href="index.html">index</a>
			<a href="clientes.html">clientes</a>
			<a href="prestamo.html">prestamo</a>
			<a href="cliente.html">cliente</a>
		</div>
	</div>
</body>
</html>