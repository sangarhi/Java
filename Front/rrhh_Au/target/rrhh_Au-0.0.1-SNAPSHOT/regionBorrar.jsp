<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrar</title>
<script type="text/javascript">
	function borrar() {

		if (confirm("¿Desea borrar este elemento?")) {

			document.getElementById("borrarForm").submit();

		}
	}
	function volver() {
		document.getElementById("borrarForm").action = "../region";
		document.getElementById("borrarForm").submit();
	}
</script>

</head>
<body>
	<form method="post" id="borrarForm" action="./borrar">
		<input type="hidden" name="id" value="${element.id}">
		<table>
			<%-- 			<tr>
				<td>Id</td>
				<td><input type="text" name="nombre" value="${element.id}"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" value="${element.nombre}"></td>

			</tr> --%>

			<!-- <tr>
				<td colspan=2><input type="submit" value="Enviar"></td>
			</tr>-->
			<tr>
				<td colspan=2><a href="javascript:borrar();">Borrar</a></td>
			</tr>
			<tr>
				<td><a href="javascript:volver();">Volver</a></td>
			</tr>

		</table>

	</form>

	<c:if test="${mensaje!=null}">${mensaje}</c:if>


</body>
</html>