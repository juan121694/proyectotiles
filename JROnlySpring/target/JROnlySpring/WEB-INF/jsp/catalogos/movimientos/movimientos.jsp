<%@ taglib prefix="form" uri="/WEB-INF/spring-form.tld"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/paginator.css" rel="stylesheet" type="text/css"/>
<title>Cátalogo de Clientes</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jr.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/paginator.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/catalogos/movimientos.js"></script>
</head>
<body onload="loadForma('tablaCatalogoMovimientos');">
<form:form commandName="movimientosBean">
<form:hidden path="id"/>
<div align="center" style="width: 100%; height: 700px;">
<table style="width: 100%">
<tr>
<td>
    <table style="width: 100%;">
        <tr>
        <td align="left">
        <a href="#" title="Nuevo Movimiento" onclick="nuevo('showMovimiento.jr?accion=nuevo', 850, 350);">
        <img src="<%= request.getContextPath() %>/images/new.gif" alt="Nuevo Movimiento" title="Nuevo Movimiento" border="0"/>
        <font color="blue">Nuevo</font>
        </a>&nbsp;
        <a href="#" title="Actualizar Movimiento" onclick="actualizaData('showMovimiento.jr', 'id', 0, 850, 350);">
        <img src="<%= request.getContextPath() %>/images/update.gif" alt="Actualizar Movimiento" title="Actualizar Movimiento" border="0"/>
        <font color="blue">Actualizar</font>
        </a>&nbsp;
        <a href="#" title="Borrar Movimiento" onclick="validaBorrado('movimientosBean', 'id', 0, 'borraMovimiento.jr');">
        <img src="<%= request.getContextPath() %>/images/delete.png" alt="Borrar Movimiento" title="Borrar Movimiento" border="0"/>
        <font color="blue">Borrar</font>
        </a>
        </td></tr>
        <tr><td width="100%" height="2px" bgcolor="Silver"></td></tr>
    </table>
    <table id="tablaCatalogoMovimientos" style="width: 100%" class="display">
        <tr>
        <th style="display: none;">id</th>
        <th>Concepto</th>
        <th>Cantidad</th>
        <th>Fecha</th>
        <th>Tipo</th>
        </tr>
        <c:forEach var="objMovimiento" items="${listaMovimientos}" varStatus="status">
        <tr>
        <td style="display: none;">${objMovimiento.id}</td>
        <td>${objMovimiento.concepto}</td>
        <td>${objMovimiento.cantidad}</td>
        <td>${objMovimiento.fecha}</td>
        <td>${objMovimiento.tipo}</td>
        </tr>
        </c:forEach>
    </table>
</td></tr>
</table>
</div>
</form:form>
</body>
</html>