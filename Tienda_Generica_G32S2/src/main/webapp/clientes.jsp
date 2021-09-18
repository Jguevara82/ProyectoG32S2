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
</head>
<body>

	<%!	String cc,dc,ec,nc,tc; %>
	
	<%
		ConnectionDB cnnx=new ConnectionDB();
		cnnx.conexiondb();

		cc=request.getParameter("cc");
		dc=request.getParameter("dc");
		ec=request.getParameter("ec");
		nc=request.getParameter("nc");
		tc=request.getParameter("tc");
		
	%>
	
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Menu Principal</h1>
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
			<input type="submit" name="btninsert" value="Crear">	
		</form>
		<form action="ServletCRUDClientes" method="post">
			<label>Cedula cliente</label>
			<input type="text" name="cc">
			<input type="submit" name="btndelete" value="Eliminar">	
		</form>
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
			<input type="submit" name="btnupdate" value="Actualizar">	
		</form>
		<form action="ServletCRUDClientes" method="post">
			<label>Cedula cliente</label>
			<input type="text" name="cc">
			<input type="submit" name="btnsearch" value="Buscar">	
		</form>
		
		<h1>Resultado</h1>
		<table>
			<thead>Resultado</thead>
			<tr>
				<th>Cedula Cliente</th>
				<th>Direccion Cliente</th>
				<th>Email Cliuente</th>
				<th>Nombre Cliente</th>
				<th>Telefono Cliente</th>
			</tr>
			<tr>
				<td><%=cc%></td>
				<td><%=dc%></td>
				<td><%=ec%></td>
				<td><%=nc%></td>
				<td><%=tc%></td>
			</tr>
		</table>
		
	</main>
	
</body>
</html>