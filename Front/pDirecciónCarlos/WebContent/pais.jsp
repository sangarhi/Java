<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pais</title>
</head>
<body>
	<h1>Pais</h1>
	${element}
	<br>
	El usuario es:${usuario}
		
	<table>
		<tr>
			<td>Id</td>
			<td>${element.paisId}</td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td>${element.nombre}</td>
		</tr>		
		
		<tr>
			<td>Id Region</td>
			<td>${element.region.id}</td>
		</tr>
		<tr>
			<td>Nombre Region</td>
			<td>${element.region.nombre}</td>
		</tr>
		<tr>
				<td><a href="./pais/modificar?id=${element.paisId}">Modificar</a></td>
				<td><a href="./paises">Volver</a></td>
			</tr>
	</table>

	
	<ul>
	<c:if test="listado == null">El listado no esta</c:if>
		<c:forEach items="${listado}" var="pais">
		<li> 
		
		<a href="./pais?id=${pais.paisId}">${pais.nombre}</a>
		</li>
		</c:forEach>
	</ul>
	
</body>
</html>