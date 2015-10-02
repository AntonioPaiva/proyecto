<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<ComponenteDTO> listaComponente = (List<ComponenteDTO>) request.getAttribute("listaComponente");%>
<% List<ProyectoDTO> listaProyecto = (List<ProyectoDTO>) request.getAttribute("listaProyecto");%>
<% String operacion = (String)request.getAttribute("operacion"); %>
<% ComponenteDTO componente = (ComponenteDTO) request.getAttribute("componente"); %>
<% Iterator<ComponenteDTO> it; %>
<% Iterator<ProyectoDTO> itProyecto; %>
	<script>
	  $(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Componentes");
	   });
	</script>
	<form action="Componente" method="post" onsubmit="return validarCamposComponente()"  class="form-horizontal">
			<h1 align="center">
				COMPONENTES
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="idComponente">ID#:</label-->
									<input type="hidden" name="id" id="id" value="<%= componente == null ? "" : componente.getId()%>" readonly="readonly"/>
								</div>
						</div>
						<br>
						<label for="descripcion">Descripción:</label>
						<input type="text" name="descripcion" id="descripcion" value="<%= componente == null ? "" : componente.getDescripcion()%>"/>
						<br>
						<label for="comboProyecto">Proyecto:</label>
						<select class="combobox" name="comboProyecto" id="comboProyecto">
							<%
		                       	if(listaProyecto != null){
		                       		itProyecto = listaProyecto.iterator();
		                               while(itProyecto.hasNext()){
		                               		ProyectoDTO c = itProyecto.next();        
		                   	%>
											<option value="<%= c.getId()%>" <%=  componente == null ? "" : (componente.getProyecto().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getDescripcion()%></option>
									<% }
								 	}%>
							</select>
							<input type="hidden" name="proyecto" id="proyecto" value="">
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarComponente();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span10">
						<table id="tablaComponente" class="table table-bordered">
	                        <thead>
	                                <tr>
	                                        <th class="td-center">Descripcion</th>
	                                        <th class="td-center">Proyecto</th>
	                                        <th class="td-center">Opciones</th>
	                                </tr>
	                        </thead>
		                        <tbody>
		                                <%
		                                	if(listaComponente != null){
		                                		it = listaComponente.iterator();
		                                        while(it.hasNext()){
		                                                ComponenteDTO a = it.next();        
		                                %>
		                                <tr id="row">
		                                        <td class="td-center">
		                                              <span>
		                                              	<%= a.getDescripcion() %>
		                                              </span>
		                                        </td>
		                                        <td class="td-center">
		                                              <span>
		                                                <%= a.getProyecto().getDescripcion() %>
		                                              </span>
		                                        </td>
		                                        
		                                        <td class="td-center">
		                                              <span>
		                                                <a href="Componente?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
		                                                |
		                                                <a href="#" onclick="eliminarComponente(<%= a.getId()%>);"> Eliminar</a>
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