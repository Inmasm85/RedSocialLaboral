<%-- 
    Document   : pantallaMensajes
    Created on : 04-abr-2017, 17:49:45
    Author     : Antonio Joaquín Luque
--%>

<%@page import="entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="entity.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bandeja de mensajes</title>
    </head>
    
    <%
        List<Mensaje> mensajes = (ArrayList<Mensaje>)request.getAttribute("mensajes");
        String servlet = (String)request.getAttribute("servlet");
        boolean enviados = false;
        String t = " recibidos";
        if(servlet.equals("ServletMostrarMensajesEnviados")){
           enviados = true;
           t = " enviados";
        }
    %>
    
    <body>
        <h1>Bandeja de mensajes <%=t %></h1>
        <table border="1">
          <tr>
            <th>Mensaje:</th>
            <th>De:</th>
            <th>Fecha:</th>
            <th></th>
            <th></th>
          </tr>
            <% 
                for(Mensaje m:mensajes){
            %>
            <tr>
                <% 
                    if(m.getMensaje().length()>20){
                %>
                <td><a href="ServletLeerMensaje?mensaje=<%= m.getId() %>&servlet=<%=servlet %>"><%=m.getMensaje().substring(0, 20) + "..." %></td>
                <%
                    }else{
                %>
                <td><a href="ServletLeerMensaje?mensaje=<%= m.getId() %>&servlet=<%=servlet %>"><%=m.getMensaje() %></td>
                <% 
                    }
                %>
                <td><%=" " +m.getEmisor().getNombre() + " " + m.getEmisor().getApellidos() + " " %></td>
                <td><%=" " + m.getFecha() + " " %></td>
                <%
                    if(m.getVisto().equals('F')){
                %>
                <td><b>No leído</b></td>
                <%        
                    }else{
                %>
                <td>Leido</td>
                <%      
                    }
                %>
                <td><a href="ServletEliminarMensaje?mensaje=<%= m.getId() %>&servlet=<%=servlet %>">Eliminar</td>
            </tr>
            <% 
                }
            %>
        </table>
        <br/>
        <input type="button" value="Enviar mensaje" onClick="  window.location.href='ServletMostrarEscrituraMensaje'">
        <% 
            if(enviados){
        %>
        <input type="button" value="Mensajes recibidos" onClick="  window.location.href='ServletMostrarMensajesRecibidos'">
        <% 
            }else{
        %>
        <input type="button" value="Mensajes enviados" onClick="  window.location.href='ServletMostrarMensajesEnviados'">
        <% 
            }
        %>
        <input type="button" value="Página Principal" onClick="  window.location.href='Principal'">


        
</body>
</html>
