<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Region</title>
</head>
<body>
	<br>
	El usuario es: ${usuario}
	<br>
	Numero de sesiones:${numSessions}
	
	<h1>Region</h1>
	${element}
	<table>
		<tr>
			<td>Id Region</td>
			<td>${element.id}</td>
		</tr>
		<tr>
			<td>Nombre Region</td>
			<td>${element.nombre}</td>
		</tr>
		<tr>
			<td><a href="./region/modificar?id=${element.id}">Modificar</a></td>
		</tr>

		<tr>
			<td><a href="./region/borrar?id=${element.id}">Borrar</a></td>
		</tr>

		<tr>
			<td><a href="./regiones">Ir a listado</a></td>
		</tr>
	</table>

</body>
</html>