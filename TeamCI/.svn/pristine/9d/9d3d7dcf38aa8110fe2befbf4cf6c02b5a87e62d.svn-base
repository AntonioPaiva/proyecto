<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<TareaDTO> listaTarea = (List<TareaDTO>) request.getAttribute("listaTarea");%>
<% List<ModuloDTO> listaModulo = (List<ModuloDTO>) request.getAttribute("listaModulo");%>
<% List<ProyectoDTO> listaProyecto = (List<ProyectoDTO>) request.getAttribute("listaProyecto");%>
<% List<UsuarioDTO> listaUsuario = (List<UsuarioDTO>) request.getAttribute("listaUsuario");%>
<% List<TipoDTO> listaTipo = (List<TipoDTO>) request.getAttribute("listaTipo");%>
<% String operacion = (String)request.getAttribute("operacion"); %>
<% TareaDTO tarea = (TareaDTO) request.getAttribute("tarea"); %>
<% Iterator<TareaDTO> it; %>
<% Iterator<ModuloDTO> itModulo; %>
<% Iterator<ProyectoDTO> itProyecto; %>
<% Iterator<UsuarioDTO> itUsuario; %>
<% Iterator<TipoDTO> itTipo; %>

	<script type="text/javascript">
		$(document).ready(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Tareas");
		    
		    $('#comboProyecto').change(function(){
		    	$('#comboModulo').empty();
		    	var idProyecto = $('#comboProyecto').val();
				$.get("ConsultaAjax", { origen: "TAREAS" }, function(responseJson){
					$.each(responseJson, function(index, modulos) {						
						var proyecto = modulos.componente.proyecto.id;
						if(proyecto == idProyecto){
							var texto = modulos.componente.descripcion + " - " + modulos.descripcion;
							var valor = modulos.id;
							console.debug("valor: " + valor);
							$('#comboModulo').append(new Option(texto, valor, false, false));
						}
				    });
					$('#comboModulo').data('combobox').refresh();
				});
		    });
		});
	</script>

	<form action="Tarea" method="post" onsubmit="return validarCamposTarea()"  class="form-horizontal">
			<h1 align="center">
				TAREAS
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="idTarea">ID#:</label-->
									<input type="hidden" name="id" id="id" value="<%= tarea == null ? "" : tarea.getId()%>" readonly="readonly"/>
								</div>
						</div>
						<br>
						<label for="comboProyecto">Proyecto:</label>
						<select class="combobox" name="comboProyecto" id="comboProyecto">
						<%
							if(listaProyecto != null){
	                       			itProyecto = listaProyecto.iterator();
	                               	while(itProyecto.hasNext()){
	                               		ProyectoDTO c = itProyecto.next();        
		                   	%>
											<option value="<%= c.getId()%>" <%=  tarea == null ? "" : (tarea.getProyecto().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getDescripcion()%></option>
									<% }
								 }%>
						</select>
						<input type="hidden" name="proyecto" id="proyecto" value="">
						<br>
						<label for="comboModulo">Modulo:</label>
						<select class="combobox" name="comboModulo" id="comboModulo">
								<%
									if(listaModulo != null && operacion == "Editar"){
		                       			itModulo = listaModulo.iterator();
		                               	while(itModulo.hasNext()){
		                            	   ModuloDTO c = itModulo.next();
		                            	   		if(c.getComponente().getProyecto().getId() == tarea.getProyecto().getId()){
			                   	%>
										   			<option value="<%= c.getId()%>" <%=  tarea == null ? "" : (tarea.getModulo().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getComponente().getDescripcion() + " - " + c.getDescripcion() %></option>
								<% 				}
										}
									}
								%>		
						</select>
						<input type="hidden" name="modulo" id="modulo" value="">
						<br>							
						<label for="comboTipo">Tipo:</label>
						<select class="combobox" name="comboTipo" id="comboTipo">
						<%
							if(listaTipo != null){
	                       			itTipo = listaTipo.iterator();
	                               	while(itTipo.hasNext()){
	                               		TipoDTO c = itTipo.next();        
		                   	%>
											<option value="<%= c.getId()%>" <%=  tarea == null ? "" : (tarea.getTipo().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getDescripcion()%></option>
									<% }
								 }%>
						</select>
						<input type="hidden" name="tipo" id="tipo" value="">
						<br>
						<label for="comboUsuario">Usuario:</label>
						<select class="combobox" name="comboUsuario" id="comboUsuario">
						<%
							if(listaUsuario != null){
	                       			itUsuario = listaUsuario.iterator();
	                               	while(itUsuario.hasNext()){
	                               		UsuarioDTO c = itUsuario.next();        
		                   	%>
											<option value="<%= c.getId()%>" <%=  tarea == null ? "" : (tarea.getUsuario().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getNombre()%></option>
									<% }
								 }%>
						</select>
						<input type="hidden" name="usuario" id="usuario" value="">
						<br>
						<label name="fechaIni">Fecha Inicio:</label>					
  							<div id="datetimepicker1" class="input-append date">
								<input type="text" data-format="yyyy-MM-dd" name="fecha_ini" id="fecha_ini" value="<%= tarea == null ? "" : tarea.getFecha_ini()%>" readonly="readonly"/>
								<span class="add-on">
							      <i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							    </span>
						  </div>
						<br>
						<label name="fechaFin">Fecha Fin:</label>					
  							<div id="datetimepicker2" class="input-append date">
								<input type="text" data-format="yyyy-MM-dd" name="fecha_fin" id="fecha_fin" value="<%= tarea == null ? "" : tarea.getFecha_fin()%>" readonly="readonly"/>
								<span class="add-on">
							      <i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							    </span>
						  </div>
						<br>
						<label name="fechaFin">Fecha Culminacion:</label>					
  							<div id="datetimepicker3" class="input-append date">
								<input type="text" data-format="yyyy-MM-dd" name="fecha_culm" id="fecha_culm" value="<%= tarea == null ? "" : tarea.getFecha_culm()%>" readonly="readonly"/>
								<span class="add-on">
							      <i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							    </span>
						  </div>
						<br>
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarTarea();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span12">
						<table id="tablaTarea" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Proyecto</th>
			                                        <th class="td-center">Modulo</th>
			                                        <th class="td-center">Tipo</th>
			                                        <th class="td-center">Usuario</th>
			                                        <th class="td-center">Fecha Inicio</th>
			                                        <th class="td-center">Fecha Fin</th>
			                                        <th class="td-center">Fecha Culminacion</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                <%
			                                	if(listaTarea != null){
			                                		it = listaTarea.iterator();
			                                        while(it.hasNext()){
			                                               TareaDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                             <span>
			                                                <%= a.getProyecto().getDescripcion() %>
			                                             </span>
			                                        </td>
			                                        <td class="td-center">
			                                             <span>
			                                                <%= a.getModulo().getDescripcion() %>
			                                             </span>
			                                        </td>
			                                        <td class="td-center">
			                                             <span>
			                                                <%= a.getTipo().getDescripcion() %>
			                                             </span>
			                                        </td>
			                                        <td class="td-center">
			                                             <span>
			                                                <%= a.getUsuario().getNombre() + " " + a.getUsuario().getApellido() %>
			                                             </span>
			                                        </td>
			                                        <td class="td-center">
			                                             <span>
			                                                <%= a.getFecha_ini() %>
			                                             </span>
			                                        </td>
			                                        <td class="td-center">
			                                             <span>
			                                                <%= a.getFecha_fin() %>
			                                             </span>
			                                        </td>
			                                        <td class="td-center">
			                                              <span>
			                                             	  <%= a.getFecha_culm() %>
			                                              </span>
			                                        </td>
			                                        <td class="td-center">
			                                              <span>
			                                                <a href="Tarea?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarTarea(<%= a.getId()%>);"> Eliminar</a>
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
			<br>
	</form>
		<script type="text/javascript">
			  $(function() {
			    $('#datetimepicker1').datetimepicker({
			      language: 'es-Es'
			    });
			    $('#datetimepicker2').datetimepicker({
				      language: 'es-Es'
				    });
			    $('#datetimepicker3').datetimepicker({
				      language: 'es-Es'
				    });
			  });	  
		</script>
<%@include file="tpl/footer.jsp" %>