<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/cliente.js"></script>
<title>Clientes</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/formulariosTodos.css">
</head>
<body>
	<%!String cc, dc, ec, nc, tc;%>

	<%
	cc = request.getParameter("cc");
	dc = request.getParameter("dc");
	ec = request.getParameter("ec");
	nc = request.getParameter("nc");
	tc = request.getParameter("tc");

	if (cc == null) {
		cc = " ";
		dc = " ";
		ec = " ";
		nc = " ";
		tc = " ";
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
				<li><a href="ventas.jsp">Ventas</a></li>
				<li><a href="reportes.jsp">Reportes</a></li>
			</ul>
		</nav>
	</header>

	<main>
		<fieldset class="cont-formcrear">
			<form action="" method="post" id="formCrearCli">
				<label>Cedula cliente</label> 
				<input type="text" name="cc" require="true" id="ccCrear">
				<label>Direccion cliente</label>
				<input type="text" name="dc" require="true" id="dcCrear">
				<label>Email cliente</label> 
				<input type="email" name="ec" require="true" id="ecCrear"> 
				<label>Nombre cliente</label> 
				<input type="text" name="nc" require="true" id="ncCrear"> 
				<label>Telefono	cliente</label> 
				<input type="tel" name="tc" require="true" id="tcCrear"> 
				<input type="submit" name="btninsert" value="Crear" id="btninsert" class="btn-formularios">
			</form>
		</fieldset>
		
		<fieldset class="cont-formeliminar">
			<form action="ServletCRUDClientes" method="post">
				<label>Cedula cliente</label>
				<input type="text" name="cc" required="true">
				<input type="submit" name="btndelete" value="Eliminar" class="btn-formularios">
			</form>
		</fieldset>
		
		<fieldset class="cont-formactualizar">
			<form action="ServletCRUDClientes" method="post">
				<label>Cedula cliente</label> 
				<input type="text" name="cc" required="true">
				<label>Direccion cliente</label> 
				<input type="text" name="dc" required="true">
				<label>Email cliente</label> 
				<input type="email" name="ec" required="true"> 
				<label>Nombre cliente</label> 
				<input type="text" name="nc" required="true"> 
				<label>Telefono cliente</label> 
				<input type="tel" name="tc" required="true"> 
				<input type="submit" name="btnupdate" value="Actualizar" class="btn-formularios">
			</form>
		</fieldset>
		
		<fieldset class="cont-formbuscar">
			<form action="" method="post" name="formBuscarCli" id="formBuscarCli">
				<label>Cedula cliente</label> 
				<input type="text" name="cc" id="ccBuscar" required="true"> 
				<input type="submit" name="btnsearch" value="Buscar" class="btn-formularios" id="btnsearchcli"> 
				<label>Direccion cliente</label> 
				<input type="text" name="dc" id="dcBuscar" readonly="true"> 
				<label>Email cliente</label> 
				<input type="email" name="ec" id="ecBuscar" readonly="true"> 
				<label>Nombre cliente</label> 
				<input type="text" name="nc" id="ncBuscar" readonly="true"> 
				<label>Telefono cliente</label> 
				<input type="tel" name="tc" id="tcBuscar" readonly="true">
			</form>
		</fieldset>

	</main>

</body>
</html>