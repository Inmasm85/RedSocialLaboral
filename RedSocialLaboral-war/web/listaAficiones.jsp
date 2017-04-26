<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collection"%>
<%@page import="entity.Aficion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Collection<Aficion> aficiones = (Collection<Aficion>) request.getAttribute("aficiones");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aficiones</title>
    </head>
    <body>
        <h1>listaAficiones.jsp</h1>
        <div>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th colspan="2"></th>
                </tr>
<%
                for (Aficion a : aficiones) {
%>
                    <tr>
                        <td><%= a.getAficionPK().getNombre() %></td>
                        <td><a href="ActualizarAficion?aficion=<%= a.getAficionPK().getNombre() %>">Editar</a></td>
                        <td><a href="BorrarAficion?aficion=<%= a.getAficionPK().getNombre() %>">Borrar</a></td>
                    </tr>
<%
                }
%>
            </table>
            <a href="editarAficion.jsp"> Agregar </a>
        </div>
        <a href="VerPerfil"> Volver </a>
    </body>
</html>