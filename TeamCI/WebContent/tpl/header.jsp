<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="py.consultoresinformaticos.DTO.LoginDTO"%>
<% LoginDTO usuarioLogeado = (LoginDTO) request.getSession().getAttribute("usuarioLogeado");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<link rel="shortcut icon" href="img/favicon.ico">
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/funciones.js"></script>
		
		<link href="css/style.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/estilos.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-combobox.css" media="screen"/>
		<!--link rel="stylesheet" type="text/css" href="css/combobox.css" media="screen"/-->
		<link href="css/prettify.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="js/jquery.fn.gantt.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-combobox.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
		<!--script type="text/javascript" src="js/combobox.js"></script-->
		<script src="js/prettify.js"></script>

	<title>TeamCI</title>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<div class="nav-collapse collapse">
						<div style="float: right;">
							<div class="btn-group">
							  <a id="usuarioMenu" class="btn btn-primary dropdown-toggle " data-toggle="dropdown" href="#">
							    <i class="icon-user icon-white"></i> <%= usuarioLogeado == null ? "Usuario" : usuarioLogeado.getUserName()  %>
							    <span class="caret"></span>
							  </a>
							  <ul class="dropdown-menu">
							    <li><a href="Configuracion"><i class="icon-wrench"></i> Configuracion</a></li>						    
							    <li><a href="CerrarSession"><i class="icon-off"></i> Cerrar Sesión</a></li>
							  </ul>
							</div>
						</div>
						<ul class="nav">
							<li><a href="index.jsp" style="color: white;"><i class="icon-home icon-white"></i> Inicio</a></li>
						</ul>

					    <ul class="nav navbar-nav">
      						<li class="dropdown">
					        <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white;"><i class="icon-list-alt icon-white"></i> Menu <b class="caret"></b></a>
					        <ul class="dropdown-menu">
								<li class="dropdown-submenu">
									<a tabindex="-1" href="#"><i class="icon-tags"></i> Datos Generales</a>
									<ul class="dropdown-menu">
										<li><a href="Rol"><i class="icon-user"></i> Roles</a></li>
								        <li class="divider"></li>								
										<li><a href="Usuario"><i class="icon-user"></i> Usuarios</a></li>
								        <li class="divider"></li>								
										<li><a href="Cliente"><i class="icon-user"></i> Clientes</a></li>
								        <li class="divider"></li>								
										<li><a href="TipoTarea"><i class="icon-text-width"></i> Tipo Tarea</a></li>       			
									</ul>
								</li>
						        <li class="divider"></li>
								<li class="dropdown-submenu">
									<a tabindex="-1" href="#"><i class="icon-tags"></i> Datos Proyectos</a>
									<ul class="dropdown-menu">
										<li><a href="Proyecto"><i class="icon-th-list"></i> Proyectos</a></li>
								        <li class="divider"></li>								
										<li><a href="Componente"><i class="icon-th"></i> Componentes</a></li>
								        <li class="divider"></li>								
										<li><a href="Modulo"><i class="icon-list-alt"></i> Módulos</a></li>
								        <li class="divider"></li>								
										<li><a href="ProyectoUsuario"><i class="icon-th-list"></i> Proyectos | Usuarios <i class="icon-user"></i></a></li>  			
									</ul>
								</li>						        
						        <li class="divider"></li>
								<li class="dropdown-submenu">
									<a tabindex="-1" href="#"><i class="icon-tags"></i> Datos Tareas</a>
									<ul class="dropdown-menu">
										<li><a href="Tarea"><i class="icon-edit"></i> Tareas</a></li>
								        <li class="divider"></li>								
										<li><a href="Actividad"><i class="icon-retweet"></i> Actividades</a></li>
								        <li class="divider"></li>								
										<li><a href="Hito"><i class="icon-map-marker"></i> Hitos</a></li>									
									</ul>
								</li>								        																			        
        					</ul>
      						</li>
    					</ul>
						<ul class="nav">
							<!--li><a href="cartagantt.jsp" style="color: white;"><i class="icon-indent-left icon-white"></i> Carta Gantt</a></li-->
							<li><a href="CartaGantt" style="color: white;"><i class="icon-indent-left icon-white"></i> Carta Gantt</a></li>							
						</ul>
					</div>
				</div>
			</div>	
		</div>
		<br>
		<br>
		<br>