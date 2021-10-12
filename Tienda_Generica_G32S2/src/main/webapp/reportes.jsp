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
    <link rel="stylesheet" href="css/menu.css"> 
    <link rel="stylesheet" href="css/formulariosTodos.css">
    <link rel="stylesheet" href="css/tablasTodas.css">
</head>
<body>
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
	
		<form action="">
			<input type="button" name="btnlist" value="Listado de Usuarios" class="btn-formularios" id="list">
		</form>
		<table id="tabla">
			<thead>
				<tr id="encabezados">
					<th>Cedula Usuario</th>
					<th>Email Usuario</th>
					<th>Nombre Usuario</th>
					<th>Password</th>
					<th>Usuario</th>
				</tr>
			</thead>
			<tbody id="datos">
			</tbody>
		</table>
		<form action="">
			<input type="button" name="btnlist" value="Listado de Clientes" class="btn-formularios" id="listc">
		</form>
		<table id="tablac">
			<thead>
				<tr id="encabezados">
					<th>Cedula Cliente</th>
					<th>Direccon CLiente</th>
					<th>Email Cliente</th>
					<th>Nombre Cliente</th>
					<th>Telefono CLiente</th>
				</tr>
			</thead>
			<tbody id="datosc">
			</tbody>
		</table>
		<form action="">
			<input type="button" name="btnlist" value="Ventas por Cliente" class="btn-formularios" id="listv">
		</form>
		<table id="tablav">
			<caption>Total de ventas por cliente</caption>
			<thead>
				<tr id="encabezados">
					<th>Cedula</th>
					<th>Nombre</th>
					<th>Valor total ventas</th>
				</tr>
			</thead>
			<tbody id="datosv">
			</tbody>
		</table>
	</main>
</body>
</html>