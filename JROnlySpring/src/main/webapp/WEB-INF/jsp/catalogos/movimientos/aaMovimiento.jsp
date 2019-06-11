<%@ taglib prefix="form" uri="/WEB-INF/spring-form.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar ó Actualizar Cliente</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/formas.css"/>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/calendario_dw-estilos.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/calendario_dw.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jr.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/catalogos/movimientos.js"></script>
</head>
<body onload="cargaMovimiento();">
<fieldset>
<legend>Ingrese los datos requeridos</legend>
<form:form action="doAAMovimiento.jr" commandName="movimientosBean" onsubmit="return validaNulos();">
<form:hidden path="accion"/>
<center>
<table class="tablaAA">
<tr style="display:  none;">
<td><label>Id : </label></td>
<td><form:input path="id"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Concepto(s) : </label></td>
<td><form:input path="concepto" class="required"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Fecha : </label></td>
<td><form:input path="fechaStr" class="campofecha required" size="16" readonly="true"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Tipo : </label></td>
<td><form:select path="tipo" items="${listaTipos}" cssStyle="width: 140px;"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Cantidad : </label></td>
<td><form:input path="cantidad" class="required"/></td>
</tr>
<tr>
<td><input type="button" value="Cancelar" onclick="cancelar();"/>
<td><input type="submit" value="Aceptar"/></td>
</tr>
</table>
</center>
</form:form>
</fieldset>
</body>
</html>
