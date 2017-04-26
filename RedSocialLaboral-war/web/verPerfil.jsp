<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collection"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Estudios"%>
<%@page import="entity.Aficion"%>
<%@page import="entity.Experiencia"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BigDecimal id = (BigDecimal) session.getAttribute("usuarioId");
    if (id == null) {
        id = new BigDecimal(-1);
    }
    String titulo;
    Boolean editable = Boolean.FALSE;
    Usuario u = (Usuario) request.getAttribute("usuarioSeleccionado");
    if (u == null) {
        u = new Usuario();
        u.setEmail("");
        u.setPass("");
        u.setNombre("");
        u.setApellidos("");
        u.setTwitter("");
        u.setInstagram("");
        u.setWeb("");
        u.setFoto("");
        titulo = "";
    } else {
        titulo = u.getNombre() + " " + u.getApellidos();
        if (id.equals(u.getId())) {
            editable = Boolean.TRUE;
        }
    }
    Collection<Estudios> estudios = u.getEstudiosCollection();
    Collection<Experiencia> experiencia = u.getExperienciaCollection();
    Collection<Aficion> aficiones = u.getAficionCollection();
    
    String str;
    SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= titulo %></title>
    </head>
    <body>
        <h1>verPerfil.jsp</h1>
        <div>
            <p>Informacion de <%= u.getNombre() %> <%= u.getApellidos() %>:</p>
            <table border="0">
                <tr>
                    <td>Email: </td><td><%= u.getEmail() %></td>
                </tr>
                <tr>
                    <td>Pass: </td><td><%= u.getPass() %></td>
                </tr>
                <tr>
                    <td>Nombre: </td><td><%= u.getNombre() %></td>
                </tr>
                <tr>
                    <td>Apellidos: </td><td><%= u.getApellidos() %></td>
                </tr>
                <tr>
                    <td>Twitter: </td><td><%= u.getTwitter() %></td>
                </tr>
                <tr>
                    <td>Instagram: </td><td><%= u.getInstagram() %></td>
                </tr>
                <tr>
                    <td>Web: </td><td><%= u.getWeb() %></td>
                </tr>
                <tr>
                    <td>Foto: </td><td><%= u.getFoto() %></td>
                </tr>
            </table>
<%
            if (editable) {
%>
                <a href="EditarUsuario"> Editar Informacion </a><br/>
<%
            }
%> 
        </div>
        <div>
            <p>Estudios de <%= u.getNombre() %> <%= u.getApellidos() %>:</p>
            <table border="1">
                <tr>
                    <th>F. Inicio</th>
                    <th>F. Fin</th>
                    <th>Ubicacion</th>
                    <th>Descripcion</th>
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
                    </tr>             
<%
                }
%>
            </table>
<%
            if (editable) {
%>
                <a href="EditarEstudios"> Editar Estudios </a><br/>
<%
            }
%>
        </div>
        <div>
            <p>Experiencia laboral de <%= u.getNombre() %> <%= u.getApellidos() %>:</p>
            <table border="1">
                <tr>
                    <th>F. Inicio</th>
                    <th>F. Fin</th>
                    <th>Puesto</th>
                    <th>Empresa</th>
                    <th>Web</th>
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
                    </tr>
<%
                }
%>
            </table>
<%
            if (editable) {
%>
                <a href="EditarExperiencia"> Editar Experiencia </a><br/>
<%
            }
%> 
        </div>
        <div>
            <p>Aficiones de <%= u.getNombre() %> <%= u.getApellidos() %>:</p>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                </tr>
<%
                for (Aficion af : aficiones) {
%>
                    <tr>
                        <td><%= af.getAficionPK().getNombre() %></td>
                    </tr>             
<%
                }
%>
            </table>
<%
            if (editable) {
%>
                <a href="EditarAficiones"> Editar Aficiones </a><br/>
<%
            }
%>
        </div>
        <a href="Principal"> Volver </a>
    </body>
</html>