<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<TipoDTO> listaTipo = (List<TipoDTO>) request.getAttribute("listaTipo");%>
<% String operacion = (String)request.getAttribute("operacion"); %>
<% TipoDTO tipo = (TipoDTO) request.getAttribute("tipo"); %>
<% Iterator<TipoDTO> it; %>
	<form action="TipoTarea" method="post" onsubmit="return validarCamposTipoTarea()"  class="form-horizontal">
			<h1 align="center">
				TIPOS
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="idTIPO">ID#:</label-->
									<input type="hidden" name="id" id="id" value="<%= tipo == null ? "" : tipo.getId()%>" readonly="readonly"/>
								</div>
						</div>
						<br>
						<label for="descripcion">Descripción:</label>
						<input type="text" name="descripcion" id="descripcion" value="<%= tipo == null ? "" : tipo.getDescripcion()%>"/>
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarTipo();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span5">
						<table id="tablaTIPO" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Descripcion</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                <%
			                                	if(listaTipo != null){
			                                		it = listaTipo.iterator();
			                                        while(it.hasNext()){
			                                                TipoDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <a href="TipoTarea?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarTipo(<%= a.getId()%>);"> Eliminar</a>
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