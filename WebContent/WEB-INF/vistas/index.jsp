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
	 <!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	 integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	  crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		
		<c:choose>
		    <c:when test="${usuarioLogeado==null || usuarioLogeado==''}">
				<h4>${mensaje}</h4>
		     	<form method="post" action="login.html">
					<div>
						<label>Usuario</label>
						<input type="text" name="txtUsuario">
					</div>
					<div>
						<label>Contraseña</label>
						<input type="password" name="txtPassword">
					</div>
					<div>
						<input type="submit" value="Ingresar" name="btnIngresar">
					</div>
				</form>
		    </c:when>    
		    <c:otherwise>
		    	<div>
		    		<h4>${mensaje}</h4>
					<h4>Usuario: ${usuarioLogeado}</h4>
					<a href="logout.html">logout</a>
				</div>
		       
		    </c:otherwise>
		</c:choose>
		
		<div>
			<a href="clientes.html">clientes</a>
			<a href="cliente.html">cliente</a>
			<a href="biblioteca.html">biblioteca</a>
			<a href="prestamo.html">prestamo</a>
			<a href="libro.html">libro</a>
		</div>
		
	</div>
</body>
</html>