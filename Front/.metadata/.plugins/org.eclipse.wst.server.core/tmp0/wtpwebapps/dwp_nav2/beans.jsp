<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beans</title>
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />

	
	<h1>Listado&nbsp;</h1>
	<ul>
		<c:forEach items="${listado}" var="bean">
		<li> 
		
		<a href="${context}/bean?id=${bean.id}">${bean.nombre}</a>
		</li>
		</c:forEach>
	</ul>
	<a href="${context}/bean/crear">Crear Nuevo</a>
</body>
</html>