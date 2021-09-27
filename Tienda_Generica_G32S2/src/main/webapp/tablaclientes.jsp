<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/menu.css"> 
<link rel="stylesheet" href="css/tablasTodas.css">
<title>Tienda Generica</title>
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
            <h1 class="h1" id="h1">Tabla de Proveedores</h1>
            <div class="logo" id="logo"></div>
            
         </div>  
    <nav class="nav">
        <ul>
            <li><a href="clientes.jsp">Clientes</a></li>
        </ul>
    </nav>
</header>
    <table class="tabla">
        <thead>
       		 <tr>
				<th>Cedula Cliente</th>
				<th>Direccion Cliente</th>
				<th>Email Cliente</th>
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
        </thead>    
	</table>    
</body>
</html>