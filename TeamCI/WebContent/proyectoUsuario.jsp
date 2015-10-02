<%@include file="tpl/header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<% List<ProyectoUsuarioDTO> listaProyectoUsuarios = (List<ProyectoUsuarioDTO>) request.getAttribute("listaProyectoUsuarios");%>
<% List<ProyectoDTO> listaProyecto = (List<ProyectoDTO>) request.getAttribute("listaProyecto");%>
<% List<UsuarioDTO> listaUsuario = (List<UsuarioDTO>) request.getAttribute("listaUsuario");%>
<% List<RolDTO> listaRol = (List<RolDTO>) request.getAttribute("listaRol");%>
<% ProyectoUsuarioDTO proyectoUsuario = (ProyectoUsuarioDTO) request.getAttribute("proyectoUsuario"); %>
<% Iterator<ProyectoUsuarioDTO> it; %>
<% Iterator<ProyectoDTO> itProyecto; %>
<% Iterator<UsuarioDTO> itUsuario; %>
<% Iterator<RolDTO> itRol; %>
<% String operacion = (String)request.getAttribute("operacion"); %>

	<script>
	  $(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Proyectos-Usuarios");
		});
	  $(function() {
		    $('#datetimepicker1').datetimepicker({
		      language: 'es-Es'
		    });
		});
	</script>
	<form action="ProyectoUsuario" method="post" onsubmit="return validarCamposProyectoUsuarios()"  class="form-horizontal">
			<h1 align="center">
				Proyectos - Usuarios
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<label for="comboProyecto">Proyecto</label>
									<select class="combobox" name="comboProyecto" id="comboProyecto">
										<%
											if(listaProyecto != null){
					                       			itProyecto = listaProyecto.iterator();
					                               	while(itProyecto.hasNext()){
					                               		ProyectoDTO c = itProyecto.next();        
						                   	%>
															<option value="<%= c.getId()%>" <%=  proyectoUsuario == null ? "" : (proyectoUsuario.getProyecto().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getDescripcion()%></option>
													<% }
												 }%>
									</select>
									<input type="hidden" name="idProyecto" id="idProyecto" value="">
								</div>
							</div>
						</div>
						<br>
						<label for="comboUsuario">Usuario</label>
						<select class="combobox" name="comboUsuario" id="comboUsuario">
						<%
							if(listaUsuario != null){
	                       			itUsuario = listaUsuario.iterator();
	                               	while(itUsuario.hasNext()){
	                               		UsuarioDTO c = itUsuario.next();        
		                   	%>
											<option value="<%= c.getId()%>" <%=  proyectoUsuario == null ? "" : (proyectoUsuario.getUsuario().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getNombre()%></option>
									<% }
								 }%>
						</select>
						<input type="hidden" name="idUsuario" id="idUsuario" value="">
						<br>
						<label for="comboRol">Rol</label>
						<select class="combobox" name="comboRol" id="comboRol">
							<%
								if(listaRol != null){
		                       			itRol = listaRol.iterator();
		                               	while(itRol.hasNext()){
		                               		RolDTO c = itRol.next();        
			                   	%>
												<option value="<%= c.getId()%>" <%=  proyectoUsuario == null ? "" : (proyectoUsuario.getRol().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getDescripcion()%></option>
										<% }
									 }%>
						</select>
						<input type="hidden" name="idRol" id="idRol" value="">
						<br>
					</div>
				</div>
			</div>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
							<input type="submit" class="btn btn-primary" name="operacion" value="Agregar" <%= operacion == "Editar" ? "disabled=\"disabled\"" : ""%>/>
							<input type="submit" class="btn btn-success" name="operacion" value="Modificar" <%= operacion != "Editar" ? "disabled=\"disabled\"" : ""%>/>
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarProyectoUsuario();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span12">
						<table id="tablaProyectoUsuarios" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Proyecto</th>
			                                        <th class="td-center">Usuario</th>
			                                        <th class="td-center">Rol</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                 <%
			                                if (listaProyectoUsuarios != null)
			                                { 
			                                	 it= listaProyectoUsuarios.iterator();  
			                                        while(it.hasNext()){
			                                                ProyectoUsuarioDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                        		<span>
			                                                <%= a.getProyecto().getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getUsuario().getNombre() +" " + a.getUsuario().getApellido() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getRol().getDescripcion() %>
			                                                </span>
			                                        </td>			                                        
			                                        <td class="td-center">
			                                                <span>
			                                                <a href="ProyectoUsuario?operacion=Editar&idProyecto=<%= a.getProyecto().getId() %>&idUsuario=<%= a.getUsuario().getId() %> "> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarProyectoUsuario(<%= a.getProyecto().getId()%>, <%= a.getUsuario().getId()%>);"> Eliminar</a>
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