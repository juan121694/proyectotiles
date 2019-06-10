<%@ taglib prefix="form" uri="/WEB-INF/spring-form.tld"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cátalogo de Clientes</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jr.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/catalogos/inversiones.js"></script>
</head>
<body onload="loadForma('tablaCatalogoInversiones');">
<form:form commandName="inversionesBean">
<form:hidden path="id"/>
<div align="center" style="width: 100%; height: 450px;">
<table style="width: 98%">
<tr>
    <td style="font-weight: bold; size: 20px;" align="right" colspan="4">-> Cátalogo de Inversion</td>
</tr>
<tr>
<td>
    <table style="width: 100%;">
        <tr>
        <td align="left">
        <a href="#" title="Nuevo Inversion" onclick="nuevo('showInversion.jr?accion=nuevo', 850, 350);">
        <img src="<%= request.getContextPath() %>/images/new.gif" alt="Nuevo Inversion" title="Nuevo Inversion" border="0"/>
        <font color="blue">Nuevo</font>
        </a>&nbsp;
        <a href="#" title="Actualizar Inversion" onclick="actualizaData('showInversion.jr', 'id', 0, 850, 350);">
        <img src="<%= request.getContextPath() %>/images/update.gif" alt="Actualizar Inversion" title="Actualizar Inversion" border="0"/>
        <font color="blue">Actualizar</font>
        </a>&nbsp;
        <a href="#" title="Borrar Inversion" onclick="validaBorrado('inversionesBean', 'id', 0, 'borraInversion.jr');">
        <img src="<%= request.getContextPath() %>/images/delete.png" alt="Borrar Inversion" title="Borrar Inversion" border="0"/>
        <font color="blue">Borrar</font>
        </a>
        </td></tr>
        <tr><td width="100%" height="2px" bgcolor="Silver"></td></tr>
    </table>
    <table id="tablaCatalogoInversiones" style="width: 100%">
        <tr>
        <th style="display: none;">id</th>
        <th>Concepto</th>
        <th>Valor</th>
        <th>Fecha</th>
        <th>Tipo</th>
        </tr>
        <c:forEach var="objInversion" items="${listaInversiones}" varStatus="status">
        <tr>
        <td style="display: none;">${objInversion.id}</td>
        <td>${objInversion.concepto}</td>
        <td>${objInversion.valor}</td>
        <td>${objInversion.fecha}</td>
        <td>${objInversion.tipo}</td>
        </tr>
        </c:forEach>
    </table>
</td></tr>
</table>
</div>
</form:form>
</body>
</html>