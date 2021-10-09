
$(document).ready(function(){

//variable contadora

a = 0;

//borrar campo producto
	
$('#delPro').on('click', function(e){
	
	e.preventDefault();
	/*document.appendChild(document.removeChild());*/	
	if (a!=0){
	    	$('#product-'+a+'').remove();
			a--;
	    }
});

//crear campo producto	

$('#psearch').on('click', function(){
	
	if(a<=2){
	
		a++;
			
		var cp=document.getElementById("plist").value;
		
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
			if (result!=null){
				var dato=document.createElement('div');
				dato.setAttribute('class','dRow');
				dato.setAttribute('id','product-'+a+'');
				dato.innerHTML='';
				dato.innerHTML+=`<div class="dCell">
							<label class="" id="itemProduct-`+a+`" value="">`+a+`</label>
						</div>
						<div class="dCell">
							<label class="" id="codProduct-`+a+`" value="">${result.codigo_producto}</label>
						</div>
						<div class="dCell">
							<label class="" id="nameProduct-`+a+`" value="">${result.nombre_producto}</label>
						</div>
						<div class="dCell">
							<input class="" name="`+a+`" id="cantProduct-`+a+`" type="number" min="0" max="10" onchange="vCalProducto(this.value,this.name)"/>
						</div>
						<div class="dCell">
			                <label class="" id="valProduct-`+a+`" value="">${result.precio_venta}</label>
						</div>
						<div class="dCell">
			                <label class="" id="vTotalProduct-`+a+`" value=""></label>
						</div>
						<div class="dCell">
			                <label class="" id="ivaProduct-`+a+`" value="" style="display: none">${result.ivacompra}</label>
			                <label class="" id="ivaTotalProduct-`+a+`" value="" style="display: none">0</label>
						</div>
						`;
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
		
	}else{
		alert("Solo se pueden agregar tres productos");
	}
		
});

//index

function listCodProductos(){
	
	$.ajax({
	type:"post",
	url:"ServletProductos",
	dataType:"json",
	data:{boton : "btnlist"},
	success: function(result){
		console.log("success");
		console.log(result);
		if (result!=null){
			let dato=document.querySelector('#plist');
			dato.innerHTML='';
			for (let i of result){
				dato.innerHTML+=`<option>${i.codigo_producto}</option>`;				
			}
			
		}else{
			alert("no se consulto la BD");
		}
		
		console.log("success");
	}
	
	});
	
};

listCodProductos()

//



});