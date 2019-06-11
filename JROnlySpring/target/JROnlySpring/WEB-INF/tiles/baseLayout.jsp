<%@ taglib uri="/WEB-INF/tiles-jsp.tld" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/js/menu/assets/skins/sam/menu.css"/>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/estilo.css"/>
	<script type="text/javascript">
	function setLeyenda(opcion) {
	    texto = formatTexto(opcion);
	    texto = 'C�talogos > '+texto+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	    document.getElementById("leyenda_posicion").innerHTML = texto;
	}
	function formatTexto(texto) {
	    aux = texto.split("_");
	    cadena = "";
	    for(var i = 0; i < aux.length; i++) {
	        cadena += aux[i]+" ";
	    }
	    return cadena.toUpperCase();
	}
	</script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/utilities/utilities.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/container/container.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/menu/menu.js"></script>
    <link href="<%=request.getContextPath()%>/css/jr.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="yui-skin-sam">
        <tiles:insertAttribute name="header"/>
        <table border="0" cellpadding="2" cellspacing="2" align="center" >
            <tr>
                <td >
                    <tiles:insertAttribute name="menu"/>
                </td>
            </tr>
            <tr>
                <td width="100%" height="700px">
                    <tiles:insertAttribute name="body"/>
                </td>
            </tr>
        </table>
        
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
