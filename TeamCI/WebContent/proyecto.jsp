<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<ProyectoDTO> listaProyecto = (List<ProyectoDTO>) request.getAttribute("listaProyecto");%>
<% List<ClienteDTO> listaClientes = (List<ClienteDTO>) request.getAttribute("listaClientes");%>
<% String operacion = (String)request.getAttribute("operacion"); %>
<% ProyectoDTO proyecto = (ProyectoDTO) request.getAttribute("proyecto"); %>
<% Iterator<ProyectoDTO> it; %>
<% Iterator<ClienteDTO> itCliente; %>
	<script>
	  $(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Proyectos");
	   });
	</script>
	<form action="Proyecto" method="post" onsubmit="return validarCamposProyecto()"  class="form-horizontal">
			<h1 align="center">
				PROYECTOS
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="id">ID#:</label-->
									<input type="hidden" name="id" id="id" value="<%= proyecto == null ? "" : proyecto.getId()%>" readonly="readonly"/>
								</div>
						</div>
						<br>
						<label for="descripcion">Descripción:</label>
						<input type="text" name="descripcion" id="descripcion" value="<%= proyecto == null ? "" : proyecto.getDescripcion()%>"/>
						<br>
						<label name="fechaInicio">Fecha Inicio:</label>				
  							<div id="datetimepicker1" class="input-append date">
								<input type="text" data-format="yyyy-MM-dd" name="fechaInicio" id="fechaInicio" value="<%= proyecto == null ? "" : proyecto.getFechaInicio()%>" readonly="readonly"/>
								<span class="add-on">
							      <i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							    </span>
						  </div>
						 <br>
						<label name="fechaFin">Fecha Fin:</label>					
  							<div id="datetimepicker2" class="input-append date">
								<input type="text" data-format="yyyy-MM-dd" name="fechaFin" id="fechaFin" value="<%= proyecto == null ? "" : proyecto.getFechaFin()%> "readonly="readonly"/>
								<span class="add-on">
							      <i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							    </span>
						  </div>
						<br>
						 
						<label for="comboCliente">Cliente:</label>
						<!-- 
						<input type="text" name="cliente" id="cliente" value="<%= proyecto == null ? "" : proyecto.getCliente()%> "/>
						-->
					
							<select class="combobox" name="comboCliente" id="comboCliente">
										<%
					                       	if(listaClientes != null){
					                       		itCliente = listaClientes.iterator();
					                               while(itCliente.hasNext()){
					                               		ClienteDTO c = itCliente.next();        
					                   	%>
														<option value="<%= c.getId()%>" <%=  proyecto == null ? "" : (proyecto.getCliente().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getDescripcion()%></option>
												<% }
											 }%>
							</select>
							<input type="hidden" name="cliente" id="cliente" value="">
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarProyecto();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span10">
						<table id="tablaProyectos" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Descripcion</th>
			                                        <th class="td-center">Fecha Inicio</th>
			                                        <th class="td-center">Fecha Fin</th>
			                                        <th class="td-center">Cliente</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                <%
			                                	if(listaProyecto != null){
			                                		it = listaProyecto.iterator();
			                                        while(it.hasNext()){
			                                                ProyectoDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getFechaInicio()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getFechaFin()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getCliente().getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        
			                                        <td class="td-center">
			                                                <span>
			                                                <a href="Proyecto?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarProyecto(<%= a.getId()%>);"> Eliminar</a>
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
<%@include file="tpl/footer.jsp" %>
