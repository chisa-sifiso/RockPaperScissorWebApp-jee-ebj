<%-- 
    Document   : access_denied
    Created on : 10 Jun 2024, 2:11:59 PM
    Author     : MemaniV
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied Page</title>
    </head>
    <body>
        <h1>Access denied</h1>
        <p style="color:red;">
            You are not authorized/allowed to access this page!!!
        </p>
        <p>
            Please select one of the following options:
        </p>
        <ul>
            <li><a href="menu.jsp">Go to the main menu.</a></li>
            <li><a href="LogoutServlet.do">Logout.</a></li>
        </ul> 
    </body>
</html>


