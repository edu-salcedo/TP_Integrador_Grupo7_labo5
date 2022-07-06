<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	 crossorigin="anonymous">
	 <script src="https://kit.fontawesome.com/067889c2a3.js" crossorigin="anonymous"></script>	
	 	<link rel="stylesheet" href="./resources/css/login.css">
</head>
<body>
	<div class="main-container">
		<c:choose>
			<c:when test="${usuarioLogeado==null || usuarioLogeado==''}">
				<div class="login-box">
					<form method="post" action="login.html">

						<h2 class="mt-3">Iniciar Sesion</h2>
						<div>
							<i class="fa-solid fa-user"></i>
						</div>
						<div>
							<label class="my-2">Usuario</label> <input type="text"
								class="m-auto form-control w-75" name="txtUsuario">
						</div>
						<div>
							<label>Contrase�a</label> <input type="password"
								class="m-auto form-control w-75" name="txtPassword">
						</div>
						<div>
							<input type="submit" class="btn btn-primary" style="margin: 5%;" value="Ingresar" name="btnIngresar">
						</div>
						<h4 class="mb-3">${mensaje}</h4>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<h4>Usuario: ${usuarioLogeado}</h4>
					<a href="logout.html">logout</a>
					<a href="home.html">home</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>