<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Direcciones</title>
</head>
<body>
	<br>
	Numero de sessiones:${numSessions}
	<h2>Estas son las direcciones</h2>
	<h1>${pepe}</h1>
	<c:if test="${pepe.length() >3 }">La longitud es mayor de 3 caracteres</c:if>
	<h1>${pepe.toUpperCase()}</h1>
	<c:set var="fecha" value="<%=new java.util.Date()%>"></c:set>
	<fmt:formatDate value="${fecha}" pattern="dd/MM/yy" />
	<br />
	<fmt:formatDate value="<%=new java.util.Date()%>" pattern="dd/MM/yy" />
	<c:set var="cadena" value="${pepe}" />
	<br />
	<h1>
		<c:out value="${cadena}"></c:out>
	</h1>
	<h1>${cadena}</h1>

	<h1>Listado&nbsp;<a href="./direccion/crear"><img src="./img/plus.png" width="30px" height="30px"></a></h1>
	<form id="buscadorForm" action="./direcciones" method="post">
	  Codigo Postal: <select name="codigoPostal">
	       <option value="">Elija una opción</option>
	     <c:forEach items="${codPostales}" var="codPostal">
	      <option value="${codPostal}">${codPostal}</option>
	     </c:forEach>
	   </select>
	</form>
	
	<ul>
		<c:forEach items="${listado}" var="direccion">
		<li> 
		
		<a href="./direccion?id=${direccion.id}">${direccion.calle} ${direccion.ciudad} ${direccion.codPostal} ${direccion.estado}</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>