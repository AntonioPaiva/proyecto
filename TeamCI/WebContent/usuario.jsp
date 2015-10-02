<%@include file="tpl/header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<% List<UsuarioDTO> listaUsuarios = (List<UsuarioDTO>) request.getAttribute("listaUsuarios");%>
<% UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario"); %>
<% Iterator<UsuarioDTO> it; %>
<% String operacion = (String)request.getAttribute("operacion"); %>

	<script>
	  $(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Usuarios");
		});
	  $(function() {
		    $('#datetimepicker1').datetimepicker({
		      language: 'es-Es'
		    });
		});
	</script>
	<form action="Usuario" method="post" onsubmit="return validarCamposUsuario()"  class="form-horizontal">
			<h1 align="center">
				Usuarios
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="id">ID#</label -->
									<input type="hidden" name="id" id="id" value="<%= usuario == null ? "" : usuario.getId()%>" readonly="readonly"/>
								</div>
							</div>
						</div>
						<br>
						<label for="nombreUsuario">Nombre</label>
						<input type="text" name="nombreUsuario" id="nombreUsuario" value="<%= usuario == null ? "" : usuario.getNombre() %>"/>
						<br>
						<label for="apellidoUsuario">Apellido</label>
						<input type="text" name="apellidoUsuario" id="apellidoUsuario" value="<%= usuario == null ? "" : usuario.getApellido()%> "/>
						<br>
						<label for="userNameUsuario">Username</label>
						<input type="text" name="userNameUsuario" id="userNameUsuario" value="<%= usuario == null ? "" : usuario.getUsername()%> "/>
						<br>
						<label for="passwordUsuario">Password</label>
						<input type="text" name="passwordUsuario" id="passwordUsuario" value="<%= usuario == null ? "" : usuario.getPassword()%> "/>
						<br>
						<label for="fotoUsuario">Foto</label>
						<input type="text" name="fotoUsuario" id="fotoUsuario" value="<%= usuario == null ? "" : usuario.getFoto()%> "/>
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarUsuario();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span12">
						<table id="tablaUsuarios" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Nombre</th>
			                                        <th class="td-center">Apellido</th>
			                                        <th class="td-center">Usuario</th>
			                                        <th class="td-center">Passwrod</th>
			                                        <th class="td-center">Foto</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                 <%
			                                if (listaUsuarios != null)
			                                { 
			                                	 it= listaUsuarios.iterator();  
			                                        while(it.hasNext()){
			                                                UsuarioDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getNombre() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getApellido()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getUsername()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getPassword()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getFoto()%>
			                                                </span>
			                                        </td>			                                        
			                                        <td class="td-center">
			                                                <span>
			                                                <a href="Usuario?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarUsuario(<%= a.getId()%>);"> Eliminar</a>
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