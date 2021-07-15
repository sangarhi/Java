<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paises</title>
</head>
<body>
	<br>
	El usuario es:${usuario}
	<br>
	Numero de sessiones:${numSessions}

<c:set var="context" value="${pageContext.request.contextPath}" />

	
	<h1>Listado&nbsp;<a href="./pais/crear"><img src="./img/plus.png" width="30px" height="30px"></a></h1>
	<ul>
		<c:forEach items="${listado}" var="pais">
		<li> 
		
		<a href="./pais?id=${pais.paisId}">${pais.nombre}</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>