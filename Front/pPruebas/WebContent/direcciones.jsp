<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Direcciones</title>
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
	<h1>Direcciones</h1>
	<!--  %String texto = (String)request.getAttribute("test"); %>
<h1>%=texto %></h1> ANTES SIN TAGLILB -->
	<h1>${test}</h1>
	<c:if test="${test.length() > 3}">La longitud es mayor de 3</c:if>
	<br>
	<c:set var="fecha" value="<%=new java.util.Date()%>"></c:set>
	<fmt:formatDate value="${fecha}" pattern="dd/MM/yy" />
	<br>
	<fmt:formatDate value="<%=new java.util.Date()%>" pattern="dd/MM/yy" />
	<br>
	<c:set var="cadena" value="${test}"></c:set>
	<c:out value="${cadena}"></c:out>
	<!-- Equivalente con la de abajo -->
	<p>${cadena}</p>
	<hr>
	<h1>Listado&nbsp; <a href="./direccion/crear"><img src="./img/plus.png" width="30px" height="30px"></a></h1>
	<ul>
		<c:forEach items="${listado}" var="direccion">
			<li> <a href="./direccion?id=${direccion.id}" >${direccion.calle} ${direccion.codPostal} ${direccion.ciudad} ${direccion.estado} </a></li>
		</c:forEach>
	</ul>
</body>
</html>