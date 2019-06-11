<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/carrusel.css" rel="stylesheet" type="text/css"/>
<title></title>
<script type="text/javascript" language="JavaScript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" language="JavaScript" src="<%= request.getContextPath() %>/js/jr.js"></script>
<script type="text/javascript" language="JavaScript" src="<%= request.getContextPath() %>/js/carrusel.js"></script>
</head>
<body>
    <panel>
        <div class="carousel right">
            <div class="wrap">
              <ul>
                <li><img src="<%= request.getContextPath() %>/images/bancomer.jpg"/></li>
                <li><img src="<%= request.getContextPath() %>/images/educacion.jpg"/></li>
                <li><img src="<%= request.getContextPath() %>/images/deportes.jpg"/></li>
                <li><img src="<%= request.getContextPath() %>/images/edificio.jpg"/></li>
                <li><img src="<%= request.getContextPath() %>/images/telefono.jpg"/></li>
                <li><img src="<%= request.getContextPath() %>/images/cajeros.jpg"/></li>
              </ul>
            </div>
          </div>
    </panel>

</body>
</html>
