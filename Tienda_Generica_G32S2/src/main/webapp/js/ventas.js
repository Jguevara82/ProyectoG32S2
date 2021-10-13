
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
							<label class="" id="compProduct-`+a+`" value="" style="display: none">${result.precio_compra}</label>
			                <label class="" id="valProduct-`+a+`" value="">${result.precio_venta}</label>
						</div>
						<div class="dCell">
			                <label class="" id="vTotalProduct-`+a+`" value=""></label>
						</div>
						<div class="dCell" style="display: none">
			                <label class="" id="ivaProduct-`+a+`" value="">${result.ivacompra}</label>
			                <label class="" id="ivaTotalProduct-`+a+`" value="">0</label>
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
	
$('#delPro').on('click', function(){
	
	
	if (a!=0){
	    	$('#product-'+a+'').empty();
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
	
	conCodigos()
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
		var num=Number(result.codigo_venta+1);
		var dato=document.createElement('div');
		dato.setAttribute('class','dCell');
		dato.innerHTML='';
		dato.innerHTML+=`<input id="conCodV" style="display: none" value="`+num+`"> `;
		document.getElementById('datosUsuCli').appendChild(dato);
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
		var num=Number(result.codigo_detalle_venta+1);
		var dato=document.createElement('div');
		dato.setAttribute('class','dCell');
		dato.innerHTML='';
		dato.innerHTML+=`<input id="conCodDV" style="display: none" value="`+num+`"> `;
		document.getElementById('datosUsuCli').appendChild(dato);
	}
	
	});
	
};

//confirmar venta

$('#confirmarVenta').on('click', function(){
		//variables tabla ventas	
		var cv=document.getElementById("conCodV").value;
		var cc=document.getElementById("cedCli").innerHTML;
		var cu=document.getElementById("cedusu").innerHTML;
		var iv=document.getElementById("itotal").innerHTML;
		var tv=document.getElementById("total").innerHTML;
		var vv=document.getElementById("stotal").innerHTML;
		//variables tabla detalle ventas 1
		var cdv=document.getElementById("conCodDV").value;
		cdv1=Number(cdv);
		var cp1=document.getElementById("cantProduct-1").value;
		var cdp1=document.getElementById("codProduct-1").innerHTML;
		var ptv1=document.getElementById("vTotalProduct-1").innerHTML;
		var pvv1=document.getElementById("valProduct-1").innerHTML;
		var piv1=document.getElementById("ivaTotalProduct-1").innerHTML;
		//variables tabla detalle ventas 1
		var cdv2=cdv1+1;
		var cp2=document.getElementById("cantProduct-2").value;
		var cdp2=document.getElementById("codProduct-2").innerHTML;
		var ptv2=document.getElementById("vTotalProduct-2").innerHTML;
		var pvv2=document.getElementById("valProduct-2").innerHTML;
		var piv2=document.getElementById("ivaTotalProduct-2").innerHTML;
		//variables tabla detalle ventas 1
		var cdv3=cdv1+2;
		var cp3=document.getElementById("cantProduct-3").value;
		var cdp3=document.getElementById("codProduct-3").innerHTML;
		var ptv3=document.getElementById("vTotalProduct-3").innerHTML;
		var pvv3=document.getElementById("valProduct-3").innerHTML;
		var piv3=document.getElementById("ivaTotalProduct-3").innerHTML;
		
		alert(
			 "Codigo venta: "+cv+"\n"
			+"- Codigo detalle venta: "+cdv1+"\n"
			+"- Codigo detalle venta: "+cdv2+"\n"
			+"- Codigo detalle venta: "+cdv3+"\n"
			+"- Cedula usuario: "+cu+"- Cedula cliente: "+cc+"\n"+" Total iva: "+iv+"- Valor venta: "+vv+"- Total venta: "+tv+"\n"
			+"Producto: 1"+cdp1+"- Cantidad de producto: "+cp1+"\n"+"- Iva producto: "+piv1+"- Valor: producto: "+pvv1+"- Total Producto: "+ptv1+"\n"
			+"Producto: 2"+cdp2+"- Cantidad de producto: "+cp2+"\n"+"- Iva producto: "+piv2+"- Valor: producto: "+pvv2+"- Total Producto: "+ptv2+"\n"
			+"Producto: 3"+cdp3+"- Cantidad de producto: "+cp3+"\n"+"- Iva producto: "+piv3+"- Valor: producto: "+pvv3+"- Total Producto: "+ptv3);
		
});


//registrar venta

