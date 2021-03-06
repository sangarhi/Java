<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regioness</title>
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
	
	<c:set var="context" value="${pageContext.request.contextPath}" />
	${context}
	<h1>Lista de Regiones&nbsp; <a href="${context}/region/crear"><img src="${context}/img/plus.png" width="30px" height="30px"></a></h1>
	<ul>
		<c:forEach items="${listado}" var="region">
			<li> <a href="${context}/region?id=${region.id}" >${region.nombre} </a></li>
		</c:forEach>
	</ul>
</body>
</html>