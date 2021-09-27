<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proveedores</title>
    <link rel="stylesheet" href="css/menu.css"> 
    <link rel="stylesheet" href="css/formulariosTodos.css">
</head>
<body>
	
	
	<%!	String nitp, cp, dp, np, tp; %>
	
	<%
		
		nitp=request.getParameter("nitp");
		cp=request.getParameter("cp");
		dp=request.getParameter("dp");
		np=request.getParameter("np");
		tp=request.getParameter("tp");
		
		if(nitp==null){
			  nitp=" ";
			  cp=" ";
			  dp=" ";
			  np=" ";
			  tp=" ";
			}
		
	%>
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Proveedores</h1>
        </div>
	    <nav class="nav">
	        <ul>
	            <li><a href="usuarios.jsp">Usuarios</a></li>
	            <li><a href="clientes.jsp">Clientes</a></li>
	            <li><a href="proveedores.jsp">Proveedores</a></li>
	            <li><a href="productos.jsp">Productos</a></li>
	            <li><a href="#">Ventas</a></li>
	            <li><a href="#">Reportes</a></li>
	        </ul>
	    </nav>
    </header>
    
    <main>
    	<fieldset class="cont-formcrear">
		<form action="ServletCRUDProveedores" method="post">
			<label>Nit proveedor</label>
			<input type="text" name="nitp">
			<label>Ciudad proveedor</label>
			<input type="text" name="cp">
			<label>Direccion proveedor</label>
			<input type="text" name="dp">
			<label>Nombre proveedor</label>
			<input type="text" name="np">
			<label>Telefono proveedor</label>
			<input type="text" name="tp">
			<input type="submit" name="btninsert" value="Crear" class="btn-formularios">	
		</form>
		</fieldset>	
		<fieldset class="cont-formeliminar">
		<form action="ServletCRUDProveedores" method="post">
			<label>Nit proveedor</label>
			<input type="text" name="nitp">
			<input type="submit" name="btndelete" value="Eliminar" class="btn-formularios">	
		</form>
		</fieldset>	
		<fieldset class="cont-formactualizar">
		<form action="ServletCRUDProveedores" method="post">
			<label>Nit proveedor</label>
			<input type="text" name="nitp">
			<label>Ciudad proveedor</label>
			<input type="text" name="cp">
			<label>Direccion proveedor</label>
			<input type="text" name="dp">
			<label>Nombre proveedor</label>
			<input type="text" name="np">
			<label>Telefono proveedor</label>
			<input type="text" name="tp">
			<input type="submit" name="btnupdate" value="Actualizar" class="btn-formularios">	
		</form>
		</fieldset>
		<fieldset class="cont-formbuscar">
		<form action="ServletCRUDProveedores" method="post">
			<label>Nit proveedor</label>
			<input type="text" name="nitp" value="<%=nitp%>">
			<input type="submit" name="btnsearch" value="Buscar" class="btn-formularios">	
		</form>
		<form action="">
			<label>Ciudad proveedor</label>
			<input type="text" name="cp" value="<%=cp%>">
			<label>Direccion proveedor</label>
			<input type="text" name="dp" value="<%=dp%>">
			<label>Nombre proveedor</label>
			<input type="text" name="np" value="<%=np%>">
			<label>Telefono proveedor</label>
			<input type="text" name="tp" value="<%=tp%>">
		</form>
		</fieldset>
		
	</main>
	
</body>
</html>