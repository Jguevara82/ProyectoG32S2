<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/productos.js"></script>
    <title>Productos</title>
    <%--<link rel="stylesheet" href="css/menu.css">  --%>
    <link rel="stylesheet" href="css/formulariosP.css">
</head>
<body>
	
	<%!	String cp,iv,ni,np,pc,pv; %>
	
	<%
		
		cp=request.getParameter("cp");
		iv=request.getParameter("iv");
		ni=request.getParameter("ni");
		np=request.getParameter("np");
		pc=request.getParameter("pc");
		pv=request.getParameter("pv");
		
		if(cp==null){
			  cp=" ";
			  iv=" ";
			  ni=" ";
			  np=" ";
			  pc=" ";
			  pv=" ";
			}
		
	%>
	
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
	            <li><a href="ventas.jsp">Ventas</a></li>
	            <li><a href="reportes.jsp">Reportes</a></li>
				<li><a href="login.html">Cerrar Sesión</a></li>
	        </ul>
	    </nav>
    </header>
    <main>
    	<section>
	    	<div class="tabs">
	            <div class="tab">
	                <input type="radio" id="tab-1" name="tab-group-1" checked/>
	                <label id="cargar" for="tab-1">Cargar</label>
		            <div class="content cargar">
			    	<fieldset class="containers">
						<form class="upload" action="ServletProductos" method="post" enctype="multipart/form-data" id="uploadCsv">
							<label>Cargar archivo CSV</label>
							<input type="file" name="archivo" value="Examinar" id="archivoCsv">
							<input type="submit" name="cargar" value="cargar" id="cargar" class="btn-formularios">
						</form>
						<div id="mensaje"></div>
					</fieldset>
		            </div>
		        </div>
	            <div class="tab">
	                <input type="radio" id="tab-2" name="tab-group-1"/>
	                <label id="actualizar" for="tab-2">Actualizar</label>
		            <div class="content actualizar">
					<fieldset class="containers">
						<form action="" method="post">
							<label>Codigo Del Producto</label>
							<input type="text" name="cp" id="cpa">
							<label>Iva</label>
							<input type="text" name="iv" id="iva">
							<label>Nit Del Proveedor</label>
							<input type="text" name="ni" id="nia">
							<label>Nombre Del Producto</label>
							<input type="text" name="np" id="npa">
							<label>Precio De Compra</label>
							<input type="text" name="pc" id="pca">
							<label>Precio De Venta</label>
							<input type="text" name="pv" id="pva">
							<input type="button" name="btnupdate" value="Actualizar" class="btn-formularios" id="btnupdate">	
						</form>
					</fieldset>
		            </div>
		        </div>
	            <div class="tab">
	                <input type="radio" id="tab-3" name="tab-group-1"/>
	                <label for="tab-3" id="consultar">Consultar</label>
		            <div class="content consultar">
					<fieldset class="containers">
						<form action="" method="post">
							<label>Codigo Del Producto</label>
							<input type="text" name="cp" value="<%=cp%>" id="cp">
							<input type="button" name="btnsearch" value="Buscar" class="btn-formularios" id="psearch">	
						</form>
					<form action="" id="datos"></form>
					</fieldset>
		            </div>
		        </div>
	        </div>
        </section>
	</main>
</body>
</html>