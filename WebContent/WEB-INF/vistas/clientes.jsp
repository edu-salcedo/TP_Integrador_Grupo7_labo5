<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>

	<script src="https://kit.fontawesome.com/067889c2a3.js" crossorigin="anonymous"></script>	
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	 crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css"/>
  	<link rel="stylesheet" href="./resources/css/StyleMenu.css">
	
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
							class="fa-solid fa-hand-holding-dollar"></i> Pr�stamos</a></li>
					<li><a href="index.html" class="nav-link"><i
							class="fa-solid fa-right-from-bracket"></i> Cerrar Sesi�n</a></li>
				</ul>
			</div>
		</div>



		<div class="main-container text-center">
			<h2>Lista de Clientes</h2>
			<div class="border p-1 bg bg-white border border-3 mx-5">
				<div class="fila">
					<div class="agregar">
						<a href="cliente.html"
							class="btn btn-outline-success btn-sm ms-5 mt-2"> <i
							class="fa-solid fa-user-plus "></i>
						</a>
					</div>
					<form method=get action="filtrarClientes.html">
						<div class="buscar me-5 mt-2">
							<input type="text" class=" border rounded-3" name="txtBuscar"
								placeholder="Buscar" /> <a href=""><i class="bi bi-search "></i></a>
							<input type="submit" value="Buscar">
						</div>
					</form>

				</div>
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
								<td><a href="/cliente.html" class="btn btn-outline-primary"><i
										class="bi bi-eye"></i></a> <a
									href="<c:url value='modificarCliente-${item.id}.html' />"
									class="btn btn-outline-success"><i class="bi bi-pencil"></i></a>
									<a href="<c:url value='eliminarCliente-${item.id}.html' />"
									class="btn btn-outline-danger"><i class="bi bi-trash-fill"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>