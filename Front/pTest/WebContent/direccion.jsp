<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Direccion</title>
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
			<td>Código Postal</td>
			<td>${element.codPostal}</td>
		</tr>
		<tr>
			<td>Ciudad</td>
			<td>${element.ciudad}</td>
		</tr>
		<tr>
			<td>Estado</td>
			<td>${element.estado}</td>
		</tr>
		<tr>
			<td>Id País</td>
			<td>${element.pais.paisId}</td>
		</tr>
		<tr>
			<td>Nombre País</td>
			<td>${element.pais.nombre}</td>
		</tr>
		<tr>
			<td>Id Región</td>
			<td>${element.pais.region.id}</td>
		</tr>
		<tr>
			<td>Nombre Región</td>
			<td>${element.pais.region.nombre}</td>
		</tr>
		<tr>
			<!-- <td colspan=2><input type="submit" value="Enviar"></td> -->
			<td><a href="./direccion/modificar?id=${element.id}&accion=M">Modificar</a></td>
			<td><a href="./direcciones">Volver</a></td>
		</tr>
	</table>
	
</body>
</html>