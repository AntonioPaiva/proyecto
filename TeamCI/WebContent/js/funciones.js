function validarCamposCliente() 
{
	var nombreCliente    = document.getElementById("nombreCliente").value;
	var telefonoCliente  = document.getElementById("telefonoCliente").value;
	var direccionCliente = document.getElementById("direccionCliente").value;

	if(nombreCliente == "" ||
			telefonoCliente == "" || direccionCliente == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposHito() 
{
	document.getElementById("proyecto").value = document.getElementById("comboProyecto").value;
	var proyectoHito    = document.getElementById("proyecto").value;
	var descripcionHito  = document.getElementById("descripcion").value;
	var fechaHito = document.getElementById("fecha").value;

	if(proyectoHito == "" || descripcionHito == "" || fechaHito == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposModulo() 
{
	document.getElementById("componenteModulo").value = document.getElementById("comboComponente").value;
	var nombreModulo    = document.getElementById("descripcionModulo").value;
	var componenteModulo  = document.getElementById("componenteModulo").value;
	var fechaCulmModulo = document.getElementById("fechaCulmModulo").value;

	if(nombreModulo == "" || componenteModulo == "" || fechaCulmModulo == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposUsuario() 
{
	
	var nombreUsuario    = document.getElementById("nombreUsuario").value;
	var apellidoUsuario  = document.getElementById("apellidoUsuario").value;
	var userNameUsuario = document.getElementById("userNameUsuario").value;
	var passwordUsuario = document.getElementById("passwordUsuario").value;
	var fotoUsuario = document.getElementById("fotoUsuario").value;

	if(nombreUsuario == "" || apellidoUsuario == "" || userNameUsuario == ""
		|| passwordUsuario == "" || fotoUsuario == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposRol() 
{
	var descripcionRol    = document.getElementById("descripcionRol").value;

	if(descripcionRol == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposProyectoUsuarios() 
{
	document.getElementById("idProyecto").value = document.getElementById("comboProyecto").value;
	document.getElementById("idUsuario").value = document.getElementById("comboUsuario").value;
	document.getElementById("idRol").value = document.getElementById("comboRol").value;
	var idProyecto    = document.getElementById("idProyecto").value;
	var idUsuario    = document.getElementById("idUsuario").value;
	var idRol    = document.getElementById("idRol").value;

	if(idProyecto == "" || idUsuario == "" || idRol == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposTipoTarea() 
{
	var descripcion    = document.getElementById("descripcion").value;

	if(descripcion == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposComponente() 
{
	document.getElementById("proyecto").value = document.getElementById("comboProyecto").value;
	var descripcion	= document.getElementById("descripcion").value;
	var proyecto	= document.getElementById("proyecto").value;

	if(descripcion == "" || proyecto == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}


function validarCamposProyecto() 
{
	document.getElementById("cliente").value = document.getElementById("comboCliente").value;
	var descripcion	= document.getElementById("descripcion").value;
	var fechaInicio	= document.getElementById("fechaInicio").value;
	var fechaFin	= document.getElementById("fechaFin").value;
	var cliente	= document.getElementById("cliente").value;

	if(descripcion == "" || fechaInicio == "" || fechaFin == "" || cliente == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposTarea() 
{
	document.getElementById("modulo").value = document.getElementById("comboModulo").value;
	document.getElementById("proyecto").value = document.getElementById("comboProyecto").value;
	document.getElementById("usuario").value = document.getElementById("comboUsuario").value;
	document.getElementById("tipo").value = document.getElementById("comboTipo").value;
	
	var modulo	= document.getElementById("modulo").value;
	var proyecto	= document.getElementById("proyecto").value;
	var usuario	= document.getElementById("usuario").value;
	var tipo	= document.getElementById("tipo").value;
	var fecha_ini	= document.getElementById("fecha_ini").value;
	var fecha_fin	= document.getElementById("fecha_fin").value;
	var fecha_culm	= document.getElementById("fecha_culm").value;

	if(modulo == "" || proyecto == "" || usuario == "" || tipo == "" || fecha_ini == "" || fecha_fin == "" || fecha_culm == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function validarCamposActividad() 
{
	var descripcion	= document.getElementById("descripcion").value;
	var hora	= document.getElementById("hora").value;
	var tarea	= document.getElementById("tarea").value;
	var foto	= document.getElementById("foto").value;

	if(descripcion == "" || hora == "" || tarea == "" || foto == "")
	{
		alert("Complete los campos vacios");
		return false;
	}
	return true;
}

function desabilitarCampos(nombre) 
{
	var elemento = document.getElementsByName("operacion");
	for ( var i = 0; int < elemento.length; i++) {
		if (elemento[i].value == nombre) {
			elemento[i].disabled = true;
		}
	}
}
function eliminarCliente(idCliente) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Cliente?operacion=Eliminar&id="+idCliente;
	}
}

function eliminarModulo(idModulo) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Modulo?operacion=Eliminar&id="+idModulo;
	}
}

function eliminarHito(idHito) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Hito?operacion=Eliminar&id="+idHito;
	}
}

function eliminarUsuario(idUsuario) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Usuario?operacion=Eliminar&id="+idUsuario;
	}
}

function eliminarRol(idRol) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Rol?operacion=Eliminar&id="+idRol;
	}
}

function eliminarProyectoUsuario(idProyecto, idUsuario) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "ProyectoUsuario?operacion=Eliminar&idProyecto="+idProyecto+"&idUsuario="+idUsuario;
	}
}

function eliminarActividad(idActividad) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Actividad?operacion=Eliminar&id="+idActividad;
	}
}

function eliminarTipo(idTipoTarea) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "TipoTarea?operacion=Eliminar&id="+idTipoTarea;
	}
}

function eliminarProyecto(idProyecto) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Proyecto?operacion=Eliminar&id="+idProyecto;
	}
}

function eliminarComponente(idComponente) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Componente?operacion=Eliminar&id="+idComponente;
	}
}

