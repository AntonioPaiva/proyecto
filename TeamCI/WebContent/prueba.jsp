<%@include file="tpl/header.jsp" %>
	<script>
		function agregar(tarea , hito) {
			console.debug("Tarea: " + tarea + " Hito: " + hito);
			if($('#'+tarea).html()=="ACTIVO"){
		    	$.get("HitosTareas", { hito : hito, tarea : tarea , operacion : "ELIMINAR"  }, function(responseJson){
					if(responseJson){
						$('#'+tarea).html('INACTIVO');
						$('#'+tarea).attr('class','btn');
					}
				});
			}else{
		    	$.get("HitosTareas", { hito : hito, tarea : tarea , operacion : "INSERTAR"  }, function(responseJson){
					if(responseJson){
				    	$('#'+tarea).html('ACTIVO');
						$('#'+tarea).attr('class','btn btn-success');
					}
				});

			}
		}
	
		$(function() {

		    $(document).ready(function() {
				var $table = $('<table>').appendTo($('#hitos'));
		    	$table.attr('class','table table-bordered');
		    	var proyecto = 15;
		    	var hito = 1;
		    	var classBoton = "";
		    	var estado = "";
		    	
		    	$("#botonModal").click(function(){
			    	$('#hitos table').empty();
			    	$.get("HitosTareas", { hito : hito, proyecto : proyecto , operacion : "LISTAR"  }, function(responseJson){
		            	$('<tr>').appendTo($table)
	                        .append($('<th class="td-center">').text("Modulo"))
	                        .append($('<th class="td-center">').text("Tipo"))
	                        .append($('<th class="td-center">').text("Fecha Finalización"))
		            		.append($('<th class="td-center">').text("Estado"));
			    		$.each(responseJson, function(index, tareas) {
			    				if(tareas.enHito == true){
			    					classBoton = "btn btn-success";
			    					estado = "ACTIVO";
			    				}else{
			    					classBoton = "btn";
			    					estado = "INACTIVO";
			    				}
				            	$('<tr id="row">').appendTo($table)
				                        .append($('<td class="td-center">').text(tareas.modulo.descripcion))
				                        .append($('<td class="td-center">').text(tareas.tipo.descripcion))
				                        .append($('<td class="td-center">').text($.datepicker.formatDate('dd-mm-yy', new Date(tareas.fecha_fin))))
				            			.append($('<td class="td-center">').append('<a href="#" class="' + classBoton + '" id="'+tareas.id+'" onclick="agregar(\''+tareas.id+'\', \''+hito+'\');">'+estado+'</a>'));		            	
			    		});
					});
				});
			});
	   });
	</script>

	<a id="botonModal" data-toggle="modal" href="#example" class="btn btn-primary btn-large">Abrir ventana modal</a>
	<div id="example" class="modal hide fade in" style="display: none;">
	    <div class="modal-header">
	        <a data-dismiss="modal" class="close">×</a>
	        <h3>HITOS - TAREAS</h3>
		</div>
	    <div class="modal-body">
			<h5>TAREAS</h5>
			<div id="hitos">
			</div>
	    </div>
	    <div class="modal-footer">
	        <a href="#" data-dismiss="modal" class="btn btn-danger">Cerrar</a>
	    </div>
	</div>
<%@include file="tpl/footer.jsp" %>