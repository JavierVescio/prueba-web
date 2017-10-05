<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Restaurant - Cliente</title>
</head>
<body>
	<%@ include file="/cabecera.jsp" %>
	
	<form method="POST" action="/GestionRestaurant/MostrarClienteJSP">
	Búsqueda de clientes<br><br>
	
	<table border="0">
		<tr>
			<td>DNI:</td>
			<td><input name="dni"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Consultar"></td>
		</tr>
	</table>
	
	</form>
</body>
</html>