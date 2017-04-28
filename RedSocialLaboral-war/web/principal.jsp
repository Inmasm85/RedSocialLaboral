<%-- 
    Document   : principal
    Created on : 24-abr-2017, 16:24:36
    Author     : Antonio Joaquín Luque
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Bandeja de mensajes</title>
    </head>
    
    <%
        List<Mensaje> mensajes = (ArrayList<Mensaje>) request.getAttribute("mensajes");
        if (mensajes == null) {
            mensajes = new ArrayList<Mensaje>();
        }
    %>
    
    <body>
        <div class="cabecera">
            <input type="button" value="Perfil" onClick="  window.location.href='VerPerfil'">
            <input type="button" value="Log Out" onClick="  window.location.href='Logout'">
        </div>
        <h2>Pagina Principal</h2>
        <br/>
        <br/>
        Mensajes no leidos: <%= mensajes.size() %>
        <br/>
        <br/>
        <table border="1">
          <tr>
            <th>Mensaje:</th>
            <th>De:</th>
            <th>Fecha:</th>
            <th></th>
          </tr>
            <% 
                for(Mensaje m:mensajes){
            %>
            <tr>
                <% 
                    if(m.getMensaje().length()>20){
                %>
                <td><a href="ServletLeerMensaje?mensaje=<%= m.getId() %>&servlet=ServletMensajesNoLeidos"><%=m.getMensaje().substring(0, 20) + "..." %></td>
                <%
                    }else{
                %>
                <td><a href="ServletLeerMensaje?mensaje=<%= m.getId() %>&servlet=ServletMensajesNoLeidos"><%=m.getMensaje() %></td>
                <% 
                    }
                %>
                <td><%=" " +m.getEmisor().getNombre() + " " + m.getEmisor().getApellidos() + " " %></td>
                <td><%=" " + m.getFecha() + " " %></td>
                
                <td><a href="ServletEliminarMensaje?mensaje=<%= m.getId() %>&servlet=ServletMensajesNoLeidos">Eliminar</td>
            </tr>
            <% 
                }
            %>
        </table>
        <br/>
        
        <input type="button" value="Mensajes recibidos" onClick="  window.location.href='ServletMostrarMensajesRecibidos'">
       
        <input type="button" value="Mensajes enviados" onClick="  window.location.href='ServletMostrarMensajesEnviados'">
    </body>
</html>
