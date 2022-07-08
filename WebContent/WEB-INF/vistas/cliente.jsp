<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente Update</title>

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
					<li><a onclick="return confirm('�Desea cerrar sesion?')" href="logout.html" class="nav-link"><i
							class="fa-solid fa-right-from-bracket"></i> Cerrar Sesi�n</a></li>
				</ul>
			</div>
		</div>



		<div class="main-container text-center">
			<h2 class="text-secondary">Formulario</h2>
			<div class="border p-1 bg bg-white border border-3 mx-5">
				<div class="fila ">
					<div class=" m-auto form border p-3 rounded-3">
						<form action="guardarCliente.html" method="post">
							<c:choose>
								<c:when test="${ cliente!=null && cliente!='' }">
									<div class="col d-flex">
										<label class="w-100">DNI</label> 
										 <input type="hidden"value="${cliente.getId()}" name="txtIdCliente">
										 <input class="form-control"type="text" value="${cliente.getDni()}" 
										 name="txtDni" <c:if test="${mostrar!=null}">readonly</c:if>>
										 
									</div>
									<div class="col d-flex my-2">
										<label class="w-100">Nombre</label>
										 <input type="text"class="form-control"value="${cliente.getNombre()}"
										  name="txtNombre" <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex">
										<label class="w-100">Apellido</label> 
										<input type="text"class="form-control"value="${cliente.getApellido()}" 
										name="txtApellido" <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex my-2">
										<label class="w-100">Nacionalidad</label>
										<c:choose>
											<c:when test="${mostrar!=null}">
												<input type="text"class="form-control"value="${cliente.getNacionalidad().getDescripcion()}" 
												name="txtNacionalidad" readonly>
											</c:when>
											<c:otherwise>
												<select name="cbNacionalidad" class="border border-1 rounded-2 p-2 w-75">
													<c:forEach items="${listaNacionalidades}" var="item">
		
														<c:choose>
															<c:when
																test="${item.id == cliente.getNacionalidad().getId() }">
																<option  value="${item.id}" selected>${item.descripcion}</option>
															</c:when>
															<c:otherwise>
																<option value="${item.id}">${item.descripcion}</option>
															</c:otherwise>
														</c:choose>
		
													</c:forEach>
												</select>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col d-flex">
										<label class="w-100">Fecha Nacimiento</label>
										 <input type="date"class="form-control"value="${cliente.getNacimiento().toString()}"
										 name="txtNacimiento" <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex my-2">
										<label class="w-100">Direccion</label> 
										<input type="text"class="form-control"value="${cliente.getDireccion()}" 
										name="txtDireccion" <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex">
										<label class="w-100">Localidad</label> 
										<input type="text" class="form-control"value="${cliente.getLocalidad()}" 
										name="txtLocalidad" <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex my-2">
										<label class="w-100">Email</label> 
										<input type="text" class="form-control" value="${cliente.getEmail()}" 
										name="txtEmail" <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex">
										<label class="w-100">Telefono</label> 
										<input type="text"class="form-control"value="${cliente.getTelefono()}"
										 name="txtTelefono" <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
								</c:when>

								<c:otherwise>
									<div  class="col d-flex">
										<label class="w-100">DNI</label> 
										<input type="text" pattern="[0-9]{7,8}" maxlength="8" name="txtDni" class="form-control" required>
		           		                <div class="valid-feedback"></div>
									</div>
									<div  class="col d-flex my-2">
										<label class="w-100">Nombre</label> 
										<input type="text" name="txtNombre" class="form-control" required>
									</div>
									<div  class="col d-flex">
										<label class="w-100">Apellido</label>
										 <input type="text" name="txtApellido" class="form-control" required>
									</div>
									<div  class="col d-flex my-2">
										<label class="w-75">Nacionalidad</label>
										 <select name="cbNacionalidad" class="border border-1 rounded-2 p-2 w-75">
											<c:forEach items="${listaNacionalidades}" var="item">
												<option value="${item.id}">${item.descripcion}</option>
											</c:forEach>
										</select>
									</div>
									<div  class="col d-flex">
										<label class="w-100">Fecha Nacimiento</label>
										 <input name="txtNacimiento" type="date" class="form-control" required>
									</div>
									<div  class="col d-flex my-2">
										<label class="w-100">Direccion</label> 
										<input type="text" class="form-control" name="txtDireccion">
									</div>
									<div  class="col d-flex">
										<label class="w-100">Localidad</label> 
										<input type="text" class="form-control" name="txtLocalidad" required>
									</div>
									<div  class="col d-flex my-2">
										<label class="w-100">Email</label>
										 <input type="text" class="form-control" name="txtEmail" required>
									</div>
									<div  class="col d-flex">
										<label class="w-100">Telefono</label> 
										<input type="text" class="form-control" pattern="[0-9]{8,10}" name="txtTelefono" required>
									</div>
								</c:otherwise>
							</c:choose>
							<div>
								<c:if test="${mostrar==null}">
									<input type="submit" class="mt-3 btn btn-primary " value="Aceptar" name="btnAceptar" onclick="return confirm('�Desea guardar estos datos?')">
								</c:if>
								<a class="btn btn-primary" href="clientes.html" >Volver</a>
							</div>
						</form>
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