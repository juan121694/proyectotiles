<%
session.setAttribute("userInSession", null);
session.invalidate();
System.out.println("Sesi�n cerrada . . .");
%>
<jsp:forward page="index.jsp"></jsp:forward>
