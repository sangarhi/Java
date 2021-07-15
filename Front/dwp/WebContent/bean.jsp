<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>   
<html>
<script>
function visualizar(){
	document.getElementById("panelView").style.display="block";
	document.getElementById("panelModificarForm").style.display="none";
}
function eliminar(){
	if(confirm("�Desea eliminar este elemento?")){
	document.getElementById("formBean").accion.value = "D";
	document.getElementById("formBean").submit();
	}
}
function modificar(){
	if(confirm("�Desea modificar este elemento?")){
		
	document.getElementById("formBean").accion.value = "M";
	document.getElementById("formBean").submit();
	document.getElementById("panelView").style.display="block";
	document.getElementById("panelModificarForm").style.display="none";
	}
}
function aModificar(){
	document.getElementById("panelView").style.display="none";
	document.getElementById("panelModificarForm").style.display="block";
}

</script>
<head>
<meta charset="ISO-8859-1">
<title>Bean</title>
</head>
<body>
<c:choose>
<c:when test="${elemento!=null}">
<div id="panelView" >
Id: ${elemento.id}<br>
Nombre: ${elemento.nombre}<br>
Tipo:${elemento.tipo}<br>
<fmt:parseDate value="${elemento.fechaCreacion}" pattern="yyyy-MM-dd" var="parsedFecCreacion" type="date"/>
 <fmt:formatDate value="${parsedFecCreacion}" pattern="dd/MM/yyyy" var="fechaCreacion" /> 
Fecha Creacion:${fechaCreacion}<br>
<fmt:parseDate value="${elemento.fechaModificacion}" pattern="yyyy-MM-dd" var="parsedFecModificacion" type="date"/>
 <fmt:formatDate value="${parsedFecModificacion}" pattern="dd/MM/yyyy" var="fechaModificacion" /> 
Fecha Modificacion:${fechaModificacion}<br>
<a href="javascript:aModificar()">Modificar</a>
<a href="javascript:eliminar()">Eliminar</a>
<a href="./">Volver</a><br>
</div>
<div id="panelModificarForm" style="display:none">
<form method="post" action="./bean" id="formBean">
 <input hidden="true" type="text" name="accion" value="" />
 <input hidden="true" type="text" name="id" value="${elemento.id}" />
 Id:${elemento.id} <br>
 Nombre: <input type="text" name="nombre" value="${elemento.nombre}"/><br>
 Tipo: <select name="tipo">
			
			<c:forEach items="${tipos}" var="tipo">
				<option value="${tipo.tipo}" ${elemento.tipo == tipo.tipo ? 'selected' : ''}>${tipo}</option>
			</c:forEach>
		</select><br> 
 <input type="button" onClick="javascript:modificar()" value="Enviar"/> 
 <input type="button" onClick="javascript:visualizar()" value="Volver"/> 
</form>
</div>
</c:when>
<c:otherwise>
<div id="panelCrearForm">
<form method="post" action="./bean" id="formCrearBean">
 <input hidden="true" type="text"  name="accion" value="C" /> 
 Nombre <input type="text"  name="nombre" value="" /> <br>
 Tipo: <select name="tipo">
			<option value=""></option>
			<c:forEach items="${tipos}" var="tipo">
				<option value="${tipo.tipo}">${tipo}</option>
			</c:forEach>
		</select><br> 
 
 <input type="submit" value="Enviar"/> 
</form>
</div>
</c:otherwise>
</c:choose>


<c:if test="${error!=null}">
<div style="color:red">
   ${error}
</div>
</c:if>

<br/>
</body>
</html>