/**
 * 
 */
$(document).ready(function(){
	
//Lista

$('#list').on('click',function(e){
	
	e.preventDefault();
	
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

});

//Crear

$('#btinsert').on('click',function(){
	crearUsuario();
});

//Eliminar

//Actualizar

//Buscar

$('#usearch').on('click',function(){
	
	var cu=document.getElementById('cu').value;
	
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

});

});