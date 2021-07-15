<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paises</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;800;900&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Poppins', sans-serif;
	margin: 5% 10%;
}
</style>
</head>
<body>	
	<h1>Lista de Países&nbsp; <a href="./pais/crear"><img src="./img/plus.png" width="30px" height="30px"></a></h1>
	<ul>
		<c:forEach items="${listado}" var="pais">
			<li> <a href="./pais?id=${pais.paisId}" >${pais.nombre} </a></li>
		</c:forEach>
	</ul>
</body>
</html>