/**
 * 
 */
$(document).ready(function(){

//1 carga de archivo csv
/*$("#cargar").on('click', function(){
		
	$('#uploadCsv').ajaxForm({
            success: function(result) {
                console.log(result);
            },
            error: function(result) {
                console.log(result);
            }
	});

});	*/	

	

//2 actualizacion modificacion	
	
$("#btnupdate").on('click', function(){
	
	var cp=document.getElementById("cpa").value;
	var iv=document.getElementById("iva").value;
	var ni=document.getElementById("nia").value;
	var np=document.getElementById("npa").value;
	var pc=document.getElementById("pca").value;
	var pv=document.getElementById("pva").value;
		
	$.ajax({
		type:"post",
		url:"ServletProductos",
		dataType:"json",
		data:{boton: "btnupdate", cp : cp, iv : iv, ni : ni, np : np, pc : pc, pv : pv},
		success: function(result){
			console.log("success");
			console.log(result);
			location.reload();
		}
	});

});
	
//3 busqueda consulta

$('#psearch').on('click', function(){
		
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
	
	
//4 listado	
	
	
$("#btnlist").on('click', function(){
		
	$.ajax({
		type:"post",
		url:"ServletProductos",
		dataType:"json",
		data:{boton: "btnlist"},
		success: function(result){
			console.log("success");
			console.log(result);
			
		}
	});

});		
	
	
	
	
	
});