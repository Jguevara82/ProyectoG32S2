/**
 * 
 */
$(document).ready(function(){
	
//Lista

function listarUsuarios(){
	
	alert("Lista Usuarios");
	
$.ajax({
	type:"post",
	url:"ServletCRUDUsuario",
	dataType:"json",
	data: {boton : "btnlist"},
	success: function(result){
		console.log("success");
		console.log(result);
		let datos=document.querySelector('#datos');
		datos.innerHTML='';
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

function crearUsuario(){
	
	alert("Crear usuario");


}

$('#btinsert').on('click',function(){
	crearUsuario();
});

//Eliminar

//Actualizar

//Buscar

function buscarUsuario(cu){
	
	alert("Buscar Usuario");
	
$.ajax({
	type:"post",
	url:"ServletCRUDUsuario",
	dataType:"json",
	data: {boton : "btnsearch", cu : cu},
	success: function(result){
		console.log("success");
		console.log(result);
		let datos=document.querySelector('#datos');
		datos.innerHTML='';
		datos.innerHTML+=`<label>Email Usuario<input value="${result.email_usuario}"></label><label>Nombre Usuario<input value="${result.nombre_usuario}"></label><label>Password<input value="${result.password}"></label><label>Usuario<input value="${result.usuario}""></label>`;
	}
});

}

$('#usearch').on('click',function(){
	var cu=document.getElementById('cu').value;
	alert(cu);
	buscarUsuario(cu);
});

});