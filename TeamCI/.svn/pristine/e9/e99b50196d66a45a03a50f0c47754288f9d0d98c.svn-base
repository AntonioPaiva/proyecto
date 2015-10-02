<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<ProyectoDTO> listaProyecto = (List<ProyectoDTO>) request.getAttribute("listaProyecto");%>
<% List<HitoDTO> listaHitos = (List<HitoDTO>) request.getAttribute("listaHitos");%>
<% String operacion = (String)request.getAttribute("operacion");%>
<% HitoDTO hito = (HitoDTO) request.getAttribute("hito");%>
<% Iterator<HitoDTO> it;%>
<% Iterator<ProyectoDTO> itProyecto; %>
	<script>
	
		function agregar(tarea , hito) {
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
		
		function listarTareas(proyecto , hito, descripcion){
	    	var classBoton = "";
	    	var estado = "";
			var $table = $('#tareas table');
			$('#tituloHito').html('HITO - ' + descripcion);
	    	$('#tareas table').empty();
	    	$.get("HitosTareas", { hito : hito, proyecto : proyecto , operacion : "LISTAR"  }, function(responseJson){
	    		console.debug(responseJson);
            	$('<tr>').appendTo($table)
                    .append($('<th class="td-center">').text("Modulo"))
                    .append($('<th class="td-center">').text("Encargado"))
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
		                        .append($('<td class="td-center">').text(tareas.usuario.nombre + ' ' + tareas.usuario.apellido))
		                        .append($('<td class="td-center">').text(tareas.tipo.descripcion))
		                        .append($('<td class="td-center">').text($.datepicker.formatDate('dd-mm-yy', new Date(tareas.fecha_fin))))
		            			.append($('<td class="td-center">').append('<a href="#" class="' + classBoton + '" id="'+tareas.id+'" onclick="agregar(\''+tareas.id+'\', \''+hito+'\');">'+estado+'</a>'));		            	
	    		});
			});
		}
		
		$(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Hitos");
		    
		    
		    $(document).ready(function() {
		    	
		    	var $table = $('<table>').appendTo($('#tareas'));
		    	$table.attr('class','table table-bordered');
		    	/*
		    	$("#botonModal").click(function(){
			    	$('#tareas table').empty();
			    	$.get("HitosTareas", { hito : hito, proyecto : proyecto , operacion : "LISTAR"  }, function(responseJson){
					});
				});
				*/		    	
			});

	   });
	</script>
	<form action="Hito" method="post" onsubmit="return validarCamposHito()"  class="form-horizontal">
		<h1 align="center">
			HITOS
		</h1>
		<br>
		<div class="container">
			<div class="row">
				<div class="span10">
					<div class="container"><div class="row">
						<div class="span3">
							<input type="hidden" name="id" id="id" value="<%= hito == null ? "" : hito.getId()%>" readonly="readonly"/>
						</div>
					</div>
					<label for="comboProyecto">Proyecto:</label>
						<select class="combobox" name="comboProyecto" id="comboProyecto">
							<%
				               	if(listaProyecto != null){
				      	     		itProyecto = listaProyecto.iterator();
				                       while(itProyecto.hasNext()){
		                               	ProyectoDTO c = itProyecto.next();
				             %>
							<option value="<%= c.getId()%>" <%=  hito == null ? "" : (hito.getProyecto().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getDescripcion() %></option>
									<% }
								 }%>
						</select>
						<input type="hidden" name="proyecto" id="proyecto" value="">
					<br>
					</div>
				<label for="descripcion">Descripción:</label>
				<input type="text" name="descripcion" id="descripcion" value="<%= hito == null ? "" : hito.getDescripcion()%>"/>
				<label for="fechaInicio">Fecha:</label>				
				<div id="datetimepicker1" class="input-append date">
					<input type="text" data-format="yyyy-MM-dd" name="fecha" id="fecha" value="<%= hito == null ? "" : hito.getFecha()%>" readonly="readonly"/>
					<span class="add-on">
	      				<i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
	   				</span>
	 			</div>
			</div>
		</div>
	</div>
	<br>
	<div class="container">
		<div class="row">
			<div class="span10">
				<input type="submit" class="btn btn-primary" name="operacion" value="Agregar" <%= operacion == "Editar" ? "disabled=\"disabled\"" : ""%>/>
				<input type="submit" class="btn btn-success" name="operacion" value="Modificar" <%= operacion != "Editar" ? "disabled=\"disabled\"" : ""%>/>
				<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarHito();"/>
			</div>
		</div>
	</div>	
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="span8" id="hitos">
				<table id="tablaHitos" class="table table-bordered">
			    	<thead>
						<tr>
			            	<th class="td-center">Proyecto</th>
			                <th class="td-center">Descripcion</th>
			                <th class="td-center">Fecha</th>
			                <th class="td-center">Opciones</th>
                        </tr>
			        </thead>
			        <tbody>
			        	<%
                        	if (listaHitos != null){ 
                        		it = listaHitos.iterator();  
                                while(it.hasNext()){
                                	HitoDTO a = it.next();        
			            %>
						        <tr id="row">
						        	<td class="td-center">
						            	<span>
						                	<%= a.getProyecto().getDescripcion() %>
						                </span>
						            </td>
			                        <td class="td-center">
			                            <span>
			                            	<%= a.getDescripcion()%>
			                            </span>
			                        </td>
			                        <td class="td-center">
			                            <span>
			                            	<%= a.getFecha()%>
			                            </span>
			                        </td>
			                        <td class="td-center">
			                            <span>
			                            	<a href="Hito?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"><i class="icon-edit"></i></a>
			                            	 | 
			                            	<a href="#" onclick="eliminarHito(<%= a.getId()%>);"><i class="icon-trash"></i></a>
			                            	 | 
			                            	<a id="botonModal" data-toggle="modal" href="#example" onclick="listarTareas(<%= a.getProyecto().getId() + ", " + a.getId() + ", '" + a.getDescripcion() + "'" %>);"><i class="icon-plus"></i></a>
			                            </span>
			                        </td>
						        </tr>
			        	<%
			            		}
			            	}
			        	%>
			    	</tbody>
				</table>
			</div>
		</div>
	</div>
	</form>
	<div id="example" class="modal hide fade in" style="display: none; width: 800px; margin-left:-400px;">
	    <div class="modal-header">
	        <a data-dismiss="modal" class="close">×</a>
	        <h3 id="tituloHito">HITOS - TAREAS</h3>
		</div>
	    <div class="modal-body">
			<h5>TAREAS</h5>
			<div id="tareas">
			</div>
	    </div>
	    <div class="modal-footer">
	        <a href="#" data-dismiss="modal" class="btn btn-danger">Cerrar</a>
	    </div>
	</div>
<%@include file="tpl/footer.jsp" %>