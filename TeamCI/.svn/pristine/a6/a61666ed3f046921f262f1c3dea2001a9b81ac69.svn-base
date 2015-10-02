<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<ProyectoDTO> proyectos = (List<ProyectoDTO>) request.getAttribute("listaProyecto");%>
<% Iterator<ProyectoDTO> iterator; %>
	<div class="container">
		<div class="row">
			<div class="span10">
				<br>
				<label for="comboProyecto">Proyecto:</label>
				<select class="combobox" name="comboProyecto" id="comboProyecto">
						<option value=""><%= ""%></option>
					<%
	                      	if(proyectos != null){
	                      		iterator = proyectos.iterator();
	                              while(iterator.hasNext()){
	                              		ProyectoDTO c = iterator.next();
	                %>
									<option value="<%= c.getId()%>"><%= c.getDescripcion()%></option>
					<% 
								  }
						 	}
					%>
				</select>
				<input type="hidden" name="proyecto" id="proyecto" value="">
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="span12" id="cartaGantt">
				<div class="gantt"></div>
			</div>
		</div>
	</div>
  <script>
		function someFunc(tarea){
			console.debug("tarea : " + tarea);
			$('#detalleTarea p').empty();
	    	$.get("ConsultaAjax", { tarea : tarea , origen : "TAREAGANTT"  }, function(responseJson){
				$( "#detalleTarea" ).append( "<p>Proyecto : <b>" + responseJson.proyecto.descripcion + "</b></p>" +  
				"<p>Componente : <b>" + responseJson.modulo.componente.descripcion + "</b></p>" +
				"<p>Modulo : <b>" + responseJson.modulo.descripcion + "</b></p>" +
				"<p>Porcentaje de Avance : <b>(" + responseJson.avance + "%)</b></p>" +
				"<p>Encargado : <b>" + responseJson.usuario.nombre + " " + responseJson.usuario.apellido + "</b></p>");
			});
			$('#botonModal').click();
		}
  
		$(function() {
			
		    $('#comboProyecto').change(function(){
		    	var idProyecto = $('#comboProyecto').val();
		    	console.debug(idProyecto);
				
		    	$.get("ConsultaAjax", { origen: "GANTT", idProyecto : idProyecto }, function(responseJson){
					console.debug(responseJson);
					var json;
					var json2;
					var b = 1;
					$.each(responseJson, function(index, lista) {
						console.debug(lista.values.label);
						if(b==1){
							json = [{
								"name"   : lista.name,
								"desc"   : lista.desc,
								"values" : [{
									"from"  	  : lista.values.from,
									"to"    	  : lista.values.to,
									"label" 	  : lista.values.label,
									"customClass" : lista.values.customClass
								}]
							}];
							b=0;
						}else{
							json2 = [{
								"name"   : lista.name,
								"desc"   : lista.desc,
								"values" : [{
									"from"  	  : lista.values.from,
									"to"    	  : lista.values.to,
									"label" 	  : lista.values.label,
									"customClass" : lista.values.customClass
								}]
							}];
							json = json.concat(json2);
						}
						
					});
		    	
				"use strict";
				$(".gantt").gantt({
					source: json,
					navigate: "scroll",
					maxScale: "hours",
					itemsPerPage: 10,
					onRender: function() {
						if (window.console && typeof console.log === "function") {
							console.log("chart rendered");
						}
					}
				});
	
				$(".gantt").popover({
					selector: ".bar",
					title: "I'm a popover",
					content: "And I'm the content of said popover.",
					trigger: "hover"
				});
	
				prettyPrint();
		    	
		    	});
		    });
		    $('#comboProyecto').change();
		});
  </script>
  <a id="botonModal" data-toggle="modal" href="#example" style="display: none;"></a>
  <div id="example" class="modal hide fade in" style="display: none;">
	<div class="modal-header">
        <a data-dismiss="modal" class="close">×</a>
        <h3 id="tituloGantt">Carta Gantt</h3>
	</div>
	<div class="modal-body">
		<h5>Datos Generales</h5>
		<div id="detalleTarea">
		</div>
	</div>
	<div class="modal-footer">
	    <a href="#" data-dismiss="modal" class="btn btn-danger">Cerrar</a>
	</div>
  </div>  
<%@include file="tpl/footer.jsp" %>  