<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Pais</title>
<script type="text/javascript">
function crear() {

	if(confirm("¿Desea crear este elemento?")){
		
		document.getElementById("crearForm").submit();
		
	}
}

</script>

</head>
<body>
	<br>
	El usuario es:${usuario}

	<form method="post" id="crearForm" action="../pais/crear">
		
		<input type="hidden" name="idRegion" value="2">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" ></td>

			</tr>
			
			<tr>
				<td>Id Region</td>
				<td>"2"</td>
			</tr>
			
			<tr>
				<td colspan=2><a href="javascript:crear();">Crear</a></td>
				<td><a href="../paises">Volver</a></td>
			</tr>

		</table>

	</form>
	<c:if test="${mensaje!=null}">${mensaje}</c:if>


</body>
</html>