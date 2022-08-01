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
  	<link rel="stylesheet" href="./resources/css/prestamo.css">
</head>

     <jsp:include page="Modal.jsp"></jsp:include>
	<div class="upbar d-flex">
		<img src="./resources/img/logo.png" class="" alt="" />
		<h4 class="mt-3">Usuario : ${usuarioLogeado}</h4>
	</div>

	<div class="row-container">
		<div class="wrapper">
			<div class="sidebar">
				<ul class="navbar-nav">
					<i class="fa-solid fa-user-gear admin"></i>
					<li>
					    <a href="home.html" class="nav-link"><i class="fa-solid fa-house-chimney"></i> Home</a>
				    </li>
							
					<li>
					    <a href="biblioteca.html" class="nav-link"><i class="bi bi-collection-fill"></i> Biblioteca</a>
					</li>																						
							
					<li>
		                <a href="clientes.html" class="nav-link"><i class="fa-solid fa-user-large"></i> Clientes</a>
					</li>
							
					<li>
					    <a href="prestamos.html" class="nav-link"><i class="fa-solid fa-hand-holding-dollar"></i> Préstamos</a>
					</li>
							
					<li>
					   <a onclick="return confirm('¿Desea cerrar sesion?')" href="logout.html" class="nav-link"><i
							class="fa-solid fa-right-from-bracket"></i> Cerrar Sesión</a>
					</li>
				</ul>
			</div>
		</div>



		<div class="main-container text-center">
			<h2 class="text-secondary">Formulario</h2>
			<div class="border p-1 bg bg-white border border-3 mx-5">
				<div class="fila ">
					<div class=" m-auto form border p-3 rounded-3">
						<form action="guardarCliente.html" method="post" class="needs-validation" id="form"  novalidate>
							
									<div class="col d-flex">
										<label class="w-100">DNI</label> 
										 <input type="hidden"value="${cliente.getId()}" name="txtIdCliente">
										 <input class="form-control"type="text" name="txtDni" required  pattern="[0-9]{8}" maxlength="8" 
										 <c:if test="${cliente!=null && cliente!=''}">value="${cliente.getDni()}"</c:if> 
										 <c:if test="${mostrar!=null}">readonly</c:if>>
										 
									</div>
									<div class="col d-flex my-2">
										<label class="w-100">Nombre</label>
										 <input type="text"class="form-control" name="txtNombre" required pattern="^(?=.{3,30}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$" 
										  <c:if test="${cliente!=null && cliente!=''}">value="${cliente.getNombre()}"</c:if>
										  <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex">
										<label class="w-100">Apellido</label> 
										<input type="text"class="form-control" name="txtApellido" required  pattern="^(?=.{3,30}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$" 
										<c:if test="${cliente!=null && cliente!=''}">value="${cliente.getApellido()}"</c:if>
										<c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex my-2">
										<label class="w-75">Nacionalidad</label>
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
										 <input type="date"class="form-control" name="txtNacimiento"
										 <c:if test="${cliente!=null && cliente!=''}">value="${cliente.getNacimiento().toString()}"</c:if>
										 <c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex my-2">
										<label class="w-100">Direccion</label> 
										<input type="text"class="form-control" name="txtDireccion" required
										<c:if test="${cliente!=null && cliente!=''}">value="${cliente.getDireccion()}"</c:if>
										<c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex">
										<label class="w-100">Localidad</label> 
										<input type="text" class="form-control" name="txtLocalidad"   required
										<c:if test="${cliente!=null && cliente!=''}">value="${cliente.getLocalidad()}"</c:if>
										<c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex my-2">
										<label class="w-100">Email</label> 
										<input type="text" class="form-control" name="txtEmail" required
										<c:if test="${cliente!=null && cliente!=''}">value="${cliente.getEmail()}"</c:if>
										<c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
									<div class="col d-flex">
										<label class="w-100">Telefono</label> 
										<input type="text"class="form-control" name="txtTelefono" pattern="[0-9]{8,10}" required
										<c:if test="${cliente!=null && cliente!=''}">value="${cliente.getTelefono()}"</c:if>
										<c:if test="${mostrar!=null}">readonly</c:if>>
									</div>
								
							<div class= "d-flex justify-content-around mt-3">
								<c:if test="${mostrar==null}">
									<input type="button" class=" btn1 me-5 btn btn-success" value="Aceptar" name="btnAceptar" >
								</c:if>
							   <c:if test="${mostrar!=null}">
								  <div class="opacity-0">
									 <h3 class="">h</h3>
								  </div>
							  </c:if>

						</div>
						</form>
						<div class="position-relative bg bg-warning">
						     <a class="btn btn-info position-button" href="clientes.html" >Volver</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	<script src="./resources/js/validar.js"></script>
</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
	
	
</body>
</html>