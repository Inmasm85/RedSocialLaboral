<%-- 
    Document   : lecturaMensaje
    Created on : 04-abr-2017, 19:55:31
    Author     : anton
--%>

<%@page import="entity.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leer mensaje</title>
    </head>
    
    <%
        Mensaje mensaje = (Mensaje)request.getAttribute("mensaje");
        String servlet = (String) request.getAttribute("servlet");
    %>
    
    <body>
        <%="DE " + mensaje.getEmisor().getNombre() + " " + mensaje.getEmisor().getApellidos() +
                " PARA " + mensaje.getReceptor().getNombre() + " " + mensaje.getReceptor().getApellidos() +
                " ," + mensaje.getFecha() %>
      <br/>
      <br/>
      <p>
        Mensaje: <%= " " + mensaje.getMensaje() %>
      </p>
      <br/>
      <br/>
      <input type="button" value="Responder" onClick=" window.location.href='ServletMostrarEscrituraMensaje?mesanje=<%=mensaje.getId()%>' ">
      <input type="button" value="Volver" onClick="  window.location.href='<%=servlet %>'">
    </body>
</html>
