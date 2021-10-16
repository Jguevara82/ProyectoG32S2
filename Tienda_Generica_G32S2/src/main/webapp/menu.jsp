<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda Generica</title>
     <!-- <link rel="stylesheet" href="css/menu.css">  -->
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <div class="all">
    <div class="lefter" onclick="window.location ='usuarios.jsp';">
      <img src="icons/usuarios.png" alt="Usuarios">
      <div class="text">USUARIOS</div>
    </div>
    <div class="left" onclick="window.location ='clientes.jsp';">
      <img src="icons/clientes.png" alt="Clientes">
      <div class="text">CLIENTES</div>
    </div>
    <div class="center2" onclick="window.location ='reportes.jsp';">
      <div class="logo"><img src="icons/pluginlogo (1).png" alt="logo"></div>
      <div class="reports"><img src="icons/reporte.png" alt="Reportes"></div>
      <div class="text">REPORTES</div>
    </div>
    <div class="center" onclick="window.location ='productos.jsp';">
      <div class="products"><img src="icons/producto.png" alt="Productos"></div>
      <div class="explainer"><span>OPCIONES</span></div>
      <div class="text">PRODUCTOS</div>
    </div>
   	<div class="right" onclick="window.location ='proveedores.jsp';">
      <img src="icons/proveedor.png" alt="Proveedores">
      <div class="text">PROVEEDORES</div>
    </div>
    <div class="righter" onclick="window.location ='ventas.jsp';">
      <img src="icons/ventas.png" alt="Ventas">
      <div class="text">VENTAS</div>
    </div>
    </div>
</body>
</html>