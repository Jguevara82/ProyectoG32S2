$(document).ready(function(){
	
	const formubuscarCli = document.getElementById('formBuscarCli');

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
		console.log(result);
		let nombrecli = document.querySelector("#ncBuscar");
		let cedula = document.querySelector("#cedCliC");
		
		if(result !== false){
				nombrecli.setAttribute("value", `${result.nombre_usuario}`);
				cedula.innerHTML='';
				cedula.innerHTML+=`<label id="cedCli" style="display:none">${result.cedula_cliente}</label>`;
		}else{
				nombrecli.setAttribute("value", "");
		}
	}
});
}

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

});

