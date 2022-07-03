<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>Error</h1>
		</div>
		<div>
			<b>Excepcion:</b> ${error.getClass()}
		</div>
		<div>
			<b>Mensaje:</b> ${error.getMessage().toString()}
		</div>
		<div>
			<b>Stack trace:</b> ${error.getStackTrace()}
		</div>
		<div>
			<b>Localized Message:</b> ${e.getLocalizedMessage()}
		</div>
		<div>
			<a href="index.html">Index</a>
		</div>
	</div>
</body>
</html>