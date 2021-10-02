$(document).ready(function(){
	
	const formubuscarCli = document.getElementById('formBuscarCli');
	const formCrearCli = document.getElementById('formCrearCli');
	const expresiones = {
    correoExp: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
	};

function buscarcliente(cedulacli){
$.ajax({
	type:"post",
	url:"ServletCRUDClientes",
	dataType:"json",
	data:{
		consultcli: "traercli",
		cedulabuscar: cedulacli
	},
	success: function(result){

		let dircli = document.querySelector("#dcBuscar");
		let emailcli = document.querySelector("#ecBuscar");
		let nombrecli = document.querySelector("#ncBuscar");
		let telcli = document.querySelector("#tcBuscar");
		if(result !== false){
				dircli.setAttribute("value", `${result.direccion_cliente}`);
				emailcli.setAttribute("value", `${result.email_cliente}`);
				nombrecli.setAttribute("value", `${result.nombre_usuario}`);
				telcli.setAttribute("value", `${result.telefono_cliente}`);
		}else{
				dircli.setAttribute("value", "");
				emailcli.setAttribute("value", "");
				nombrecli.setAttribute("value", "");
				telcli.setAttribute("value", "");
		}
	}
});
}


function crearCliente(ced, dir, nom, email, tel){
	$.ajax({
		type:"post",
		url:"ServletCRUDClientes",
		dataType:"json",
		data:{
			consultcli: "crearcli",
			cedulacrear: ced,
			direccioncrear: dir,
			nombrecrear: nom,
			emailcrear: email,
			telcrear: tel
		},
		success: function(result){
					console.log(result);
		}

	});
}


formCrearCli.addEventListener('submit', (e) =>{
	e.preventDefault();
	var cedula = document.getElementById("ccCrear").value;
	var direccion = document.getElementById("dcCrear").value;
	var nombre = document.getElementById("ncCrear").value;
	var email = document.getElementById("ecCrear").value;
	var telefono = document.getElementById("tcCrear").value;
	
	valcel = validarcedula(cedula);
	valcorr = validarcorreo(email);
	if (valcel === true){
		if(valcorr === true){
	crearCliente(cedula, direccion, nombre, email, telefono);
	}
	}
	
});




 formubuscarCli.addEventListener('submit', (e) => {
e.preventDefault();
var cedula = document.getElementById("ccBuscar").value;
	valcel = validarcedula(cedula);
	if (valcel === true){
	buscarcliente(cedula);
	}else{
		
	}
});



function validarcedula(ced) {
    if (ced.length < 5 || ced.length > 12 || isNaN(ced)) {
        alert("la cedula debe ser en formato numerico de 5 a 12 caracteres");
	return false;
    } else {
	return true;	
    }
}

function validarcorreo(correo){
	if(expresiones.correoExp.test(correo)){
		return true;
	}else{
		alert("digite un correo valido (ejemplo@ejemplo.com)");
		return false;
	}
}

});

