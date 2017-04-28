<%-- 
    Document   : listaEstudios
    Author     : Roberto Sanchez
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collection"%>
<%@page import="entity.Estudios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Collection<Estudios> estudios = (Collection<Estudios>) request.getAttribute("estudios");
    
    String str;
    SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudios</title>
    </head>
    <body>
        <h1>listaEstudios.jsp</h1>
        <div>
            <table border="1">
                <tr>
                    <th>F. Inicio</th>
                    <th>F. Fin</th>
                    <th>Ubicacion</th>
                    <th>Descripcion</th>
                    <th colspan="2"></th>
                </tr>
<%
                for (Estudios es : estudios) {
%>
                    <tr>
<%
                        if (es.getFechainicio() == null) {
                            str = "";
                        } else {
                            str = d.getDateInstance().format(es.getFechainicio());
                        }
%>
                        <td><%= str %></td>
<%
                        if (es.getFechafin()== null) {
                            str = "";
                        } else {
                            str = d.getDateInstance().format(es.getFechafin());
                        }
%>
                        <td><%= str %></td>
                        <td><%= es.getUbicacion() %></td>
                        <td><%= es.getDescripcion()%></td>
                        <td><a href="ActualizarEstudios?estudiosId=<%= es.getId() %>">Editar</a></td>
                        <td><a href="BorrarEstudios?estudiosId=<%= es.getId()%>">Borrar</a></td>
                    </tr>
<%
                }
%>
            </table>
            <a href="editarEstudios.jsp"> Agregar </a>
        </div>
        <a href="VerPerfil"> Volver </a>
    </body>
</html>