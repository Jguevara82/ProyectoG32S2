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
    <title>Reportes</title>
	<link rel="stylesheet" href="css/formulariosR.css">
<link rel="stylesheet" href="css/dTable.css">
    <%--<link rel="stylesheet" href="css/menu.css"> 
    <link rel="stylesheet" href="css/formulariosTodos.css">
    <link rel="stylesheet" href="css/tablasTodas.css"> --%>
</head>
<body><% 
	HttpSession lcs=request.getSession();
	
		
	%>
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Reportes</h1>
        </div>
	    <nav class="nav">
	        <ul>
	            <li><a href="usuarios.jsp">Usuarios</a></li>
	            <li><a href="clientes.jsp">Clientes</a></li>
	            <li><a href="proveedores.jsp">Proveedores</a></li>
	            <li><a href="productos.jsp">Productos</a></li>
	            <li><a href="ventas.jsp">Ventas</a></li>
	            <li><a href="reportes.jsp">Reportes</a></li>
				<li><a href="login.html">Cerrar Sesión</a></li>
	        </ul>
	    </nav>
    </header>
	<main>
		
					<form action="">
						<input type="button" name="btnlist" value="Listado de Usuarios" class="btn-formularios" id="list">
					</form>
					<div class="dTable" id="datos">
						<div class="dHeading" id="encabezados">
							<div class="dCell">Cedula Usuario</div>
							<div class="dCell">Email Usuario</div>
							<div class="dCell">Nombre Usuario</div>
							<div class="dCell">Password</div>
							<div class="dCell">Usuario</div>
						</div>
					</div>	
					<form action="">
						<input type="button" name="btnlist" value="Listado de Clientes" class="btn-formularios" id="listc">
					</form>
					<div class="dTable" id="datosc">
						<div class="dHeading" id="encabezados">
							<div class="dCell">Cedula Cliente</div>
							<div class="dCell">Direccon CLiente</div>
							<div class="dCell">Email Cliente</div>
							<div class="dCell">Nombre Cliente</div>
							<div class="dCell">Telefono CLiente</div>
						</div>
					</div>
					<form action="">
						<input type="button" name="btnlist" value="Ventas por Cliente" class="btn-formularios" id="listv">
						<div class="dTable" id="datosv">
							<div class="dHeading" id="encabezados">
								<div class="dCell">Cedula</div>
								<div class="dCell">Nombre</div>
								<div class="dCell">Valor total ventas</div>
							</div>
						</div>
					</form>
		<%--<h1>${objCli.getNombre_usuario()}</h1> --%>
	</main>
</body>
</html>