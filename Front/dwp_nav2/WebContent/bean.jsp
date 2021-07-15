<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bean</title>
<script type="text/javascript">
	function eliminar() {

		if (confirm("¿Desea eliminar este elemento?")) {
			
			document.getElementById("eliminarForm").submit();

		}
	}


</script>
</head>
<body>
	<h1>Bean</h1>
	${element}
	<br>
<form method="post" id="eliminarForm" action="./bean/eliminar">
		<input type="hidden" name="id" value="${element.id}">
</form>
		
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
			<td>Tipo</td>
			<td>${element.tipo}</td>
		</tr>		
		
		
		<tr>
				<td><a href="./bean/modificar?id=${element.id}">Modificar</a></td>
				<td><a href="javascript:eliminar();">Eliminar</a></td>
				
				<td><a href="./">Volver</a></td>
			</tr>
	</table>

		
</body>
</html>