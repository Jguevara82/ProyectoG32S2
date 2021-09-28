<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
    <link rel="stylesheet" href="css/menu.css"> 
    <link rel="stylesheet" href="css/formulariosTodos.css">
</head>
<body>
	<%!	String cc, dc, ec, nc, tc; %>
	
	<%
		
		cc=request.getParameter("cc");
		dc=request.getParameter("dc");
		ec=request.getParameter("ec");
		nc=request.getParameter("nc");
		tc=request.getParameter("tc");
		
		if(cc==null){
			  cc=" ";
			  dc=" ";
			  ec=" ";
			  nc=" ";
			  tc=" ";
			}
		
	%>
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Clientes</h1>
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
		<form action="ServletCRUDClientes" method="post">
			<label>Cedula cliente</label>
			<input type="text" name="cc">
			<label>Direccion cliente</label>
			<input type="text" name="dc">
			<label>Email cliente</label>
			<input type="text" name="ec">
			<label>Nombre cliente</label>
			<input type="text" name="nc">
			<label>Telefono cliente</label>
			<input type="text" name="tc">
			<input type="submit" name="btninsert" value="Crear" class="btn-formularios">	
		</form>
		</fieldset>	
		<fieldset class="cont-formeliminar">
		<form action="ServletCRUDClientes" method="post">
			<label>Cedula cliente</label>
			<input type="text" name="cc">
			<input type="submit" name="btndelete" value="Eliminar" class="btn-formularios">	
		</form>
		</fieldset>	
		<fieldset class="cont-formactualizar">
		<form action="ServletCRUDClientes" method="post">
			<label>Cedula cliente</label>
			<input type="text" name="cc">
			<label>Direccion cliente</label>
			<input type="text" name="dc">
			<label>Email cliente</label>
			<input type="text" name="ec">
			<label>Nombre cliente</label>
			<input type="text" name="nc">
			<label>Telefono cliente</label>
			<input type="text" name="tc">
			<input type="submit" name="btnupdate" value="Actualizar" class="btn-formularios">	
		</form>
		</fieldset>	
		<fieldset class="cont-formbuscar">
		<form action="ServletCRUDClientes" method="post">
			<label>Cedula cliente</label>
			<input type="text" name="cc" value="<%=cc%>">
			<input type="submit" name="btnsearch" value="Buscar" class="btn-formularios">	
		</form>
			<form action="">
			<label>Direccion cliente</label>
			<input type="text" name="dc" value="<%=dc%>">
			<label>Email cliente</label>
			<input type="text" name="ec" value="<%=ec%>">
			<label>Nombre cliente</label>
			<input type="text" name="nc" value="<%=nc%>">
			<label>Telefono cliente</label>
			<input type="text" name="tc" value="<%=tc%>">
			</form>
		</fieldset>	
		
	</main>
	
</body>
</html>