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
<script type="text/javascript" src="js/cliente.js"></script>
<title>Clientes</title>
<link rel="stylesheet" href="css/formulariosUCP.css">
</head>
<body>
	<%!String cc, dc, ec, nc, tc;%>

	<%
	cc = request.getParameter("cc");
	dc = request.getParameter("dc");
	ec = request.getParameter("ec");
	nc = request.getParameter("nc");
	tc = request.getParameter("tc");

	if (cc == null) {
		cc = " ";
		dc = " ";
		ec = " ";
		nc = " ";
		tc = " ";
	}
	%>
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Clientes</h1>
			
        </div>
	    <nav class="nav">
	        <ul>
	            <li><a href="usuarios.jsp">Usuarios</a></li>
	            <li><a href="clientes.jsp">Clientes</a></li>
	            <li><a href="proveedores.jsp">Proveedores</a></li>
	            <li><a href="productos.jsp">Productos</a></li>
	            <li><a href="ventas.jsp">Ventas</a></li>
	            <li><a href="reportes.jsp">Reportes</a></li>
				<li><a href="index.jsp">Cerrar Sesión</a></li>
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
			    <form action="" method="post" id="formCrearCli">
					<label>Cedula cliente</label> 
					<input type="text" name="cc" require="true" id="ccCrear">
					<label>Direccion cliente</label>
					<input type="text" name="dc" require="true" id="dcCrear">
					<label>Email cliente</label> 
					<input type="email" name="ec" require="true" id="ecCrear"> 
					<label>Nombre cliente</label> 
					<input type="text" name="nc" require="true" id="ncCrear"> 
					<label>Telefono	cliente</label> 
					<input type="tel" name="tc" require="true" id="tcCrear"> 
					<input type="submit" name="btninsert" value="CREAR" id="btninsert" class="btn-formularios">
				</form>
			</fieldset>
            </div>
        </div>
            <div class="tab">
                <input type="radio" id="tab-2" name="tab-group-1"/>
                <label id="eliminar" for="tab-2">ELIMINAR</label>
            <div class="content eliminar">
			<fieldset class="containers">
			    <form action="ServletCRUDClientes" method="post">
					<label>Cedula cliente</label>
					<input type="text" name="cc" required="true">
					<input type="submit" name="btndelete" value="ELIMINAR" class="btn-formularios">
				</form>
			</fieldset>
            </div>
        </div>
            <div class="tab">
                <input type="radio" id="tab-3" name="tab-group-1"/>
                <label for="tab-3" id="actualizar">ACTUALIZAR</label>
            <div class="content actualizar">
			<fieldset class="containers">
			    <form action="ServletCRUDClientes" method="post" id="formActCli">
					<label>Cedula cliente</label> 
					<input type="text" name="cc" required="true">
					<label>Direccion cliente</label> 
					<input type="text" name="dc" required="true">
					<label>Email cliente</label> 
					<input type="email" name="ec" required="true"> 
					<label>Nombre cliente</label> 
					<input type="text" name="nc" required="true"> 
					<label>Telefono cliente</label> 
					<input type="tel" name="tc" required="true"> 
					<input type="submit" name="btnupdate" value="ACTUALIZAR" class="btn-formularios">
				</form>
			</fieldset>
            </div>
         </div>
            <div class="tab">
                <input type="radio" id="tab-4" name="tab-group-1">
                <label for="tab-4" id="buscar">BUSCAR</label>
            <div class="content buscar">
			<fieldset class="containers">
			   <form action="" method="post" name="formBuscarCli" id="formBuscarCli">
					<label>Cedula cliente</label> 
					<input type="text" name="cc" id="ccBuscar" required="true"> 
					<input type="submit" name="btnsearch" value="BUSCAR" class="btn-formularios" id="btnsearchcli"> 
					<label>Direccion cliente</label> 
					<input type="text" name="dc" id="dcBuscar" readonly="true"> 
					<label>Email cliente</label> 
					<input type="email" name="ec" id="ecBuscar" readonly="true"> 
					<label>Nombre cliente</label> 
					<input type="text" name="nc" id="ncBuscar" readonly="true"> 
					<label>Telefono cliente</label> 
					<input type="tel" name="tc" id="tcBuscar" readonly="true">
				</form>
			</fieldset>
            </div>
        </div>
        </div>
		</section>
	</main>

</body>
</html>