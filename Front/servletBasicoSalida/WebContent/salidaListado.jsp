<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Casas</title>
</head>
<body>
Listado:${casas}

<table>
<c:forEach  items="${casas}" var="casa">
  <tr><td>${casa.id}</td><td>${casa.nombre}</td></tr>
</c:forEach>
</table>
</body>
</html>