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
    <%-- --%><script type="text/javascript" src="js/ventas.js"></script>
	<title>Ventas</title>
	<%--<link rel="stylesheet" href="css/menu.css">
	<link rel="stylesheet" href="css/tablasTodas.css">
	<link rel="stylesheet" href="css/ventas.css"> --%>
	<link rel="stylesheet" href="css/formulariosV.css">
	<link rel="stylesheet" href="css/dTable.css">
	<script type="text/javascript">
		function vCalProducto(cant,item) {
			
		    var precio = 0, ptotal = 0, iva= 0, iptotal = 0;	
		    
		    cant = parseInt(cant); // formatear valor de entrada
		    item = parseInt(item);
		    //captura de variables
			pcompra = document.getElementById('compProduct-'+item).innerHTML;
			precio = document.getElementById('valProduct-'+item).innerHTML;//value
		    ptotal = document.getElementById('vTotalProduct-'+item).innerHTML;
			iva = document.getElementById('ivaProduct-'+item).innerHTML;//value
			iptotal = document.getElementById('ivaTotalProduct-'+item).innerHTML;//value
			
		    // validacion "0".
		    pcompra = (pcompra == null || pcompra == undefined || pcompra == "") ? 0 : pcompra;
		    precio = (precio == null || precio == undefined || precio == "") ? 0 : precio;
		    ptotal = (ptotal == null || ptotal == undefined || ptotal == "") ? 0 : ptotal;
		    iva = (iva == null || iva == undefined || iva == "") ? 0 : iva;
		    iptotal = (iptotal == null || iptotal == undefined || iptotal == "") ? 0 : iptotal;
			
		    /* operacion */
		    ptotal = parseInt(precio) * parseInt(cant);
		    iptotal = parseInt((pcompra * iva) / 100) * parseInt(cant);
		    // resultado
		    document.getElementById('vTotalProduct-'+item).innerHTML = ptotal;
			document.getElementById('ivaTotalProduct-'+item).innerHTML = iptotal;
			
			vCalTotal();
		}
		function vCalTotal(){
			
			var stotal = 0, itotal = 0, total = 0, p1 = 0, i1 = 0, p2 = 0, i2 = 0, p3 = 0, i3 = 0 ;
			
			stotal = document.getElementById('stotal').innerHTML;
			itotal = document.getElementById('itotal').innerHTML;
		    total = document.getElementById('total').innerHTML;
		    
		    p1=document.getElementById('vTotalProduct-1').innerHTML;
			i1=document.getElementById('ivaTotalProduct-1').innerHTML;
		    p2=document.getElementById('vTotalProduct-2').innerHTML;
			i2=document.getElementById('ivaTotalProduct-2').innerHTML;
		    p3=document.getElementById('vTotalProduct-3').innerHTML;
			i3=document.getElementById('ivaTotalProduct-3').innerHTML;
		    

		    stotal = (stotal == null || stotal == undefined || stotal == "") ? 0 : stotal;
		    itotal = (itotal == null || itotal == undefined || itotal == "") ? 0 : itotal;
		    total = (total == null || total == undefined || total == "") ? 0 : total;
		    
		    p1 = (p1 == null || p1 == undefined || p1 == "") ? 0 : p1;
		    p2 = (p2 == null || p2 == undefined || p2 == "") ? 0 : p2;
		    p3 = (p3 == null || p3 == undefined || p3 == "") ? 0 : p3;
		    i1 = (i1 == null || i1 == undefined || i1 == "") ? 0 : i1;
		    i2 = (i2 == null || i2 == undefined || i2 == "") ? 0 : i2;
		    i3 = (i3 == null || i3 == undefined || i3 == "") ? 0 : i3;
		    
		    

			stotal = parseInt(p1)+parseInt(p2)+parseInt(p3);
		    itotal = parseInt(i1)+parseInt(i2)+parseInt(i3);
			total = (parseInt(stotal) + parseInt(itotal));
			
		    document.getElementById('stotal').innerHTML = stotal;
		    document.getElementById('itotal').innerHTML = itotal;
		    document.getElementById('total').innerHTML = total;
		}
	</script>
