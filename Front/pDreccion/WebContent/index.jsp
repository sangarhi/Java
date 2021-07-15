<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<style>
	body {
		font-family: 'Poppins', sans-serif;
		margin: 5% 10%;
	}
	button {
		border-radius: 5px; 
		padding:1rem; 
		cursor:pointer; 
		border: solid 3px #5E2563; 
		text-transform:uppercase;
		color: #5E2563;
		width: 10rem;
		font-size:15px;
	}
	
	button:hover {
		background: linear-gradient(135deg,#65799B,#5E2563);
		transform: translate(2px, -1px);
		color: white;
	}
	
</style>
</head>
<body>
<form>
  <button formaction="./direcciones">Direcciones</button>
  
</form>
</body>
</html>