<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/tablausuarios.css">
<title>Tabla de usuarios</title>
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
            <h1 class="h1" id="h1">Tabla de Usuarios</h1>
            <div class="logo" id="logo"></div>
            
         </div>  
    <nav class="nav">
        <ul>
            <li><a href="usuarios.jsp">Usuarios</a></li>
        </ul>
    </nav>
</header>
    <table class="tabla">
        <thead>
        <tr class="tr">
            <th>Cedula</th>
            <th>Email</th>
            <th>Nombre del Usuario</th>
            <th>Contraseña</th>
            <th>Usuario</th>
        </tr>
        <tr>
				<td><%=cu%></td>
				<td><%=eu%></td>
				<td><%=nu%></td>
				<td><%=p%></td>
				<td><%=u%></td>
			</tr>
        </thead>    
	</table>    
</body>
</html>