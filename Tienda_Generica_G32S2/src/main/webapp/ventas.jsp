<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
     <script type="text/javascript" src="js/clienteVentas.js"></script>
    <script type="text/javascript" src="js/ventas.js"></script>
	<title>Tienda Generica</title>
	<link rel="stylesheet" href="css/menu.css">
	<link rel="stylesheet" href="css/tablasTodas.css">
	<%--<link rel="stylesheet" href="css/ventas.css"> --%>
	<link rel="stylesheet" href="css/dTable.css">
</head>
<body>
<%!	String cp,iv,ni,np,pc,pv , cc, dc, ec, nc, tc; %>
	
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
            <h1 class="h1" id="h1">Ventas</h1>
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
		<section class="container">
			
            
            	<form action="" method="post" name="formBuscarCli" id="formBuscarCli">
            		<fieldset>
			            <div class="dTable" id="cliente">
			            	<div class="dRow">
			            		<div class="dCell">
			            			<label>Cedula cliente</label>
			            		</div>
								<div class="dCell">
									<input class="" name="ccBuscar" id="ccBuscar" type="text">
								</div>
							    <div class="dCell">
							    	<input type="submit" name="btnsearch" value="Buscar" class="btn-formularios" id="btnsearchcli"></div>
							</div>
							<div class="dRow">
							    <div class="dCell"><label>Nombre del cliente</label></div>
							    <div class="dCell"><input type="text" name="nc" id="ncBuscar" readonly="true"></div>
						    </div>
						</div>
					</fieldset>
				</form>
			<form action="" id="formulario" method="post" class="formulario-ventas">
				<fieldset>
					<div class="dTable" id="cProducto">
		            	<div class="dRow">
		            		<div class="dCell"><label>Codigo del producto</label></div>
		            		<div class="dCell"><input class="form-control" name="codProduct-`+a+`" id="cp" value="<%=cp%>"/></div>
		            		<div class="dCell"><input type="button" class="btnconsultar" id="psearch" value="+"></div>
		            		<div class="dCell"><input type="button" class="btnborrar" id="delPro" value="-" /></div>
						</div>
					</div>
				</fieldset>
				<fieldset id="productos">	
					<div class="dTable" id="tProductos">
			            <div class="dHeading" id="encabezados">
			            	<div class="dCell">Item</div>
			            	<div class="dCell">Codigo del producto</div>
			            	<div class="dCell">Nombre del producto</div>
			            	<div class="dCell">Cantidad</div>
			            	<div class="dCell">Valor producto</div>
			            	<div class="dCell">Valor Total</div>
			            	<div class="dCell"></div>
			            </div>
	            	</div>
	            	
            	</fieldset>
            	<fieldset>
		            <div class="dTable" id="cal">
		            	<div class="dRow">
		            		<div class="dCell"><label>Sub Total</label></div>
		            		<div class="dCell"><input id="stotal" /></div>
		            	</div>
		            	<div class="dRow">
							<div class="dCell"><label>Iva</label></div>
			            	<div class="dCell"><input id="iva" /></div>
			            </div>
		            	<div class="dRow">
							<div class="dCell"><label>Total</label></div>
			            	<div class="dCell"><input id="total" /></div>
						</div>
					</div>
	            </fieldset>
            </form>
        </section>

<%-- TABLA DONDE SE CARGAN LOS PRODUCTOS --%>	
        <section class="tabla">
          <table class="dtable">
            <thead class="dHeading">
              <tr class="dRow">
                <th colspan="3">Precios</th>
                <th colspan="2">Cliente</th>
                <th colspan="4">Producto</th>
              </tr>
              <tr class="dRow">
                <th class="dCell">Total venta</th>
                <th class="dCell">Total IVA</th>
                <th class="dCell">Total con IVA</th>
                <th class="dCell">Cedula</th>
                <th class="dCell">Nombre del cliente</th>
                <th class="dCell">Codigo del producto</th>
                <th class="dCell">Nombre del producto</th>
                <th class="dCell">Cantidad</th>
                <th class="dCell">Consecutivo</th>
              </tr>
            </thead>
          </table>
        </section>
	</main>
</body>
</html>