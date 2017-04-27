<%-- 
    Document   : editarAficion
    Author     : Roberto Sanchez
--%>

<%@page import="entity.AficionPK"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="entity.Aficion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String titulo;
    Aficion a = (Aficion) request.getAttribute("aficion");
    String str, anterior;
    if (a == null) {
        titulo = "Agregar Aficion";
        str = "";
        anterior = null;
    } else {
        titulo = "Editar Aficion";
        str = a.getAficionPK().getNombre();
        anterior = new String(str);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= titulo %></title>
    </head>
    <body>
        <h1>editarAficion.jsp</h1>
        <div>
            <form name="editarAficion" action="GuardarAficion" method="post">
                <input type="hidden" name="anterior" value="<%= anterior %>" />
                <table border="0">
                    <tr>
                        <td>Nombre: </td><td><input type="text" name="nombreAficion" value="<%= str %>" /></td>
                    </tr>
                    <tr>	
                        <td colspan="2"><input type="submit" name="btnGuardar" value="Enviar" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <a href="EditarAficiones"> Volver </a>
    </body>
</html>