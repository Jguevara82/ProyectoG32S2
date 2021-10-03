<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/jusuario.js"></script>
    <title>Usuarios</title>
    <link rel="stylesheet" href="css/menu.css"> 
    <link rel="stylesheet" href="css/formulariosTodos.css">
    <link rel="stylesheet" href="css/tablasTodas.css">
</head>
<body>

	<%!	String cu,eu,nu,p,u; %>
	
	<%
		HttpSession sesion=request.getSession();
	
		String usu=(String)sesion.getAttribute("usu"); 
		
		cu=request.getParameter("cu");
		eu=request.getParameter("eu");
		nu=request.getParameter("nu");
		p=request.getParameter("p");
		u=request.getParameter("u");
		
		if(cu==null){
			  cu=" ";
			  eu=" ";
			  nu=" ";
			  p=" ";
			  u=" ";
			}
		
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
	            <li><a href="productos.jsp">Productos</a></li>
	            <li><a href="ventas.jsp">Ventas</a></li>
	            <li><a href="reportes.jsp">Reportes</a></li>
	        </ul>
	    </nav>
    </header>
    
    <main>
    	
    	<section>
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
				<input type="button" name="" value="Crear" class="btn-formularios" id="btinsert">	
			</form>
			</fieldset>
			
			<fieldset class="cont-formeliminar">
			<form action="ServletCRUDUsuario" method="post">
				<label>Cedula Usuario</label>
				<input type="text" name="cu">
				<input type="submit" name="btndelete" value="Eliminar" class="btn-formularios">	
			</form>
			</fieldset>
			<fieldset class="cont-formactualizar">
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
				<input type="submit" name="btnupdate" value="Actualizar" class="btn-formularios">	
			</form>
			</fieldset>
			<fieldset class="cont-formactualizar">
			<%-- <form action="">
				<input value="<%=usu%>">
			</form> --%>
			<form action="ServletCRUDUsuario" method="post">
				<label>Cedula Usuario</label>
				<input type="text" name="cu" value="<%=cu%>" id="cu">
				<input type="button" name="btnsearch" value="Buscar" class="btn-formularios" id="usearch">	
			</form>
			<form id="datos">
			</form>
			</fieldset>
		</section>
		
	</main>
</body>
</html>