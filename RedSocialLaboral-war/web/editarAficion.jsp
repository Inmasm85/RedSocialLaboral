<%@page import="java.math.BigDecimal"%>
<%@page import="entity.Aficion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String titulo;
    Aficion a = (Aficion) request.getAttribute("aficiones");
    if (a == null) {
        titulo = "Agregar Aficion";
        a = new Aficion();
        a.getAficionPK().setNombre("");
    } else {
        titulo = "Editar Aficion";
    }
    
    String str;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= titulo %></title>
    </head>
    <body>
        <h1>editarAficion.jsp</h1>
        <div>
            <form name="aficion" action="GuardarAficion" method="post">
                <table border="0">
                    <tr>
<%
                        if (a.getAficionPK().getNombre() == null) {
                            str = "";
                        } else {
                            str = a.getAficionPK().getNombre();
                        }
%>
                        <td>Ubicacion: </td><td><input type="text" name="ubicacion" value="<%= str %>" /></td>
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