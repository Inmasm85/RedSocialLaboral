<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String datos = (String) request.getAttribute("datos");
    if (datos == null) {
        datos = "Error al obtener datos";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
    </head>
    <body>
        <h1>principal.jsp</h1>
        <%= datos %>
        <br/>
        <a href="Logout"> Log Out </a>
    </body>
</html>