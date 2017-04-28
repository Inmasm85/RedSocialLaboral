<%-- 
    Document   : login
    Author     : Roberto Sanchez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Integer error = (Integer) request.getAttribute("error");
    if (error == null) {
        error = new Integer(0);
    }
    
    String email = (String) request.getAttribute("email");
    if (email == null) {
        email = "";
    }
    
    String pass = (String) request.getAttribute("pass");
    if (pass == null) {
        pass = "";
    }
    
    String msg;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>login.jsp</h1>
        <div>
            <form name="login" action="Login" method="post">
                <table border="0">
                    <tr>
<%
                        switch (error) {
                            case 1:
                            case 3: msg = " Introduzca email"; break;
                            case 4: msg = " Email o password incorrecto"; break;
                            default: msg = "";
                        }
%>
                        <td>Email: </td><td><input type="text" name="email" value="<%= email %>" /><%= msg %></td>
                    </tr>
<%
                        switch (error) {
                            case 2:
                            case 3: msg = " Introduzca password"; break;
                            case 4: msg = " Email o password incorrecto"; break;
                            default: msg = "";
                        }
%>
                    <tr>
                        <td>Pass: </td><td><input type="password" name="pass" value="<%= pass %>" /><%= msg %></td>
                    </tr>
                    <tr>	
                        <td colspan="2"><input type="submit" name="btnLogin" value="Log In" /></td>
                    </tr>
                </table>
                <a href="editarPerfil.jsp"> Sign In </a>
            </form>
        </div>
    </body>
</html>