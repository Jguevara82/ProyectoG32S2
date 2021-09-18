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
</head>
<body>
	
	<%!	String nitp,cp,dp,np,tp; %>
	
	<%
		ConnectionDB cnnx=new ConnectionDB();
		cnnx.conexiondb();
		
		nitp=request.getParameter("nitp");
		cp=request.getParameter("cp");
		dp=request.getParameter("dp");
		np=request.getParameter("np");
		tp=request.getParameter("tp");
		
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
			<input type="submit" name="btninsert" value="Crear">	
		</form>
		<form action="ServletCRUDProveedores" method="post">
			<label>Nit proveedor</label>
			<input type="text" name="nitp">
			<input type="submit" name="btndelete" value="Eliminar">	
		</form>
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
			<input type="submit" name="btnupdate" value="Actualizar">	
		</form>
		<form action="ServletCRUDProveedores" method="post">
			<label>Nit proveedor</label>
			<input type="text" name="nitp">
			<input type="submit" name="btnsearch" value="Buscar">	
		</form>
		
		<h1>Resultado</h1>
		<table>
			<thead>Resultado</thead>
			<tr>
				<th>Nit Proveedor</th>
				<th>Ciudad Proveedor</th>
				<th>Direccion Proveedor</th>
				<th>Nombre Proveedor</th>
				<th>Telefono Proveedor</th>
			</tr>
			<tr>
				<td><%=nitp%></td>
				<td><%=cp%></td>
				<td><%=dp%></td>
				<td><%=np%></td>
				<td><%=tp%></td>
			</tr>
		</table>
		
	</main>
	
</body>
</html>