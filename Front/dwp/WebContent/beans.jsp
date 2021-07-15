<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script>
function verElemento(id){
	document.getElementById("formBean").id.value = id;
	document.getElementById("formBean").accion.value = "V"; 
	
	document.getElementById("formBean").submit();
}
function irACrear(){
	document.getElementById("formBean").accion.value = "F_C";
	
	document.getElementById("formBean").submit();
}
function irABeansByTipo(){
	
	document.getElementById("divByTipo").style.display="block";
	document.getElementById("formByTipo").tipo.value = "1";
	document.getElementById("formByTipo").submit();
	
} 
</script>
<style>

	label{
		color: #0040ff;
	}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Beans</title>
</head>
<body>
Beans
<div >
<c:set var="context" value="${pageContext.request.contextPath}" />
<form method="post" action="./bean" id="formBean">
 <input hidden="true" type="text" name="accion" value="" />
 <input hidden="true" type="text" name="id" value="" />
</form>
</div>
<ul>
<c:forEach items="${listado}" var="elemento">
<li>${elemento.nombre} 
<a href="javascript:verElemento(${elemento.id})"><img src="https://img.icons8.com/color/search" width=25 height=25></a>
</li>
</c:forEach>
</ul>
<a href="javascript:irACrear()">Crear Nuevo</a><br>




<c:if test="${error!=null}">
<div style="color:red">
   ${error}
</div>
</c:if>
</body>
</html>