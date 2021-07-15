<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Direccion</title>
<script type="text/javascript">
function crear() {

	if(confirm("¿Desea crear este elemento?")){
		
		document.getElementById("crearForm").submit();
		
	}
}

</script>

</head>
<body>
	<form method="post" id="crearForm" action="./crear">
		
		<input type="hidden" name="idPais" value="US">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" ></td>
			</tr>
			<tr>
				<td>Calle</td>
				<td><input type="text" name="calle" ></td>

			</tr>
			<tr>
				<td>Codigo Postal</td>
				<td><input type="text" name="codPostal"></td>
			</tr>
			<tr>
				<td>Ciudad</td>
				<td><input type="text" name="ciudad" ></td>
			</tr>
			<tr>
				<td>Provincia</td>
				<td><input type="text" name="estado" ></td>
			<tr>
				<td>Id Pais</td>
				<td>"US"</td>
			</tr>
			

			<!-- <tr>
				<td colspan=2><input type="submit" value="Enviar"></td>
			</tr>-->
			<tr>
				<td colspan=2><a href="javascript:crear();">Crear</a></td>
				<td><a href="./direcciones;">Volver</a></td>
			</tr>

		</table>

	</form>
	<c:if test="${mensaje!=null}">${mensaje}</c:if>


</body>
</html>