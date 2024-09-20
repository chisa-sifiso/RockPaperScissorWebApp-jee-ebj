<%-- 
    Document   : login_error
    Created on : 10 Jun 2024, 2:11:45 PM
    Author     : MemaniV
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>
    </head>
    <body>
        <h1>Login error</h1>
        <p style="color: red;">
            Invalid login details! Please re-enter.
        </p>
        <form action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="j_username" required=""/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="j_password" required=""/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>


