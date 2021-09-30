/**
 * 
 */
$(document).ready(function(){
	
//Lista	
function listarUsuarios(){
	alert("Lista BD");
$.ajax({
	type:"post",
	url:"ServletCRUDUsuario",
	dataType:"json",
	success: function(result){
		console.log("success");
		console.log(result);
		let datos=document.querySelector('#tabla');
		datos.innerHTML='';
		datos.innerHTML+=`<tr><th>Cedula Usuario</th><th>Email Usuario</th><th>Nombre Usuario</th><th>Password</th><th>Usuario</th></tr>`;
		for(let i of result){
			datos.innerHTML+=`<tr><td>${i.cedula_usuario}</td><td>${i.email_usuario}</td><td>${i.nombre_usuario}</td><td>${i.password}</td><td>${i.usuario}</td></tr>`;
		}
	}
});

}

$('#list').on('click',function(){
	listarUsuarios();
});

//Crear

//Eliminar

//Actualizar

//Buscar

});