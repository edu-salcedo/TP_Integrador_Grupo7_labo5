<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" tabindex="-1" id="modalpopup">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Atencion!</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>¿esta seguro de estra accion?</p>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary"
						onclick="form_submit()">Aceptar</button>
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
 	  function form_submit() 
 	  {
 	    document.getElementById("form").submit();
 	   }    
 	 </script>



</body>
</html>