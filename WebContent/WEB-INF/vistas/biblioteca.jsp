<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>

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
      <h4 class="mt-3">Session: ${usuarioLogeado}</h4>
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
              <a onclick="return confirm('¿Desea cerrar sesion?')" 
              href="logout.html" class="nav-link"><i class="fa-solid fa-right-from-bracket"></i> Cerrar Sesión</a>
            </li>
          </ul>
        </div>
      </div>
      
  

   <div class="main-container text-center">
       <h2>Biblioteca</h2>
       <div class="border p-1 bg bg-white border border-3 mx-5">
       <div class="d-flex justify-content-end">
           <div class="btn-group dropdown-center">
                <button type="button" class="btn border btn-sm m-2 dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    Filtrar por
                </button>
                <ul class="dropdown-menu">
                   <li><a class="dropdown-item" href="<c:url value='mostrarPorIdEstado-${1}.html' />">Prestados</a></li>
                   <li><a class="dropdown-item" href="<c:url value='mostrarPorIdEstado-${2}.html' />">En biblioteca</a></li>
                    <li><a class="dropdown-item"  href="biblioteca.html">Todos</a></li>
                </ul>
           </div>
         </div>
         <table class="table border border-3">
            <thead>
              <tr class="bg-primary p-2 text-dark bg-opacity-10">
                <th scope="col">Id</th>
                <th scope="col">Libro</th>
                <th scope="col">Fecha de alta </th>
                <th scope="col">Estado</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
               <c:forEach items="${listaBiblioteca}" var="item">
					<tr>
						<td>${item.getId()}</td>
						<td> ${item.getLibro().getTitulo()}</td>
						<td> ${item.getFechaAlta()}</td>
						<td> ${item.getEstado().getDescripcion()}</td>
						<td> 
							<a href="<c:url value='libro-${item.id}.html' />" class="btn btn-outline-primary">
							    <i class="bi bi-eye"></i>
							</a> 
							<a onclick="return confirm('¿Desea eliminar este Libro?')" class="btn btn-outline-danger" 
							href="<c:url value='eliminarBiblioteca-${item.id}.html' />"><i class="bi bi-trash-fill"></i></a>
						</td>
					</tr>
				</c:forEach>
            </tbody>
         </table>
      </div>
   </div>
</div>
	
	
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	 integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	  crossorigin="anonymous"></script>
		
</body>
</html>