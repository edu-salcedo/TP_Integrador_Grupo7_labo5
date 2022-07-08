<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libro</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>Libro</h1>
		</div>
		<div>
			<label>ID Biblioteca: ${biblioteca.getId()}</label><br>
			<label>ISBN: ${biblioteca.getLibro().getIsbn()}</label><br>
			<label>Titulo: ${biblioteca.getLibro().getTitulo()}</label><br>
			<label>Genero: 
				<c:forEach items="${biblioteca.getLibro().getGeneros()}" var="item">
					${item.getDescripcion()} /
				</c:forEach>
			</label><br>
			<label>Autor: ${biblioteca.getLibro().getAutor().getNombre()} ${biblioteca.getLibro().getAutor().getApellido()}</label><br>
			<label>Descripcion: ${biblioteca.getLibro().getDescripcion()}</label><br>
			<label>Paginas: ${biblioteca.getLibro().getCantidadPaginas()}</label><br>
			<label>Idioma: ${biblioteca.getLibro().getIdioma()}</label><br>
			<label>Fecha de Lanzamiento: ${biblioteca.getLibro().getFechaLanzamiento()}</label><br>
			<label>Fecha de Alta: ${biblioteca.getFechaAlta()}</label><br>
		</div>
		<div>
			<a href="biblioteca.html">Atras</a>
		</div>
	</div>
</body>
</html>