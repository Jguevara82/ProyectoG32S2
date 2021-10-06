<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Tienda Generica</title>
	<link rel="stylesheet" href="css/menu.css">
	<link rel="stylesheet" href="css/ventas.css">
<!-- FORMULARIO PARA CONSULTAR PRODUCTO -->
<script>
        a = 0;
        function addProducto(){
                a++;
        
                var fieldset = document.createElement('fieldset');
                fieldset.setAttribute('class', 'producto');
                fieldset.setAttribute('style', 'display:flex');
                //dentro del fieldset se agregan las siguientes etiqutas las cuales se pueden parametrizar a la medida
                fieldset.innerHTML = 
                        `<fieldset class="cont-formcliente">
                        <form action="" method="post">
                        <div class="">
                            <label>Cedula</label>
                            <input class="form-control" name="" type="text">
                            <input type="submit" value="Consultar" class="btnconsultar" name="ced">
                        </div>
                        <div class="">
                            <label>Nombre del cliente</label>
                            <input class="form-control" name="" type="text"/>
                        </div>
                        </form>
			                  </fieldset>
                        <fieldset class="cont-formcliente">
                        <form action="" method="post">
                        <div class="">
                            <label>Codigo del producto</label>
                            <input class="form-control" name="" type="number"/>
                            <input type="submit" value="Consultar" class="btnconsultar">
                        </div>
                        <div class="">
                            <label>Nombre del producto</label>
                            <input class="form-control" name="" type="number"/>
                        </div>
                        <div class="">
                            <label>Cantidad</label>
                            <input class="form-control" name="" type="number"/>
                            <input type="submit" value="Confirmar" class="btnconsultar">
                        </div>
                        <div class="col">
                            <input type="button" class="btn btn-success" id="add_producto()" onClick="addProducto()" value="+" />
                        </div>
                        </form>
			            </fieldset>`;
                document.getElementById('productos').appendChild(fieldset);document.getElementById('productos').appendChild(fieldset);
        }
        </script>


</head>
<body>
	<header class="cont-header" id="cont-header">
        <div class="logo-titulo" id="logo-titulo">
            <h1 class="h1" id="h1">Ventasl</h1>
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
    
<!-- TABLA DONDE SE CARGAN LOS PRODUCTOS -->	
	<main>
		<div class="container" display="flex">
            <h3>Añadir producto</h3>
            <form action="" id="formulario" method="get">
                <div class="col"><input type="button" class="btn btn-success" id="add_producto()" onClick="addProducto()" value="+" /></div>
            <!-- El id="productos" indica que la función de JavaScript dejará aquí el resultado -->
                <fieldset class="row" id="productos" display="flex"></fieldset>
            </form>
        </div>
        <div class="tabla">
          <table>
            <thead>
              <tr>
                <th colspan="3">Precios</th>
                <th colspan="2">Cliente</th>
                <th colspan="4">Producto</th>
              </tr>
              <tr>
                <th>Total venta</th>
                <th>Total IVA</th>
                <th>Total con IVA</th>
                <th>Cedula</th>
                <th>Nombre del cliente</th>
                <th>Codigo del producto</th>
                <th>Nombre del producto</th>
                <th>Cantidad</th>
                <th>Consecutivo</th>
              </tr>
            </thead>
          </table>
        </div>
	</main>
</body>
</html>