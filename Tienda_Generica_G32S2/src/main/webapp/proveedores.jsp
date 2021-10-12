<%@page import="controller.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/jproveedores.js"></script>
    <title>Proveedores</title>
    <link rel="stylesheet" href="css/formulariosUCP.css">
</head>
<body>
	
	
	<%!	String nitp, cp, dp, np, tp; %>
	
	<%
		
		nitp=request.getParameter("nitp");
		cp=request.getParameter("cp");
		dp=request.getParameter("dp");
		np=request.getParameter("np");
		tp=request.getParameter("tp");
		
		if(nitp==null){
			  nitp=" ";
			  cp=" ";
			  dp=" ";
			  np=" ";
			  tp=" ";
			}
		
	%>
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Proveedores</h1>
        </div>
	    <nav class="nav">
	        <ul>
	            <li><a href="usuarios.jsp">Usuarios</a></li>
	            <li><a href="clientes.jsp">Clientes</a></li>
	            <li><a href="proveedores.jsp">Proveedores</a></li>
	            <li><a href="productos.jsp">Productos</a></li>
	            <li><a href="ventas.jsp">Ventas</a></li>
	            <li><a href="reportes.jsp">Reportes</a></li>
				<li><a href="login.html">Cerrar Sesion</a></li>
	        </ul>
	    </nav>
    </header>

    <main>
    	<section>
			
            <div class="tabs">
            <div class="tab">
                <input type="radio" id="tab-1" name="tab-group-1" checked/>
                <label id="crear" for="tab-1">CREAR</label>
            <div class="content crear">
	    	<fieldset class="containers">
			    <form action="" method="post">
					<label>Nit proveedor</label>
					<input type="text" name="nitp" id="nitp">
					<label>Ciudad proveedor</label>
					<input type="text" name="cp" id="cp">
					<label>Direccion proveedor</label>
					<input type="text" name="dp" id="dp">
					<label>Nombre proveedor</label>
					<input type="text" name="np" id="np">
					<label>Telefono proveedor</label>
					<input type="text" name="tp" id="tp">
					<input type="button" name="btninsert" value="Crear" class="btn-formularios" id="btinsert">	
				</form>
			</fieldset>
            </div>
        </div>
            <div class="tab">
                <input type="radio" id="tab-2" name="tab-group-1"/>
                <label id="eliminar" for="tab-2">ELIMINAR</label>
            <div class="content eliminar">
			<fieldset class="containers">
				<form action="" method="post">
					<label>Nit proveedor</label>
					<input type="text" name="nitp" id="nitpe">
					<input type="button" name="btndelete" value="Eliminar" class="btn-formularios" id="btdelete">	
				</form>
			</fieldset>
            </div>
        </div>
            <div class="tab">
                <input type="radio" id="tab-3" name="tab-group-1"/>
                <label for="tab-3" id="actualizar">ACTUALIZAR</label>
            <div class="content actualizar">
			<fieldset class="containers">
			   <form action="" method="post">
					<label>Nit proveedor</label>
					<input type="text" name="nitpu" id="nitpu">
					<label>Ciudad proveedor</label>
					<input type="text" name="cpu" id="cpu">
					<label>Direccion proveedor</label>
					<input type="text" name="dpu" id="dpu">
					<label>Nombre proveedor</label>
					<input type="text" name="npu" id="npu">
					<label>Telefono proveedor</label>
					<input type="text" name="tpu" id="tpu">
					<input type="button" name="btnupdate" value="Actualizar" class="btn-formularios" id="btupdate">	
				</form>
			</fieldset>
            </div>
         </div>
            <div class="tab">
                <input type="radio" id="tab-4" name="tab-group-1">
                <label for="tab-4" id="buscar">BUSCAR</label>
            <div class="content buscar">
			<fieldset class="containers">
			   <form action="" method="post">
					<label>Nit proveedor</label>
					<input type="text" name="nitp" value="${result.nombre_proveedor}" id="nitps" >
					<input type="button" name="btnsearch" value="Buscar" class="btn-formularios" id="btsearch">	
				</form>
			    <form id="datos">
			    </form>
			</fieldset>
            </div>
        </div>
        </div>
		</section>
	</main>
	
</body>
</html>