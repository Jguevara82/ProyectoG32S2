<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/tablaproveedores.css">
<title>Tienda Generica</title>
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
            <h1 class="h1" id="h1">Tabla de Proveedores</h1>
            <div class="logo" id="logo"></div>
            
         </div>  
    <nav class="nav">
        <ul>
            <li><a href="proveedores.jsp">Proveedores</a></li>
        </ul>
    </nav>
</header>
    <table class="tabla">
        <thead>
       		 <tr class="tr">
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
        </thead>    
	</table>    
</body>
</html>