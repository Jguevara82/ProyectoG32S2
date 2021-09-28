<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <link rel="stylesheet" href="css/menu.css"> 
    <link rel="stylesheet" href="css/formulariosTodos.css">
</head>
<body>

	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Productos</h1>
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
    	<fieldset class="cont-formcsv">
		<form action="ServletProductos" method="post" enctype="multipart/form-data">
			<input type="file" name="archivo" value="Examinar">
			<input type="submit" name="cargar" value="Cargar Archivo">
		</form>
		</fieldset>
		<fieldset class="cont-formproductos">
		<form action="ServletProductos" method="post" enctype="multipart/form-data">
			<label>Codigo Del Producto</label>
			<input type="text" name="cp">
			<label>Iva</label>
			<input type="text" name="iv">
			<label>Nit Del Proveedor</label>
			<input type="text" name="ni">
			<label>Nombre Del Producto</label>
			<input type="text" name="np">
			<label>Precio De Compra</label>
			<input type="text" name="pc">
			<label>Precio De Venta</label>
			<input type="text" name="pv">
			<input type="submit" name="btnupdate" value="Actualizar" class="btn-formularios">	
		</form>
		</fieldset>
	</main>
</body>
</html>