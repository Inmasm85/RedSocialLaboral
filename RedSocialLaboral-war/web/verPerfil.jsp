<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String titulo;
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
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= titulo %></title>
    </head>
    <body>
        <h1>VerPerfil.jsp</h1>
        <div>
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
            <a href="Principal"> Volver </a>
        </div>
    </body>
</html>