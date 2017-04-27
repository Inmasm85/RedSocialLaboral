<%-- 
    Document   : editarPerfil
    Author     : Roberto Sanchez
--%>

<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg;
    String titulo;
    Usuario u = (Usuario) request.getAttribute("usuarioSeleccionado");
    if (u == null) {
        u = new Usuario();
        u.setId(null);
        u.setEmail("");
        u.setPass("");
        u.setNombre("");
        u.setApellidos("");
        u.setTwitter("");
        u.setInstagram("");
        u.setWeb("");
        u.setFoto("");
        titulo = "Sign In";
    } else {
        titulo = u.getNombre() + " " + u.getApellidos();
    }
    
    Integer error = (Integer) request.getAttribute("error");
    if (error == null) {
        error = new Integer(0);
    }
    
    String back = "VerPerfil";
    if (u.getId() == null) {
        back = "login.jsp";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= titulo %></title>
    </head>
    <body>
        <h1>EditarPerfil.jsp</h1>
        <div>
            <form name="edicion" action="Guardar" method="post">
                <input type="hidden" name="id" value="<%= u.getId()%>" />
                <table border="0">
                    <tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                        <td>Email: </td><td><input type="text" name="email" value="<%= u.getEmail() %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Pass: </td><td><input type="text" name="pass" value="<%= u.getPass() %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Nombre: </td><td><input type="text" name="nombre" value="<%= u.getNombre() %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Apellidos: </td><td><input type="text" name="apellidos" value="<%= u.getApellidos() %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Twitter: </td><td><input type="text" name="twitter" value="<%= u.getTwitter() %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Instagram: </td><td><input type="text" name="instagram" value="<%= u.getInstagram() %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Web: </td><td><input type="text" name="web" value="<%= u.getWeb() %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Foto: </td><td><input type="text" name="foto" value="<%= u.getFoto() %>" /><%= msg %></td>
                    </tr>
                    <tr>	
                        <td colspan="2"><input type="submit" name="btnSend" value="Enviar" /></td>
                    </tr>
                </table>
                <a href="<%= back %>"> Volver </a>
            </form>
        </div>
    </body>
</html>