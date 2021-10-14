<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<title>Tienda Generica</title>
<!-- <link rel="stylesheet" href="css/login.css"> -->
<link rel="stylesheet" href="css/formulariosL.css">

</head>
<body>
	<section>
	<header class="cont-header" id="cont-header">
		<div class="logo-titulo" id="logo-titulo">
			<h1 class="h1" id="h1">Tienda Generica</h1>
		</div>
	</header>
	<div class="tabs">
            <div class="tab">
                <input type="radio" id="tab-1" name="tab-group-1" checked/>
                <label id="login" for="tab-1">Login</label>
            <div class="content login">
	<fieldset class="containers">
		
		<form action="ServletLogin" method="GET">
			<label>Bienvenidos</label>
			<div><br></div>
			<label for="usu">Usuario</label>
			<input type="text" name="usu" id="usu" placeholder="Digite su usuario" required="true">
			<label for="pass">Contraseña</label>
			<input type="password" name="pass" id="pass" placeholder="Digite su contraseña" required="true">
			<input type="submit" name="btningreso" value="Ingresar" class="btn-formularios">
			<div class="wrapper" style="margin: auto">
				<div>
					<label class="content-input">
					<input type="checkbox" onclick="myFunction()" name="ShowPass" id="ShowPass" value="ShowPass">
					<i></i>
					</label>
				</div>
			</div>
		</form>
	</fieldset>
            </div>
        </div>
        </div>
	</section>
<script>
function myFunction() {
  var x = document.getElementById("pass");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
</body>
</html>