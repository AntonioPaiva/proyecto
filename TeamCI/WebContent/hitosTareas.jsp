<%@include file="tpl/header.jsp" %>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<%@page import="py.consultoresinformaticos.DAO.impl.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% List<ProyectoDTO> listaProyecto = (List<ProyectoDTO>) request.getAttribute("listaProyecto");%>
<% List<ComponenteDTO> listaComponentes = (List<ComponenteDTO>) request.getAttribute("listaComponentes");%>
<%
	List<HitoDTO> listaHitos = (List<HitoDTO>) request.getAttribute("listaHitos ");
%>
<%
	List<TareaDTO> listaTarea = (List<TareaDTO>) request.getAttribute("listaTarea");
%>
<%
	HitoDTO hitos = (HitoDTO) request.getAttribute("hitos");
%>
<%
	Iterator<HitoDTO> it;
%>
<%
	Iterator<ProyectoDTO> itProyecto;
%>
<%
	Iterator<ComponenteDTO> itComponentes;
%>
<form action="Tarea" method="post" onsubmit="return validarCamposTarea()"  class="form-horizontal">
	<h1 align="center">
		HITOS-TAREAS
	</h1>
	<br>
	<div class="container">
		<div class="row">
			<div class="span10">
				<div class="container">
					<div class="row">
						<div class="span3">
							<!-- label for="idTarea">ID#:</label-->
							<input type="hidden" name="id" id="id" value="<%=hitos == null ? "" : hitos.getId()%>" readonly="readonly"/>
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
											<option value="<%=c.getId()%>" <%=hitos == null ? "" : (hitos.getProyecto().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%=c.getDescripcion()%></option>
									<%
										}
															 }
									%>
					</select>
					<input type="hidden" name="proyecto" id="proyecto" value="">
					<br>
					<label for="comboComponente">Componente:</label>
					<select class="combobox" name="comboComponente" id="comboComponente">
						<%
							if(listaComponentes != null){
							                       			itComponentes = listaComponentes.iterator();
							                               	while(itComponentes.hasNext()){
							                               		ComponenteDTO c = itComponentes.next();
						%>
											<option value="<%=c.getId()%>" <%=hitos == null ? "" : (hitos.getProyecto().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%=c.getDescripcion()%></option>
									<%
										}
															 }
									%>
					</select>
					<input type="hidden" name="proyecto" id="proyecto" value="">
					<br>
					<label for="descripcion">Descripción:</label>
					<input type="text" name="descripcion" id="descripcion" value="<%=hitos == null ? "" : hitos.getDescripcion()%>"/>
					<br>
					<label name="fechaIni">Fecha:</label>					
 							<div id="datetimepicker1" class="input-append date">
							<input type="text" data-format="yyyy-MM-dd" name="fecha_ini" id="fecha_ini" value="<%=hitos == null ? "" : hitos.getFecha()%>" readonly="readonly"/>
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
		<div class="span12">
			<table id="tablaTarea" class="table table-bordered">
            	<thead>
                <tr>
                    <th class="td-center">Proyecto</th>
                    <th class="td-center">Componente</th>
                    <th class="td-center">Descripcion</th>
                    <th class="td-center">Fecha</th>
                    <th class="td-center">Opciones</th>
                 </tr>
                 </thead>
                 <tbody>
                       <%
                       	if(listaHitos != null){
                                              		it = listaHitos.iterator();
                                                      while(it.hasNext()){
                                                             HitoDTO a = it.next();
                       %>
                      <tr id="row">
                          <td class="td-center">
                          	<span>
                                  <%= a.getProyecto().getDescripcion() %>
                            </span>
                          </td>
                          <td class="td-center">
                            <span>
                                  <%= a.getDescripcion() %>
                            </span>
                          </td>
                          <td class="td-center">
                          	<span>
                                <%= a.getFecha() %>
                          	</span>
                          </td>
                          <td class="td-center">
                                    <span>
                                      <a href="Tarea?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
                                      |
                                      <a href="#" onclick="eliminarHitos(<%= a.getId()%>);"> Eliminar</a>
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
</form>
<%@include file="tpl/footer.jsp" %>