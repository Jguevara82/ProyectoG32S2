
$(document).ready(function(){

//variable contadora

a = 0;

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
				/*var dato1=document.querySelector('#codProduct-'+a);
				dato1.setAttribute('value',result.codigo_producto);
				let dato2=document.querySelector('#nameProduct-'+a);
				dato2.setAttribute('value',result.nombre_producto);
				let dato3=document.querySelector('#valProduct-'+a);
				dato3.setAttribute('value',result.precio_venta);
				let dato4=document.querySelector('#ivaProduct-'+a);
				dato4.setAttribute('value',result.ivacompra);*/
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
							<input class="" name="`+a+`" id="cantProduct-`+a+`" type="number" min="1" max="10" value="1" onchange="vCalProducto(this.value,this.name)"/>
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

//borrar campo producto
	
$('#delPro').on('click', function(e){
	
	e.preventDefault();
	/*document.appendChild(document.removeChild());*/	
	if (a!=0){
	    	$('#product-'+a+'').remove();
			a--;
	    }
});

//index productos

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

//codigos ventas y detalle de ventas

function conCodigos(){
	
	$.ajax({
	type:"post",
	url:"ServletVentas",
	dataType:"json",
	data:{boton : "conCodV"},
	success: function(result){
		console.log("success");
		console.log(result);
		if (result.codigo_venta!=0){
			let dato=document.querySelector('#conCodV');
			dato.setAttribute('value',result.codigo_venta);
			
		}else{
			let dato=document.querySelector('#conCodV');
			dato.setAttribute('value',1);
		}
		
		console.log("success");
	}
	
	});
	
	$.ajax({
	type:"post",
	url:"ServletVentas",
	dataType:"json",
	data:{boton : "conCodDV"},
	success: function(result){
		console.log("success");
		console.log(result);
		if (result.codigo_detalle_venta!=0){
			let dato=document.querySelector('#conCodDV');
			dato.setAttribute('value',result.codigo_detalle_venta);
			
		}else{
			let dato=document.querySelector('#conCodDV');
			dato.setAttribute('value',1);
		}
		
		console.log("success");
	}
	
	});
	
};
//registrar venta

$('#enviarVenta').on('click', function(){
	var cc=document.getElementById("cedCli").innerHTML;
	//var cc=80166365;
	if(cc==0 || cc==null){
			alert("No se ha consultado el cliente");
	}else{
		//variables tabla ventas	
		var cv=document.getElementById("conCodV").value;
		//var cv=0
		if (cv!=1){
			cv++;
		}		
		var cu=document.getElementById("cedusu").innerHTML;
		var iv=document.getElementById("itotal").innerHTML;
		var tv=document.getElementById("total").innerHTML;
		var vv=document.getElementById("stotal").innerHTML;
		//variables tabla detalle ventas
		var cdv1=(document.getElementById("conCodDV").innerHTML);
		if (cdv1!=1){
			cdv1++;
		}
		var cp1=document.getElementById("cantProduct-1").value;
		var cdp1=document.getElementById("codProduct-1").innerHTML;
		var ptv1=document.getElementById("vTotalProduct-1").innerHTML;
		var pvv1=document.getElementById("valProduct-1").innerHTML;
		var piv1=document.getElementById("ivaTotalProduct-1").innerHTML;
		var cdv2=cdv1+1;
		var cp2=document.getElementById("cantProduct-2").value;
		var cdp2=document.getElementById("codProduct-2").innerHTML;
		var ptv2=document.getElementById("vTotalProduct-2").innerHTML;
		var pvv2=document.getElementById("valProduct-2").innerHTML;
		var piv2=document.getElementById("ivaTotalProduct-2").innerHTML;
		var cdv3=cdv2+1;
		var cp3=document.getElementById("cantProduct-3").value;
		var cdp3=document.getElementById("codProduct-3").innerHTML;
		var ptv3=document.getElementById("vTotalProduct-3").innerHTML;
		var pvv3=document.getElementById("valProduct-3").innerHTML;
		var piv3=document.getElementById("ivaTotalProduct-3").innerHTML;
		
		alert("Codigo venta "+cv+" Codigo detalle venta "+cdv1+" Cedula usuario "+cu+" Cedula cliente "+cc+"\n"+"Total iva "+iv+" Valor venta "+vv+" Total venta"+tv+"\n"
		+"Producto 1"+cdp1+" Cantidad de producto "+cp1+" Iva producto "+piv1+" Valor producto "+pvv1+" Total Producto "+ptv1+"\n"
		+"Producto 2"+cdp2+" Cantidad de producto "+cp2+" Iva producto "+piv2+" Valor producto "+pvv2+" Total Producto "+ptv2+"\n"
		+"Producto 3"+cdp3+" Cantidad de producto "+cp3+" Iva producto "+piv3+" Valor producto "+pvv3+" Total Producto "+ptv3);
		
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertv", cv : cv, cc : cc, cu : cu, iv : iv, tv : tv, vv : vv},
		success: function(result){
			console.log("success");
			console.log(result);
		}
		
		});
		
		alert("Codigo detalle venta "+cdv1+"- Cantidad de producto "+cp1+"- Codigo de producto "+cdp1+"- Codigo venta "+cv+"- Precio producto  "+ptv1+"- Valor venta "+pvv1+" Valor iva "+piv1);
		
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertdv", cdv : cdv1, cp : cp1, cdp : cdp1, cv : cv, ptv : ptv1, pvv : pvv1, piv : piv1},
		success: function(result){
			console.log("success");
			console.log(result);
		}
		
		});
		
		alert("Codigo detalle venta "+cdv2+"- Cantidad de producto "+cp2+"- Codigo de producto "+cdp2+"- Codigo venta "+cv+"- Precio producto  "+ptv2+"- Valor venta "+pvv2+" Valor iva "+piv2);
		
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertdv", cdv : cdv2, cp : cp2, cdp : cdp2, cv : cv, ptv : ptv2, pvv : pvv2, piv : piv2},
		success: function(result){
			console.log("success");
			console.log(result);
		}
		
		});
		
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertdv", cdv : cdv3, cp : cp3, cdp : cdp3, cv : cv, ptv : ptv3, pvv : pvv3, piv : piv3},
		success: function(result){
			console.log("success");
			console.log(result);
		}
		
		});
		
	}
			
});

//select de codigos de productos

listCodProductos()
conCodigos()



});