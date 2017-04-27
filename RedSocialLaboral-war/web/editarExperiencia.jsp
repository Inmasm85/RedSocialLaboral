<%-- 
    Document   : editarExperiencia
    Created on : 26-abr-2017, 18:02:22
    Author     : Antonio Joaquín Luque
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="entity.Experiencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String titulo;
    Experiencia e = (Experiencia) request.getAttribute("experiencia");
    if (e == null) {
        titulo = "Agregar Experiencia";
        e = new Experiencia();
        e.setId(new BigDecimal(-1));
    } else {
        titulo = "Editar Experiencia";
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
        <h1>editarExperiencia.jsp</h1>
        <div>
            <form name="experiencia" action="GuardarExperiencia" method="post">
                <input type="hidden" name="experienciaId" value="<%= e.getId() %>" />
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
                        if (e.getEmpresa()== null) {
                            str = "";
                        } else {
                            str = e.getEmpresa();
                        }
%>
                        <td>Empresa: </td><td><input type="text" name="empresa" value="<%= str %>" /></td>
                    </tr>
                    <tr>
<%
                        if (e.getPuesto()== null) {
                            str = "";
                        } else {
                            str = e.getPuesto();
                        }
%>
                        <td>Puesto: </td><td><input type="text" name="puesto" value="<%= str %>" /></td>
                    </tr>
                    <tr>
<%
                        if (e.getWebempresa()== null) {
                            str = "";
                        } else {
                            str = e.getWebempresa();
                        }
%>
                        <td>Web de la empresa: </td><td><input type="text" name="webEmpresa" value="<%= str %>" /></td>
                    </tr>
                    <tr>	
                        <td colspan="2"><input type="submit" name="btnGuardar" value="Enviar" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <a href="EditarExperiencia"> Volver </a>
    </body>
</html>