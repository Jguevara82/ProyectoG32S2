/**
 * 
 */
$(document).ready(function(){
	
	$('#btinsert').on('click', function(){
		
		var nitp=document.getElementById('nitp').value;
		var cp=document.getElementById('cp').value;
		var dp=document.getElementById('dp').value;
		var np=document.getElementById('np').value;
		var tp=document.getElementById('tp').value;
		
		$.ajax({
			type:"post",
			url:"ServletCRUDProveedores",
			dataType: "json",
			data:{boton: "btninsert", nitp : nitp, cp : cp, dp : dp, np : dp, tp : tp},
			success:function(result){
				console.log("success");
				console.log(result);
				if(result!=null){
					if(result){
						alert("El proveedor fue registrado");
					}else{
						alert("El proveedor no fue registrado");
					}
				}else{
					alert("Ingrese un documento valido");
				}
				
			}
			
		});
	});
	
	$('#btdelete').on('click', function(){
		
		var nitp=document.getElementById('nitpu').value;
		var cp=document.getElementById('cpu').value;
		var dp=document.getElementById('dpu').value;
		var np=document.getElementById('npu').value;
		var tp=document.getElementById('tpu').value;
		
		$.ajax({
			type:"post",
			url:"ServletCRUDProveedores",
			dataType: "json",
			data:{boton: "btndelete", nitp : nitp, cp : cp, dp : dp, np : dp, tp : tp},
			success:function(result){
				console.log("success");
				console.log(result);
				if(result!=null){
					if(result){
						alert("El proveedor fue eliminado");
					}else{
						alert("No se encontro un proveedor con ese documento");
					}
				}else{
					alert("Ingrese una documento valido");
				}
			}
			
		});
	});
	
	$('#btupdate').on('click', function(){
		
		$.ajax({
			type:"post",
			url:"ServletCRUDProveedores",
			dataType: "json",
			data:{boton: "btnupdate"},
			success:function(result){
				console.log("success");
				console.log(result);
				if(result!=null){
					if(result){
						alert("El proveedor fue actualizado");
					}else{
						alert("El proveedor no fue actualizado");
					}
				}else{
					alert("Ingrese un documento valido");
				}
			}
			
		});
	});
	
	$('#btsearch').on('click', function(){
		
		var nitp=document.getElementById('nitps').value;
		
		$.ajax({
			type:"post",
			url:"ServletCRUDProveedores",
			dataType: "json",
			data:{boton: "btnsearch", nitp : nitp},
			success:function(result){
				console.log("success");
				console.log(result);
				let datos=document.querySelector('#datos');
				datos.innerHTML='';
				datos.innerHTML+=`<label>Ciudad Proveedor<input value="${result.ciudad_proveedor}"></label><label>Direccion Proveedor<input value="${result.direccion_proveedor}"></label><label>Nombre proveedor<input value="${result.nombre_proveedor}"></label><label>Telefono proveedor<input value="${result.telefono_proveedor}""></label>`;
			}
			
		});
	});
	
	
	
	
	
	
	
});