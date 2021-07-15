<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar</title>
<script type="text/javascript">
	function modificar() {

		if (confirm("¿Desea modificar este elemento?")) {

			document.getElementById("modificarForm").submit();

		}
	}
	function volver() {
		document.getElementById("modificarForm").action = "../bean";
		document.getElementById("modificarForm").submit();
	}
</script>

</head>
<body>
	<br> El usuario es:${usuario}

	<form method="post" id="modificarForm" action="./modificar">
		<input type="hidden" name="id" value="${element.id}">
		<table>
			<tr>
				<td>Id</td>
				<td>${element.id}</td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" value="${element.nombre}"></td>
			</tr>
			<tr>
				<td>Tipo</td>
				<td><select name="tipo">

						<c:forEach items="${tipos}" var="tipo">
							<option value="${tipo.tipo}"
								${element.tipo == tipo.tipo ? 'selected' : ''}>${tipo}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan=2><a href="javascript:modificar();">Enviar</a></td>
				<td><a href="javascript:volver();">Volver</a></td>
			</tr>

		</table>

	</form>

	<c:if test="${mensaje!=null}">${mensaje}</c:if>


</body>
</html>