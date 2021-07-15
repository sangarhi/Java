<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regiones</title>
</head>
<body>
	<br>
	El usuario es: ${usuario}
	<br>
	Numero de sesiones:${numSessions}
	
<c:set var="context" value="${pageContext.request.contextPath}"/>
	${context}
	<h1>Listado&nbsp;<a href="${context}/region/crear"><img src="${context}/img/plus.png" width="30px" height="30px"></a></h1>
	<ul>
		<c:forEach items="${listado}" var="region">
		<li> 
		
		<a href="./region?id=${region.id}">${region.nombre}</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>