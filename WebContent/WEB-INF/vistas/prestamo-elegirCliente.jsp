<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar prestamo</title>

 <script src="https://kit.fontawesome.com/067889c2a3.js" crossorigin="anonymous"></script>	
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	 crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css"/>
  	<link rel="stylesheet" href="./resources/css/cliente.css">
  	<link rel="stylesheet" href="./resources/css/prestamo.css">
</head>
<body>

	<div class="upbar d-flex">
		<img src="./resources/img/logo.png" class="" alt="" />
		<h4 class="mt-3">usuario : ${usuarioLogeado}</h4>
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
					<li><a href="libro.html" class="nav-link"><i
							class="fa-solid fa-book"></i> Libros</a></li>
					<li><a href="clientes.html" class="nav-link"><i
							class="fa-solid fa-user-large"></i> Clientes</a></li>
					<li><a href="prestamo.html" class="nav-link"><i
							class="fa-solid fa-hand-holding-dollar"></i> Préstamos</a></li>
					<li><a href="index.html" class="nav-link"><i
							class="fa-solid fa-right-from-bracket"></i> Cerrar Sesión</a></li>
				</ul>
			</div>
		</div>


		<div class="main-container text-center">
			<h2>Formulario Alta Prestamo</h2>
			<div class="border p-1 bg bg-white border border-3 mx-5">
				<form method=get action="prestamoFiltrarClientes.html">
					<div class="d-flex justify-content-end">
						<div class="buscar me-5 mt-2">
							<input type="text" class=" border rounded-3" name="txtBuscar"
								placeholder="buscar cliente"> <input type="submit"
								class="btn btn-light btn-sm border" value="Buscar">
						</div>
						<div>
							<input type="hidden" name="txtIdBiblioteca"
								value="${biblioteca.getId()}" readonly>
						</div>
					</div>
				</form>
				<table class="table border border-3">
					<thead>
						<tr class="bg-primary p-2 text-dark bg-opacity-10">
							<th scope="col">Nombre</th>
							<th scope="col">Apellido</th>
							<th scope="col">Nacionalidad</th>
							<th scope="col">Email</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaClientes}" var="item">
							<tr>
								<td>${item.getNombre()}</td>
								<td>${item.getApellido()}</td>
								<td>${item.getNacionalidad().getDescripcion()}</td>
								<td>${item.getEmail()}</td>

								<td><a
									href="<c:url value='prestamoSeleccionarCliente-${item.id}-${biblioteca.getId()}.html' />">Seleccionar</a></td>
								<!-- <td> <a href="<c:url value='PrestamoSeleccionarCliente-${item.id}.html' />">Seleccionar</a></td> -->
								<!--
								<td>
									<a href="
									<c:url value='PrestamoSeleccionarCliente.html'>
										<c:param name="idCliente" value="${item.id}" />
										<c:param name="idBiblioteca" value="${biblioteca.getId()}" />
									</c:url>">Seleccionar</a>
								</td>
								-->
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h3>Prestamo</h3>
				<form method=get action="realizarPrestamo.html">

					<div class="px-5 py-2 box-prestamo">
						<h5>Libro</h5>
						<div class="d-flex justify-content-start my-3">
							<label>ID:</label> <input type="text" class="border rounded-3"
								name="txtIdBiblioteca" value="${biblioteca.getId()}" readonly>
							<label>Titulo: </label> <input type="text"
								class="border rounded-3" name="txtTitulo"
								value="${biblioteca.getLibro().getTitulo()}" readonly> <label>Autor:
							</label> <input type="text" class="border rounded-3 " name="txtAutor"
								value="${biblioteca.getLibro().getAutor().getNombre()} ${biblioteca.getLibro().getAutor().getApellido()}"
								readonly>
						</div>
						<h5>Cliente</h5>
						<div class="d-flex justify-content-start">
							<label>ID:</label> <input type="text" class="border rounded-3"
								name="txtClienteId" value="${clienteElegido.getId()}" readonly>
							<label>Nombre: </label> <input type="text"
								class="border rounded-3" name="txtCliente"
								value="${clienteElegido.getNombre()} ${clienteElegido.getApellido()}"
								readonly> <label>Telefono: </label> <input type="text"
								class="border rounded-3" name="txtTelefono"
								value="${clienteElegido.getTelefono()}" readonly>
						</div>
						<div class="d-flex justify-content-start my-3">
							<label>Cantidad dias</label> <input type="text"
								class="border rounded-3 mx-3" name="txtCantidadDias">
						</div>
						<div>
							<input type="submit" class="btn btn-primary " value="Finalizar">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	 integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	  crossorigin="anonymous"></script>
	
	
	
</body>
</html>