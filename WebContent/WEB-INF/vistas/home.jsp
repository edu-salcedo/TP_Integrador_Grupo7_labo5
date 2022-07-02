<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/067889c2a3.js" crossorigin="anonymous"></script>	
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	 crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css"/>
  	<link rel="stylesheet" href="./resources/css/cliente.css">
	<link rel="stylesheet" href="./resources/css/login.css">
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
		 
	<div class="home-container">
	   <div class="frase">
		      <h1>Siempre imaginé que el Paraíso sería algún tipo de biblioteca.</h1>			      
		      <h2 ><b>Jorge Luis Borges</b></h2>
	   </div>    
		
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>