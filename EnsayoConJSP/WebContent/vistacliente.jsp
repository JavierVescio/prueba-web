<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="datos.sectorPersonal.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión Restaurant - Cliente</title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<% Cliente cliente = (Cliente)request.getAttribute("cliente"); %>
	<br> 
		Apellido: <%= cliente.getApellido() %><br> 
		Nombre: <%= cliente.getNombre() %><br> 
		DNI: <%= cliente.getDni() %><br> 
		ID: <%= cliente.getIdPersona() %><br>
	<br>
	<a href="/GestionRestaurant/index.jsp">Volver...</a>
</body>
</html>