<%@include file="tpl/header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<% List<RolDTO> listaRoles = (List<RolDTO>) request.getAttribute("listaRoles");%>
<% RolDTO rol = (RolDTO) request.getAttribute("rol"); %>
<% Iterator<RolDTO> it; %>
<% String operacion = (String)request.getAttribute("operacion"); %>

	<script type="text/javascript">
	  $(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Roles");
		});
	  $(function() {
		    $('#datetimepicker1').datetimepicker({
		      language: 'es-Es'
		    });
		});
	</script>
	<form action="Rol" method="post" onsubmit="return validarCamposRol()"  class="form-horizontal">
			<h1 align="center">
				Roles
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!--label for="id">ID#</label-->
									<input type="hidden" name="id" id="id" value="<%= rol == null ? "" : rol.getId()%>" readonly="readonly"/>
								</div>
							</div>
						</div>
						<br>
						<label for="descripcionRol">Descripción</label>
						<input type="text" name="descripcionRol" id="descripcionRol" value="<%= rol == null ? "" : rol.getDescripcion() %>"/>
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarRol();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span5">
						<table id="tablaModulos" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Descripcion</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                 <%
			                                if (listaRoles != null)
			                                { 
			                                	 it= listaRoles.iterator();  
			                                        while(it.hasNext()){
			                                                RolDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <a href="Rol?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarRol(<%= a.getId()%>);"> Eliminar</a>
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