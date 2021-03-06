<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<ActividadDTO> listaActividad = (List<ActividadDTO>) request.getAttribute("listaActividad");%>
<% String operacion = (String)request.getAttribute("operacion"); %>
<% ActividadDTO actividad = (ActividadDTO) request.getAttribute("actividad"); %>
<% Iterator<ActividadDTO> it; %>
	<form action="Actividad" method="post" onsubmit="return validarCamposActividad()"  class="form-horizontal">
			<h1 align="center">
				ACTIVIDADES
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="idActividad">ID#:</label-->
									<input type="hidden" name="id" id="id" value="<%= actividad == null ? "" : actividad.getId()%>" readonly="readonly"/>
								</div>
						</div>
						<br>
						<label for="descripcion">Descripción:</label>
						<input type="text" name="descripcion" id="descripcion" value="<%= actividad == null ? "" : actividad.getDescripcion()%>"/>
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarActividad();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span12">
						<table id="tablaActividad" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                		<th class="td-center">Responsable</th>
			                                        <th class="td-center">Descripción</th>
			                                       	<th class="td-center">Fecha</th>
			                                        <th class="td-center">Hora</th>
			                                        <th class="td-center">Proyecto</th>
			                                        <th class="td-center">Componente</th>
			                                        <th class="td-center">Modulo</th>			                                        			                                        
			                                </tr>
			                        </thead>
			                        <tbody>
			                                <%
			                                	if(listaActividad != null){
			                                		it = listaActividad.iterator();
			                                        while(it.hasNext()){
			                                        	ActividadDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getTarea().getUsuario().getNombre()+ " " + a.getTarea().getUsuario().getApellido() %>
			                                                </span>
			                                        </td>			                                
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getEstampa() %>
			                                                </span>
			                                        </td>			                                        
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getHora() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getTarea().getProyecto().getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getTarea().getModulo().getComponente().getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getTarea().getModulo().getDescripcion() %>
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