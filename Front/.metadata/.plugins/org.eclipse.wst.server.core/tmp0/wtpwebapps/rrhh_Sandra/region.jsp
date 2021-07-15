<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Región</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;800;900&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Poppins', sans-serif;
}

td {
	padding: 2px 10px;
}
</style>
</head>
<body>
	<h1>Región</h1>
	${element}
	<table>
		<tr>
			<td>Id</td>
			<td>${element.id}</td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td>${element.nombre}</td>
		</tr>
		<tr>
			<!-- <td colspan=2><input type="submit" value="Enviar"></td> -->
			<td><a href="./region/modificar?id=${element.id}&accion=M">Modificar</a></td>
			<td><a href="./region/eliminar?id=${element.id}&accion=E">Eliminar</a></td>
			<td><a href="./regiones">Volver</a></td>
		</tr>
	</table>
	
</body>
</html>