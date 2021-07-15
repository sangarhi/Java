<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar</title>

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
	function modificar() {
		if (confirm("¿Desea modificar este elemento?"))
			document.getElementById("modificarForm").submit();
	}

	function volver() {
		document.getElementById("modificarForm").action = "../direccion";
		document.getElementById("modificarForm").submit();
	}
</script>
</head>
<body>
	<form method="post" id="modificarForm" action="./modificar">
		<input type="hidden" name="id" value="${element.id}"> <input
			type="hidden" name="idPais" value="${element.pais.paisId}">
		<table>
			<tr>
				<td>Id</td>
				<td>${element.id}</td>
			</tr>
			<tr>
				<td>Calle</td>
				<td><input name="calle" type="text" value="${element.calle}"></td>
			</tr>
			<tr>
				<td>Código Postal</td>
				<td><input name="codPostal" type="text"
					value="${element.codPostal}"></td>
			</tr>
			<tr>
				<td>Ciudad</td>
				<td><input name="ciudad" type="text" value="${element.ciudad}"></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><input name="estado" type="text" value="${element.estado}"></td>
			</tr>
			<tr>
				<td>Id País</td>
				<td>${element.pais.paisId}</td>
			</tr>
			<tr>
				<td>Nombre País</td>
				<td>${element.pais.nombre}</td>
			</tr>
			<tr>
				<!-- <td colspan=2><input type="submit" value="Enviar"></td> -->
				<td><a href="javascript:modificar();">Enviar</a></td>
				<td><a href="javascript:volver();">Volver</a></td>
			</tr>
		</table>
	</form>
	<c:if test="${mensaje != null}">${mensaje}</c:if>
</body>
</html>