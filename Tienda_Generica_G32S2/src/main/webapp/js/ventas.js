/**
 * 
 */
$(document).ready(function(){

a = 0;

//crear campo producto	

//borrar campo producto
	
$('#delPro').on('click', function(e){
	
	e.preventDefault();
	alert("intentando eliminar :P");
	/*document.appendChild(document.removeChild());*/	
	if (a!=0){
	    	$('#product-'+a+'').remove();
			a--;
	    }
});


$('#psearch').on('click', function(e){
	
	a++;
	
	e.preventDefault();
	
	var cp=document.getElementById("cp").value;
	
	if(cp==0 || cp==null){
		alert("campo vacio o en 0");
	}else{
	$.ajax({
	type:"post",
	url:"ServletProductos",
	dataType:"json",
	data:{boton : "btnsearch", cp: cp},
	success: function(result){
		console.log("success");
		console.log(result);
		alert(a);
		if (result!=null){
			var dato=document.createElement('div');
			dato.setAttribute('class','dRow');
			dato.setAttribute('id','product-'+a+'');
			dato.innerHTML='';
			dato.innerHTML+=`<div class="dCell">
						<label class="form-control" id="itemProduct-`+a+`" type="number" value="">`+a+`</label>
					</div>
					<div class="dCell">
						<input class="form-control" id="codProduct-`+a+`" type="number" value="${result.codigo_producto}"/>
					</div>
					<div class="dCell">
						<input class="form-control" id="nameProduct-`+a+`" type="text" value="${result.nombre_producto}"/>
					</div>
					<div class="dCell">
						<input class="form-control" id="cantProduct-`+a+`" type="number"/>
					</div>
					<div class="dCell">
		                <input class="form-control" id="valProduct-`+a+`" type="number" value="${result.precio_venta}"/>
					</div>
					<div class="dCell">
		                <input class="form-control" id="totProduct-`+a+`" type="number" value=""/>
					</div>
					<div class="dCell">
		                
					</div>
					<input type="text" name="iv" value="${result.ivacompra}" style="display: none">
					<input type="text" name="pc" value="${result.precio_compra}" style="display: none">`;
					document.getElementById('tProductos').appendChild(dato);
					document.getElementById('tProductos').appendChild(dato);
					document.getElementById('tProductos').appendChild(dato);
					document.getElementById('tProductos').appendChild(dato);
					document.getElementById('tProductos').appendChild(dato);
					document.getElementById('tProductos').appendChild(dato);
		}else{
			alert("Codigo de producto incorrecto");
		}
		
		console.log("success");
	}
	
});
}
		
});

});