$('#enviarVenta').on('click', function(){
	var cc=document.getElementById("cedCli").innerHTML;
	//var cc=80166365;
	if(cc==0 || cc==null){
			alert("No se ha consultado el cliente");
	}else{
		//variables tabla ventas	
		var cv=document.getElementById("conCodV").value;
		var cu=document.getElementById("cedusu").innerHTML;
		var iv=document.getElementById("itotal").innerHTML;
		var tv=document.getElementById("total").innerHTML;
		var vv=document.getElementById("stotal").innerHTML;
		//variables tabla detalle ventas 1
		var cdv=document.getElementById("conCodDV").value;
		cdv1=Number(cdv);
		var cp1=document.getElementById("cantProduct-1").value;
		var cdp1=document.getElementById("codProduct-1").innerHTML;
		var ptv1=document.getElementById("vTotalProduct-1").innerHTML;
		var pvv1=document.getElementById("valProduct-1").innerHTML;
		var piv1=document.getElementById("ivaTotalProduct-1").innerHTML;
		//variables tabla detalle ventas 1
		var cdv2=cdv1+1;
		var cp2=document.getElementById("cantProduct-2").value;
		var cdp2=document.getElementById("codProduct-2").innerHTML;
		var ptv2=document.getElementById("vTotalProduct-2").innerHTML;
		var pvv2=document.getElementById("valProduct-2").innerHTML;
		var piv2=document.getElementById("ivaTotalProduct-2").innerHTML;
		//variables tabla detalle ventas 1
		var cdv3=cdv1+2;
		var cp3=document.getElementById("cantProduct-3").value;
		var cdp3=document.getElementById("codProduct-3").innerHTML;
		var ptv3=document.getElementById("vTotalProduct-3").innerHTML;
		var pvv3=document.getElementById("valProduct-3").innerHTML;
		var piv3=document.getElementById("ivaTotalProduct-3").innerHTML;
		
		alert(
			 "Codigo venta: "+cv+"\n"
			+"- Codigo detalle venta: "+cdv1+"\n"
			+"- Codigo detalle venta: "+cdv2+"\n"
			+"- Codigo detalle venta: "+cdv3+"\n"
			+"- Cedula usuario: "+cu+"- Cedula cliente: "+cc+"\n"+" Total iva: "+iv+"- Valor venta: "+vv+"- Total venta: "+tv+"\n"
			+"Producto: 1"+cdp1+"- Cantidad de producto: "+cp1+"\n"+"- Iva producto: "+piv1+"- Valor: producto: "+pvv1+"- Total Producto: "+ptv1+"\n"
			+"Producto: 2"+cdp2+"- Cantidad de producto: "+cp2+"\n"+"- Iva producto: "+piv2+"- Valor: producto: "+pvv2+"- Total Producto: "+ptv2+"\n"
			+"Producto: 3"+cdp3+"- Cantidad de producto: "+cp3+"\n"+"- Iva producto: "+piv3+"- Valor: producto: "+pvv3+"- Total Producto: "+ptv3);
		
		//venta
		
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertv", cv : cv, cc : cc, cu : cu, iv : iv, tv : tv, vv : vv},
		success: function(result){
			console.log("success0");
			console.log(result);
			if(result!=null){
				if(result){
					alert("La venta fue registrada");
				}else{
					alert("La venta no fue registrada");
				}
			}else{
				alert("Datos invalidos para ingresar la venta");
			}
			
		}
		
		});
		
		alert("Producto: 1"+cdp1+"- Cantidad de producto: "+cp1+"\n"+"- Iva producto: "+piv1+"- Valor: producto: "+pvv1+"- Total Producto: "+ptv1);
		//detalles
		
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertdv", cdv : cdv1, cp : cp1, cdp : cdp1, cv : cv, ptv : ptv1, pvv : pvv1, piv : piv1},
		success: function(result1){
			console.log("success1");
			console.log(result1);
			if(result1!=null){
				if(result1){
					alert("El detalle de venta 1 fue registrado");
				}else{
					alert("El detalle de venta 1 no fue registrado");
				}
			}else{
				alert("Datos invalidos para ingresar el detalle de venta 1");
			}
			
		}
				
		});
		
		alert("Producto: 2"+cdp2+"- Cantidad de producto: "+cp2+"\n"+"- Iva producto: "+piv2+"- Valor: producto: "+pvv2+"- Total Producto: "+ptv2);
		//detalle venta 2
		
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertdv", cdv : cdv2, cp : cp2, cdp : cdp2, cv : cv, ptv : ptv2, pvv : pvv2, piv : piv2},
		success: function(result2){
			console.log("success2");
			console.log(result2);
			if(result2!=null){
				if(result2){
					alert("El detalle de venta 2 fue registrado");
				}else{
					alert("El detalle de venta 2 no fue registrado");
				}
			}else{
				alert("Datos invalidos para ingresar el detalle de venta 2");
			}
			
		}
		
		});
		
		alert("Producto: 3"+cdp3+"- Cantidad de producto: "+cp3+"\n"+"- Iva producto: "+piv3+"- Valor: producto: "+pvv3+"- Total Producto: "+ptv3);
		//detalle venta 3
								
		$.ajax({
		type:"post",
		url:"ServletVentas",
		dataType:"json",
		data:{boton : "btninsertdv", cdv : cdv3, cp : cp3, cdp : cdp3, cv : cv, ptv : ptv3, pvv : pvv3, piv : piv3},
		success: function(result3){
			console.log("success3");
			console.log(result3);
			if(result3!=null){
				if(result3){
					alert("El detalle de venta 3 fue registrado");
				}else{
					alert("El detalle de venta 3 no fue registrado");
				}
			}else{
				alert("Datos invalidos para ingresar el detalle de venta 3");
			}
		}
		
		});
		
		location.reload()
		
	}
			
});

//select de codigos de productos

listCodProductos()


});