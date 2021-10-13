/**
 * 
 */
$(document).ready(function(){
	
//Lista usuario

$('#list').on('click',function(){
	
	
$.ajax({
	type:"post",
	url:"ServletCRUDUsuario",
	dataType:"json",
	data: {boton : "btnlist"},
	success: function(result){
		console.log("success");
		console.log(result);
		for(let i of result){
			let datos=document.createElement('div');
			datos.setAttribute('class','dRow');
			datos.innerHTML='';
			datos.innerHTML+=`<div class="dCell">${i.cedula_usuario}</div><div class="dCell">${i.email_usuario}</div><div class="dCell">${i.nombre_usuario}</div><div class="dCell">${i.password}</div><div class="dCell">${i.usuario}</div>`;
			document.getElementById('datos').appendChild(datos);
		}
	}
});

});

//lista cliente

$('#listc').on('click',function(){
	
		
$.ajax({
	type:"post",
	url:"ServletCRUDClientes",
	dataType:"json",
	data: {boton : "btnlist"},
	success: function(result){
		console.log("success");
		console.log(result);
		for(let i of result){
			let datos=document.createElement('div');
			datos.setAttribute('class','dRow');
			datos.innerHTML='';
			datos.innerHTML+=`<div class="dCell">${i.cedula_cliente}</div><div class="dCell">${i.direccion_cliente}</div><div class="dCell">${i.email_cliente}</div><div class="dCell">${i.nombre_cliente}</div><div class="dCell">${i.telefono_cliente}</div>`;
			document.getElementById('datosc').appendChild(datos);
			document.getElementById('datosc').appendChild(datos);
		}
	}
});

});

//Crear usuario

$('#btinsert').on('click',function(){
	
	var cu=document.getElementById('cu').value;
	var eu=document.getElementById('eu').value;
	var nu=document.getElementById('nu').value;
	var p=document.getElementById('p').value;
	var u=document.getElementById('u').value;
	
	
$.ajax({
	type:"post",
	url:"ServletCRUDUsuario",
	dataType:"json",
	data: {boton : "btninsert", cu : cu, eu : eu, nu : nu, p : p, u : u},
	success: function(result){
		console.log("success");
		console.log(result);
	}
});

});

//Eliminar usuario

$('#btdelete').on('click',function(){
	
	alert("en la funcion");
	var cu=document.getElementById('cud').value;
	
$.ajax({
	type:"post",
	url:"ServletCRUDUsuario",
	dataType:"json",
	data: {boton : "btndelete", cu : cu},
	success: function(result){
		console.log("success");
		console.log(result);
	}
});

});

//Actualizar usuario

$('#btupdate').on('click',function(){
	
	var cu=document.getElementById('cuu').value;
	var eu=document.getElementById('euu').value;
	var nu=document.getElementById('nuu').value;
	var p=document.getElementById('pu').value;
	var u=document.getElementById('uu').value;
	
	
$.ajax({
	type:"post",
	url:"ServletCRUDUsuario",
	dataType:"json",
	data: {boton : "btnupdate", cu : cu, eu : eu, nu : nu, p : p, u : u},
	success: function(result){
		console.log("success");
		console.log(result);
	}
});

});

//Buscar usuario

$('#usearch').on('click',function(){
	
	var cu=document.getElementById('cus').value;
	
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


//listar ventas

$('#listv').on('click', function(){
	
	$.ajax({
		type: "post",
		url: "ServletVentas",
		dataType: "json",
		data:{boton:"listVen"},
		success:function(result){
			console.log("success");
			console.log(result);
			let datos=document.createElement('div');
			datos.setAttribute('class','dRow');
			datos.innerHTML='';
			for(let i of result){
				let datos=document.createElement('div');
				datos.setAttribute('class','dRow');
				datos.innerHTML='';
				datos.innerHTML+=`<div class="dCell">${i.cedula_cliente}</div><div class="dCell"></div><div class="dCell">${i.total_venta}</div>`;
				document.getElementById('datosv').appendChild(datos);
				document.getElementById('datosv').appendChild(datos);
				}
			/*if(Object.keys(result).length==6){
				datos.innerHTML+=`<tr><td>${result.cedula_cliente}</td><td></td><td>${result.total_venta}</td></tr>`;
			}else{
				
			}*/
			
		}
	});
});

});