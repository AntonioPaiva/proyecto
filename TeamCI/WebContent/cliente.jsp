<%@include file="tpl/header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<% List<ClienteDTO> listaClientes = (List<ClienteDTO>) request.getAttribute("listaClientes");%>
<% ClienteDTO cliente = (ClienteDTO) request.getAttribute("cliente"); %>
<% Iterator<ClienteDTO> it; %>
<% String operacion = (String)request.getAttribute("operacion"); %>

	<script>
	  $(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Clientes");
	   });
	</script>
	<form action="Cliente" method="post" onsubmit="return validarCamposCliente()"  class="form-horizontal">
			<h1 align="center">
				Clientes
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="id">ID#</label -->
									<input type="hidden" name="id" id="id" value="<%= cliente == null ? "" : cliente.getId()%>" readonly="readonly"/>
								</div>
							</div>
						</div>
						<br>
						<label for="nombreCliente">Nombre</label>
						<input type="text" name="nombreCliente" id="nombreCliente" value="<%= cliente == null ? "" : cliente.getDescripcion() %>"/>
						<br>
						<label for="direccionCliente">Dirección</label>
						<input type="text" name="direccionCliente" id="direccionCliente" value="<%= cliente == null ? "" : cliente.getDireccion()%> "/>
						<br>
						<label for="telefonoCliente">Telefono</label>
						<input type="text" name="telefonoCliente" id="telefonoCliente" value="<%= cliente == null ? "" : cliente.getTelefono()%> "/>
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarCliente();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span12">
						<table id="tablaClientes" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Nombre</th>
			                                        <th class="td-center">Dirección</th>
			                                        <th class="td-center">Telefono</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                 <%
			                                if (listaClientes != null)
			                                { 
			                                	 it= listaClientes.iterator();  
			                                        while(it.hasNext()){
			                                                ClienteDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getDireccion()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getTelefono()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <a href="Cliente?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarCliente(<%= a.getId()%>);"> Eliminar</a>
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