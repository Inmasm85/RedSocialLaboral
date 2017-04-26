<%-- 
    Document   : escrituraMensaje
    Created on : 03-abr-2017, 10:20:39
    Author     : anton
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <Title>Enviar mensaje</Title>
  </head>
  
  <%
        List<Usuario> contactos = (ArrayList<Usuario>)request.getAttribute("contactos");
    %>
  
  <body><h1>Enviar un mensaje</h1>
    <br/>
    <form name="Enviar" action="ServletEnviarMensaje" method="get">

      Destinatario:
      <select name="destinatario">
          <% 
            for(Usuario u:contactos){
          %>
          <option value="<%=u.getId()%>">
              <%=u.getNombre() + " " + u.getApellidos()%>
          </option>
          <%
            }
          %>
      </select>
      <br/>

      Escriba su mensaje:<br/>
      <textarea name="mensaje" rows="8" cols="50">
      </textarea>
      <br/>
      <br/>

      <input type="submit" value="Enviar">
    </form>
    <br/>
    <input type="button" value="Cancelar" onClick="  window.location.href='ServletMostrarMensajesEnviados'">


</html>

