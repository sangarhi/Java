<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear</title>

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
	function crear() {
		if (confirm("¿Desea crear este elemento?"))
			document.getElementById("crearForm").submit();
	}

</script>
</head>
<body>
	<form method="post" id="crearForm" action="./crear">
		 
		<table>
			<tr>
				<td>Id</td>
				<td><input name="id" type="text"></td>
			</tr>
			<tr>
				<td>Calle</td>
				<td><input name="calle" type="text"></td>
			</tr>
			<tr>
				<td>Código Postal</td>
				<td><input name="codPostal" type="text"></td>
			</tr>
			<tr>
				<td>Ciudad</td>
				<td><input name="ciudad" type="text"></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><input name="estado" type="text"></td>
			</tr>
			<tr>
				<td>Id País</td>
				<td><select name="idPais" id="idPais">
						<c:forEach items="${paises}" var="pais">
							<option value="${pais.paisId}">${pais.nombre}</option>
						</c:forEach>

				</select></td>
			</tr>
			
			<tr>
				<!-- <td colspan=2><input type="submit" value="Enviar"></td> -->
				<td><a href="javascript:crear();">Enviar</a></td>
				<td><a href="../direcciones">Volver</a></td>
			</tr>
		</table>
	</form>
	<c:if test="${mensaje != null}">${mensaje}</c:if>
</body>
</html>