<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <link rel="stylesheet" href="css/usuarios.css">
</head>
<body>

	<%!	String cu,eu,nu,p,u; %>
	
	<%
		ConnectionDB cnnx=new ConnectionDB();
		cnnx.conexiondb();
		
		cu=request.getParameter("cu");
		eu=request.getParameter("eu");
		nu=request.getParameter("nu");
		p=request.getParameter("p");
		u=request.getParameter("u");
		
	%>
	
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Usuarios</h1>
        </div>
	    <nav class="nav">
	        <ul>
	            <li><a href="usuarios.jsp">Usuarios</a></li>
	            <li><a href="clientes.jsp">Clientes</a></li>
	            <li><a href="proveedores.jsp">Proveedores</a></li>
	            <li><a href="#">Productos</a></li>
	            <li><a href="#">Ventas</a></li>
	            <li><a href="#">Reportes</a></li>
	        </ul>
	    </nav>
    </header>
    
    <main>
    	<fieldset class="cont-formcrear">
		<form action="ServletCRUDUsuario" method="post">
			<label>Cedula Usuario</label>
			<input type="text" name="cu">
			<label>Email Usuario</label>
			<input type="text" name="eu">
			<label>Nombre Usuario</label>
			<input type="text" name="nu">
			<label>Password Usuario</label>
			<input type="text" name="p">
			<label>Usuario</label>
			<input type="text" name="u">
			<input type="submit" name="btninsert" value="Crear">	
		</form>
		</fieldset>
		
		<fieldset class="cont-formeliminar">
		<form action="ServletCRUDUsuario" method="post">
			<label>Cedula Usuario</label>
			<input type="text" name="cu">
			<input type="submit" name="btndelete" value="Eliminar">	
		</form>
		</fieldset>
		<fieldset class="cont-formeliminar">
		<form action="ServletCRUDUsuario" method="post">
			<label>Cedula Usuario</label>
			<input type="text" name="cu">
			<label>Email Usuario</label>
			<input type="text" name="eu">
			<label>Nombre Usuario</label>
			<input type="text" name="nu">
			<label>Password Usuario</label>
			<input type="text" name="p">
			<label>Usuario</label>
			<input type="text" name="u">
			<input type="submit" name="btnupdate" value="Actualizar">	
		</form>
		</fieldset>
		<fieldset class="cont-formactualizar">
		<form action="ServletCRUDUsuario" method="post">
			<label>Cedula Usuario</label>
			<input type="text" name="cu">
			<input type="submit" name="btnsearch" value="Buscar">	
		</form>
		</fieldset>
		
	</main>
	
</body>
</html>