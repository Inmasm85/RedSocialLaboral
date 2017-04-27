<%-- 
    Document   : listaExperiencia
    Author     : anton y Roberto Sanchez
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Experiencia"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Collection<Experiencia> experiencia = (Collection<Experiencia>) request.getAttribute("experiencia");
    
    String str;
    SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Experiencia</title>
    </head>
    <body>
        <h1>listaExperiencia.jsp</h1>
        <div>
            <table border="1">
                <tr>
                    <th>F. Inicio</th>
                    <th>F. Fin</th>
                    <th>Puesto</th>
                    <th>Empresa</th>
                    <th>Web</th>
                    <th colspan="2"></th>
                </tr>
<%
                for (Experiencia ex : experiencia) {
%>
                    <tr>
<%
                        if (ex.getFechainicio() == null) {
                            str = "";
                        } else {
                            str = d.getDateInstance().format(ex.getFechainicio());
                        }
%>
                        <td><%= str %></td>
<%
                        if (ex.getFechafin()== null) {
                            str = "";
                        } else {
                            str = d.getDateInstance().format(ex.getFechafin());
                        }
%>
                        <td><%= str %></td>
                        <td><%= ex.getPuesto() %></td>
                        <td><%= ex.getEmpresa() %></td>
                        <td><%= ex.getWebempresa()%></td>
                        <td><a href="ActualizarExperiencia?experienciaId=<%= ex.getId() %>">Editar</a></td>
                        <td><a href="BorrarExperiencia?experienciaId=<%= ex.getId()%>">Borrar</a></td>
                    </tr>
<%
                }
%>
            </table><a href="editarExperiencia.jsp"> Agregar </a>
        </div>
        <a href="VerPerfil"> Volver </a>
    </body>
</html>