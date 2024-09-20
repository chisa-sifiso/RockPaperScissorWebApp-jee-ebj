<%-- 
    Document   : menu
    Created on : 09 Jun 2024, 8:30:36 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
    </head>
    <body>
        <h1>Menu</h1>
        <%
            String name = (String)session.getAttribute("name");
            String computerName = pageContext.getServletContext().getInitParameter("computer_name");
        %>
        <p>
            Hi <b><%=name%></b>. My name is <b><%=computerName%></b>, your <b>Rock Paper Scissor</b> playing companion.
        </p>
        <p>
            Please select one of the following options:
        </p>
        <Ul>
            <li>Click <a href="GetComputerValueServlet.do">here</a> to start the game.</li>
            <li>Click <a href="game_stats_menu.jsp">here</a> to view game statistics.</li>
        </ul>
    </body>
</html>
