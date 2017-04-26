<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="entity.Estudios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String titulo;
    Estudios e = (Estudios) request.getAttribute("estudios");
    if (e == null) {
        titulo = "Agregar Estudios";
        e = new Estudios();
        e.setId(new BigDecimal(-1));
    } else {
        titulo = "Editar Estudios";
    }
    
    String str;
    SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= titulo %></title>
    </head>
    <body>
        <h1>editarEstudios.jsp</h1>
        <div>
            <form name="estudios" action="GuardarEstudios" method="post">
                <input type="hidden" name="estudiosId" value="<%= e.getId() %>" />
                <table border="0">
                    <tr>
<%
                        if (e.getFechainicio() == null) {
                            str = "";
                        } else {
                            str = d.getDateInstance().format(e.getFechainicio());
                        }
%>
                        <td>Fecha Inicio: </td><td><input type="text" name="fechaInicio" value="<%= str %>" /></td>
                    </tr>
                    <tr>
<%
                        if (e.getFechafin()== null) {
                            str = "";
                        } else {
                            str = d.getDateInstance().format(e.getFechafin());
                        }
%>
                        <td>Fecha Fin: </td><td><input type="text" name="fechaFin" value="<%= str %>" /></td>
                    </tr>
                    <tr>
<%
                        if (e.getUbicacion()== null) {
                            str = "";
                        } else {
                            str = e.getUbicacion();
                        }
%>
                        <td>Ubicacion: </td><td><input type="text" name="ubicacion" value="<%= str %>" /></td>
                    </tr>
                    <tr>
<%
                        if (e.getDescripcion()== null) {
                            str = "";
                        } else {
                            str = e.getDescripcion().toString();
                        }
%>
                        <td>Descripcion: </td><td><input type="text" name="descripcion" value="<%= str %>" /></td>
                    </tr>
                    <tr>	
                        <td colspan="2"><input type="submit" name="btnGuardar" value="Enviar" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <a href="EditarEstudios"> Volver </a>
    </body>
</html>