<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Generica</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/formulariosTodos.css">
</head>
<body>
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Ventas</h1>
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
		<fieldset class="cont-formbuscar">
			<form action="">
				<label>Cedula del cliente</label>	
				<input type="text" name="ced">
				<input type="submit" name="btnsearch" value="Consultar" class="btn-formularios">
				<label>Cliente consultado</label>
				<input type="text">
			</form>
		</fieldset>
		<fieldset class="cont-formbuscar">
			<form action="#">
				<label class="labelventas">Digite el codigo del producto</label>
				<input type="text" name="prod">
				<input type="submit" name="btnsearchprod" value="Consultar" class="btn-formularios">
				<label class="labelventas">Nombre del producto</label>
				<input type="text" name="nprod">
				<label class="labelventas">Digite la cantidad del producto</label>
				<input type="text" name="cprod">
				<input type="submit" name="btnconfirm" value="Confirmar" class="btn-formularios">
	
				<label class="labelventas">Valor total</label>
				<input type="text" name="totventa">
				<label class="labelventas">Total IVA</label>
				<input type="text" name="totiva">
				<label class="labelventas">Total con IVA</label>
				<input type="text" name="total">
				<label>-----------------------------</label>
				<label >Consecutivo</label>
				<input type="text" name="consecutivo">
			</form>
		</fieldset>
	</main>
</body>
</html>