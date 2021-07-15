<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar</title>

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
<script type="text/javascript">
	function eliminar() {
		if (confirm("¿Desea eliminar este elemento?"))
			document.getElementById("eliminarForm").submit();
	}

</script>
</head>
<body>
	<form method="post" id="eliminarForm" action="./eliminar">
		<input type="hidden" name="id" value="${element.id}"> 
		<table>
			<tr>
				<td>Id</td>
				<td>${element.id}</td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td>${element.nombre}</td>
			</tr>
			<tr>
				<!-- <td colspan=2><input type="submit" value="Enviar"></td> -->
				<td><a href="javascript:eliminar();">Eliminar</a></td>
				<td><a href="../regiones">Volver</a></td>
			</tr>
		</table>
	</form>
	<c:if test="${mensaje != null}">${mensaje}</c:if>
</body>
</html>