function eliminarTarea(idTarea) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Tarea?operacion=Eliminar&id="+idTarea;
	}
}

function cancelarCliente() {
		document.location.href= "Cliente";
}

function cancelarModulo() {
	document.location.href= "Modulo";
}

function cancelarHito() {
	document.location.href= "Hito";
}

function cancelarRol() {
	document.location.href= "Rol";
}

function cancelarUsuario() {
	document.location.href= "Usuario";
}

function cancelarProyectoUsuario() {
	document.location.href= "ProyectoUsuario";
}

function cancelarTipo() {
	document.location.href= "TipoTarea";
}
function cancelarTarea() {
	document.location.href= "Tarea";
}
function cancelarProyecto() {
	document.location.href= "Proyecto";
}
function cancelarActividad() {
	document.location.href= "Actividad";
}
function cancelarComponente() {
	document.location.href= "Componente";
}

function operacion(nombreOperacion)
{
	var elemento = document.getElementsByName("operacion");
	for ( var int = 0; int < elemento.length; int++) {
		if (elemento[i].value == nombre) {
			;
		}
	}
}


function validarFecha(fecha){
	var dtCh= "/";
	var minYear=1900;
	var maxYear=2100;
	function isInteger(s){
		var i;
		for (i = 0; i < s.length; i++){
			var c = s.charAt(i);
			if (((c < "0") || (c > "9"))) return false;
		}
		return true;
	}
	function stripCharsInBag(s, bag){
		var i;
		var returnString = "";
		for (i = 0; i < s.length; i++){
			var c = s.charAt(i);
			if (bag.indexOf(c) == -1) returnString += c;
		}
		return returnString;
	}
	function daysInFebruary (year){
		return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
	}
	function DaysArray(n) {
		for (var i = 1; i <= n; i++) {
			this[i] = 31;
			if (i==4 || i==6 || i==9 || i==11) {this[i] = 30;}
			if (i==2) {this[i] = 29;}
		}
		return this;
	}
	function isDate(dtStr){
		var daysInMonth = DaysArray(12);
		var pos1=dtStr.indexOf(dtCh);
		var pos2=dtStr.indexOf(dtCh,pos1+1);
		var strDay=dtStr.substring(0,pos1);
		var strMonth=dtStr.substring(pos1+1,pos2);
		var strYear=dtStr.substring(pos2+1);
		strYr=strYear;
		if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
		if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
		for (var i = 1; i <= 3; i++) {
			if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
		}
		month=parseInt(strMonth);
		day=parseInt(strDay);
		year=parseInt(strYr);
		if (pos1==-1 || pos2==-1){
			return false;
		}
		if (strMonth.length<1 || month<1 || month>12){
			return false;
		}
		if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
			return false;
		}
		if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
			return false;
		}
		if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
			return false;
		}
		return true;
	}
	if(isDate(fecha)){
		return true;
	}else{
		return false;
	}
}