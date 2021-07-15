<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="com.proyecto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Date date = new Date(); %>
Hola soy el index.jsp <%=date%>
<% List departamentos = request.getAttribute("listado");
if(departamentos == null || departamentos.isEmpty()){
%>
<table>
<tr><td>
   No existen datos de departamentos
</td>
</tr>
</table>
<%}%>
<ul>
<% for(int  i=0;i<departamentos.size();i++){
	Departamento departamento = (Departamento) departamentos.get(i); %>
<li><a href=""><%=departamento.getNombre()%>
<%}%>
</ul>
</body>
</html>