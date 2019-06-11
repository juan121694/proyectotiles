
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/jr.css" rel="stylesheet" type="text/css"/>
<title>Proyecto Web Java Revolutions Only Spring</title>
<script type="text/javascript" language="JavaScript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" language="JavaScript" src="<%= request.getContextPath() %>/js/index.js"></script>
<script type="text/javascript" language="JavaScript">
/**
 * Función que cancela la forma
 * @return
 */
function cancelar() {
	window.location.replace("<%= request.getContextPath() %>");
}
</script>
</head>
<body onload="carga();">
    <jsp:include page="/WEB-INF/tiles/header.jsp"></jsp:include>
<form action="<%= request.getContextPath() %>/login.jr" method="POST" onsubmit="return validate();" >
    <div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">Inicio Sesion</h2>

  <form class="login-container">
    <p><input type='text' name='j_username' id="j_username" class="TextoCampo2" placeholder="Usuario" /></p>
    <p><input type='password' name='j_password' id="j_password" class="TextoCampo2" placeholder="Contraseña" /></p>
    <p><input name="submit" type="submit" value="Aceptar" onclick="return validate();" size="auto"/></p>
  </form>
  <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
</div>
</form>
<jsp:include page="/WEB-INF/tiles/footer.jsp"></jsp:include>
</body>
</html>
