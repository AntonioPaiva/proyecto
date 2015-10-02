<%@include file="tpl/header.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="py.consultoresinformaticos.DTO.*"%>
<% List<ModuloDTO> listaModulos = (List<ModuloDTO>) request.getAttribute("listaModulos");%>
<% List<ComponenteDTO> listaComponente = (List<ComponenteDTO>) request.getAttribute("listaComponente");%>
<% ModuloDTO modulo = (ModuloDTO) request.getAttribute("modulo"); %>
<% Iterator<ModuloDTO> it; %>
<% Iterator<ComponenteDTO> itComponente; %>
<% String operacion = (String)request.getAttribute("operacion"); %>

	<script>
	  $(function() {
		    var titulo = $('title').html();
		    $('title').html(titulo + " | Modulos");
		});
	  $(function() {
		    $('#datetimepicker1').datetimepicker({
		      language: 'es-Es'
		    });
		});
	</script>
	<form action="Modulo" method="post" onsubmit="return validarCamposModulo()"  class="form-horizontal">
			<h1 align="center">
				Módulos
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<!-- label for="id">ID#:</label -->
									<input type="hidden" name="id" id="id" value="<%= modulo == null ? "" : modulo.getId()%>" readonly="readonly"/>
								</div>
							</div>
						</div>
						<br>
						<label for="descripcionModulo">Descripción:</label>
						<input type="text" name="descripcionModulo" id="descripcionModulo" value="<%= modulo == null ? "" : modulo.getDescripcion()%>"/>
						<br>
						<br>
						<label for="comboComponente">Componente:</label>
						<select class="combobox" name="comboComponente" id="comboComponente">
							<%
		                       	if(listaComponente != null){
		                       		itComponente = listaComponente.iterator();
		                               while(itComponente.hasNext()){
		                               		ComponenteDTO c = itComponente.next();        
		                   	%>
											<option value="<%= c.getId()%>" <%=  modulo == null ? "" : (modulo.getComponente().getId() == c.getId() ? "selected=\"selected\"" : "")%> ><%= c.getProyecto().getDescripcion()+ " - " + c.getDescripcion()%></option>
									<% }
								 }%>
						</select>
							<input type="hidden" name="componenteModulo" id="componenteModulo" value="">
						<br>
						<label for="fechaCulmModulo">Fecha Culminación:</label>					
  							<div id="datetimepicker1" class="input-append date">
								<input type="text" data-format="yyyy-MM-dd" name="fechaCulmModulo" id="fechaCulmModulo" value="<%= modulo == null ? "" : modulo.getFechaCulm()%> " readonly="readonly"/>
								<span class="add-on">
							      <i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							    </span>
						 	</div>
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
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelarModulo();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span12">
						<table id="tablaModulos" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th class="td-center">Descripcion</th>
			                                        <th class="td-center">Componente</th>
			                                        <th class="td-center">Fecha Culminación</th>
			                                        <th class="td-center">Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                 <%
			                                if (listaModulos != null)
			                                { 
			                                	 it= listaModulos.iterator();  
			                                        while(it.hasNext()){
			                                                ModuloDTO a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getDescripcion() %>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getComponente().getDescripcion()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <%= a.getFechaCulm()%>
			                                                </span>
			                                        </td>
			                                        <td class="td-center">
			                                                <span>
			                                                <a href="Modulo?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarModulo(<%= a.getId()%>);"> Eliminar</a>
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