</head>
<body>
<%!	 %>
	
	<% 
	HttpSession hs=request.getSession();
	String cedula_usuario=(String)hs.getAttribute("cedUsu");
	
		
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
				<li><a href="index.jsp">Cerrar Sesión</a></li>
	        </ul>
	    </nav>
    </header>
    
	<main>
		<section class="container">
           	<form action="" id="formBuscarCli">
           		<fieldset>
		            <div class="dTable" id="cliente">
		            	<div class="dRow" id="datosUsuCli">
		            		<div class="dCell"><label>Cedula cliente</label></div>
		            		<div class="dCell"><input class="" name="ccBuscar" id="ccBuscar" type="text"></div>	
		            		<div class="dCell"><input type="submit" name="btnsearch" value="Buscar" class="btn-formularios" id="btnsearchcli"></div>
		            		<div class="dCell" style="width: 22%"></div>
		            		<div class="dCell"><h1>No.</h1></div><%-- --%>
							<div class="dCell" style="display: none; width: 0%"><label id="cedusu"><%=cedula_usuario %></label></div>
		            		<div class="dCell" id="cedCliC" style="display: none; width: 0%"><label id="cedCli"></label></div>
		            	</div>
		            </div>
		            <div class="dTable">
		            	<div class="dRow">
		            		<div class="dCell"><label>Nombre del cliente</label></div>
						    <div class="dCell"><input type="text" name="nc" id="ncBuscar" readonly="true"></div>
					    </div>
					</div>
				</fieldset>
				<fieldset id="productos">
					<div class="dTable" id="cProducto">
		            	<div class="dRow">
		            		<div class="dCell"><label>Codigo del producto</label></div>
		            		<div class="dCell"><select class="selectF" id="plist"></select></div>
		            		<div class="dCell"><input type="button" class="btn-formularios" id="psearch" value="+"></div><%--class="btnconsultar" --%>
		            		<%--<div class="dCell"><input type="button" class="btnborrar" id="delPro" value="-" /></div> --%>
						</div>
					</div>
					<div class="dTable" id="tProductos">
			            <div class="dHeading" id="encabezados">
			            	<div class="dCell">Item</div>
			            	<div class="dCell">Codigo del producto</div>
			            	<div class="dCell">Nombre del producto</div>
			            	<div class="dCell">Cantidad</div>
			            	<div class="dCell">Valor producto</div>
			            	<div class="dCell">Valor Total</div>
			            	<div class="dCell" style="display: none"></div>
			            </div>
			           <%-- <div class="dRow" id="row1">
			            	<div class="dCell">
								<label class="" id="itemProduct-1">1</label>
							</div>
							<div class="dCell">
								<input class="" id="codProduct-1" />
							</div>
							<div class="dCell">
								<input class="" id="nameProduct-1" />
							</div>
							<div class="dCell">
								<input class="" name="1" id="cantProduct-1" type="number" min="1" max="10" onchange="vCalProducto(this.value,this.name)"/>
							</div>
							<div class="dCell">
				                <input class="" id="valProduct-1" />
							</div>
							<div class="dCell">
				                <label class="" id="vTotalProduct-1"></label>
							</div>
							<div class="dCell">
				                <input class="" id="ivaProduct-1" style="display: none" />
				                <label class="" id="ivaTotalProduct-1" style="display: none"></label>
							</div>
			            </div>
			            <div class="dRow">
			            	<div class="dCell">
								<label class="" id="itemProduct-2">2</label>
							</div>
							<div class="dCell">
								<input class="" id="codProduct-2" />
							</div>
							<div class="dCell">
								<input class="" id="nameProduct-2" />
							</div>
							<div class="dCell">
								<input class="" name="2" id="cantProduct-2" type="number" min="1" max="10" onchange="vCalProducto(this.value,this.name)"/>
							</div>
							<div class="dCell">
				                <input class="" id="valProduct-2" />
							</div>
							<div class="dCell">
				                <label class="" id="vTotalProduct-2"></label>
							</div>
							<div class="dCell">
				                <input class="" id="ivaProduct-2" style="display: none" />
				                <label class="" id="ivaTotalProduct-2" style="display: none"></label>
							</div>
			            </div>
			            <div class="dRow">
			            	<div class="dCell">
								<label class="" id="itemProduct-3">3</label>
							</div>
							<div class="dCell">
								<input class="" id="codProduct-3" />
							</div>
							<div class="dCell">
								<input class="" id="nameProduct-3" />
							</div>
							<div class="dCell">
								<input class="" name="3" id="cantProduct-3" type="number" min="1" max="10" onchange="vCalProducto(this.value,this.name)"/>
							</div>
							<div class="dCell">
				                <input class="" id="valProduct-3" />
							</div>
							<div class="dCell">
				                <label class="" id="vTotalProduct-3"></label>
							</div>
							<div class="dCell">
				                <input class="" id="ivaProduct-3" style="display: none" />
				                <label class="" id="ivaTotalProduct-3" style="display: none"></label>
							</div>
			            </div> --%>
	            	</div>
	            </fieldset>
	            <fieldset>
	            	<div class="dTable" id="cal">
		            	<div class="dRow">
		            		<div class="dCell"><label>Sub Total</label></div>
		            		<div class="dCell"><label id="stotal"></label></div>
							<div class="dCell"><label>Iva</label></div>
			            	<div class="dCell"><label id="itotal" ></label></div>
							<div class="dCell"><label>Total</label></div>
			            	<div class="dCell"><label id="total" ></label></div>
		            	</div>
		            	<div class="dRow">
			            </div>
		            	<div class="dRow">
						</div>
					</div>
				</fieldset>
				<fieldset>
					<div class="dTable" id="enviar">
		            	<div class="dRow">
							<div class="dCell"><input type="button" class="btn-formularios" id="confirmarVenta" value="Confirmar"></div>
							<div class="dCell"><input type="button" class="btn-formularios" id="enviarVenta" value="Enviar"></div>
						</div>
					</div>	
            	</fieldset>
            </form>
        </section>

<%-- TABLA DONDE SE CARGAN LOS PRODUCTOS 	
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
        </section>--%>
	</main>
</body>
</html>