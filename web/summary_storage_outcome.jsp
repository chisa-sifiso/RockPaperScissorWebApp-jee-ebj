<%-- 
    Document   : summary_storage_outcome
    Created on : 09 Jun 2024, 10:12:20 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Storage Outcome Page</title>
    </head>
    <body>
        <h1>Summary Storage Outcome</h1>
        <%
            String name = (String)session.getAttribute("name");
        %>
        <p>
            Hi <b><%=name%></b>. The game summary has been successfully stored in the database.
        </p>
        <p>
            Please select one of the following options:
        </p>
        <ul>
            <li><a href="EndSessionServlet.do">Start a new game.</a></li>
            <li><a href="LogoutServlet.do">Logout.</a></li>
        </ul>
    </body>
</html>
