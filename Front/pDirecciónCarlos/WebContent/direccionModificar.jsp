<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Direccion</title>
<script type="text/javascript">
function modificar() {

	if(confirm("¿Desea modificar este elemento?")){
		
		document.getElementById("modificarForm").submit();
		
	}
}
function volver(){
	document.getElementById("modificarForm").action="../direccion";
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
				<td><input type="text" name="calle" value="${element.calle}"></td>

			</tr>
			<tr>
				<td>Codigo Postal</td>
				<td><input type="text" name="codPostal"
					value="${element.codPostal}"></td>
			</tr>
			<tr>
				<td>Ciudad</td>
				<td><input type="text" name="ciudad" value="${element.ciudad}"></td>
			</tr>
			<tr>
				<td>Provincia</td>
				<td><input type="text" name="estado" value="${element.estado}"></td>
			<tr>
				<td>Id Pais</td>
				<td>${element.pais.paisId}</td>
			</tr>
			<tr>
				<td>Nombre Pais</td>
				<td>${element.pais.nombre}</td>
			</tr>

			<!-- <tr>
				<td colspan=2><input type="submit" value="Enviar"></td>
			</tr>-->
			<tr>
				<td colspan=2><a href="javascript:modificar();">Enviar</a></td>
				<td><a href="javascript:volver();">Volver</a></td>
			</tr>

		</table>

	</form>
	
	<c:if test="${mensaje!=null}">${mensaje}</c:if>


</body>
</html>