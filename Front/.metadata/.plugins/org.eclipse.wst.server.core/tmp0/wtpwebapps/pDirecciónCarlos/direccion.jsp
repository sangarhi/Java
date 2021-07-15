<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Direccion</title>
</head>
<body>
	<h1>Direccion</h1>
	${element}
	<table>
		<tr>
			<td>Id</td>
			<td>${element.id}</td>
		</tr>
		<tr>
			<td>Calle</td>
			<td>${element.calle}</td>
		</tr>
		<tr>
			<td>Codigo Postal</td>
			<td>${element.codPostal}</td>
		</tr>
		<tr>
			<td>Ciudad</td>
			<td>${element.ciudad}</td>
		</tr>
		<tr>
			<td>Provincia</td>
			<td>${element.estado}</td>
		</tr>
		<tr>
			<td>Id Pais</td>
			<td>${element.pais.paisId}</td>
		</tr>
		<tr>
			<td>Nombre Pais</td>
			<td>${element.pais.nombre}</td>
		</tr>
		<tr>
			<td>Id Region</td>
			<td>${element.pais.region.id}</td>
		</tr>
		<tr>
			<td>Nombre Region</td>
			<td>${element.pais.region.nombre}</td>
		</tr>
		<tr>
				<td><a href="./direccion/modificar?id=${element.id}">Modificar</a></td>
				<td><a href="./direcciones;">Volver</a></td>
			</tr>
	</table>
	
	
	
</body>
</html>