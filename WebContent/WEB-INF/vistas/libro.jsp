<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libro</title>
 
	 <script src="https://kit.fontawesome.com/067889c2a3.js" crossorigin="anonymous"></script>	
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	 crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css"/>
    <link rel="stylesheet" href="./resources/css/StyleMenu.css">
    <link rel="stylesheet" href="./resources/css/prestamo.css">
</head>
<body>

	<div class="upbar d-flex">
		<img src="./resources/img/logo.png" class="" alt="" />
		<h4 class="mt-3">Usuario : ${usuarioLogeado}</h4>
	</div>
	<div class="row-container">
		<div class="wrapper">
			<div class="sidebar">
				<ul class="navbar-nav">
					<i class="fa-solid fa-user-gear admin"></i>
					<li><a href="home.html" class="nav-link"><i
							class="fa-solid fa-house-chimney"></i> Home</a></li>

					<li><a href="biblioteca.html" class="nav-link"><i
							class="bi bi-collection-fill"></i> Biblioteca</a></li>

					<li><a href="clientes.html" class="nav-link"><i
							class="fa-solid fa-user-large"></i> Clientes</a></li>

					<li><a href="prestamo.html" class="nav-link"><i
							class="fa-solid fa-hand-holding-dollar"></i> Préstamos</a></li>

					<li><a onclick="return confirm('¿Desea cerrar sesion?')"
						href="logout.html" class="nav-link"><i
							class="fa-solid fa-right-from-bracket"></i> Cerrar Sesión</a></li>
				</ul>
			</div>
		</div>

		<div class="main-container pt-5">
                   <div class="m-auto w-25">
                          <h2>Info del Libro</h2>
                   </div>
			<div class="d-flex justify-content-center w-50 h-75 m-auto  bg bg-white border rounded-3 align-items-center" >

				<div class=" book-info m-4">
					<img src="./resources/img/libro.png" class="" alt="" />
				</div>

				<div class="d-flex flex-column">
					<label><b>ID Biblioteca:</b>${biblioteca.getId()}</label>
					<label><b>ISBN:</b>${biblioteca.getLibro().getIsbn()}</label>
				    <label>T<b>itulo:</b>${biblioteca.getLibro().getTitulo()}</label>
				    <label><b>Genero:</b>
						<c:forEach items="${biblioteca.getLibro().getGeneros()}" var="item">
					             ${item.getDescripcion()} /
				        </c:forEach>
					</label>
					<label><b>Autor:</b> ${biblioteca.getLibro().getAutor().getNombre()}
						        ${biblioteca.getLibro().getAutor().getApellido()}
					</label>
					<label><b>Descripcion:</b>${biblioteca.getLibro().getDescripcion()}</label>
					 <label><b>Paginas:</b>${biblioteca.getLibro().getCantidadPaginas()}</label>
					 <label><b>Idioma:</b>${biblioteca.getLibro().getIdioma()}</label>
					 <label><b>Fechade Lanzamiento:</b> ${biblioteca.getLibro().getFechaLanzamiento()}</label>
					 <label><b>Fecha de Alta:</b> ${biblioteca.getFechaAlta()}</label>
					<div>
						<a href="biblioteca.html" class="btn btn-info mt-5">Atras</a>
					</div>

				</div>

			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>