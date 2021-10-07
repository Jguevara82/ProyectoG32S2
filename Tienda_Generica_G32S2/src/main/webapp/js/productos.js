/**
 * 
 */
$(document).ready(function(){

//consultar

$('#psearch').on('click', function(e){
	
	e.preventDefault();
	
	var cp=document.getElementById("cp").value;
	
	$.ajax({
	type:"post",
	url:"ServletProductos",
	dataType:"json",
	data:{boton : "btnsearch", cp: cp},
	success: function(result){
		console.log("success");
		console.log(result);
		if (result!=null){
			let datos=document.querySelector('#datos');
			datos.innerHTML='';
			datos.innerHTML+=`<label>Iva</label>
			<input type="text" name="iv" value="${result.ivacompra}">
			<label>Nit Del Proveedor</label>
			<input type="text" name="ni"value="${result.nitproveedor}">
			<label>Nombre Del Producto</label>
			<input type="text" name="np"value="${result.nombre_producto}">
			<label>Precio De Compra</label>
			<input type="text" name="pc"value="${result.precio_compra}">
			<label>Precio De Venta</label>
			<input type="text" name="pv"value="${result.precio_venta}">`;
		}else{
			alert("Codigo de producto incorrecto");
		}
		
	}
	
});
		
});
	
//Cargar archivo	
	
$("form.upload").on('submit', function(e){
	
	e.preventDefault();
	
	alert("en la funcion de carga");
	
	var formData=new FormData (document.getElementById("cargar"));
	
	$.ajax({
		type:"post",
		url:"ServletProductos",
		dataType:"html",
		data:formData,
		cache: false,
		contentType: false,
		processData: false
	}).done(function(res){
		$("#mensaje").html("Respuesta: "+res);
});

});


	
	
	
	
	
	
	
	
	
	
	
	
	
});