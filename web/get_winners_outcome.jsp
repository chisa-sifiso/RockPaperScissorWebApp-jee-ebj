<%-- 
    Document   : get_winners_outcome
    Created on : 10 Jun 2024, 12:17:15 PM
    Author     : MemaniV
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Winners Outcome Page</title>
    </head>
    <body>
        <h1>Winners outcome</h1>
        <%
            List<String> winners = (List<String>)request.getAttribute("winners");
        %>
        <p>
            Below is the list of winners.
        </p>
        <table>
            <%
                int cnt = 1;
                for(int i = 0; i < winners.size(); i++){
                    String name = winners.get(i);
                %>
                <tr>
                    <td><u><i><b>Details of winner <%=cnt++%></b></i></u></td>
                </tr>
                <tr>
                    <td>Name: <b><%=name%></b></td>
                </tr>
                <%
                }
            %>
        </table>
        <p>
            Please select one of the following options:
        </p>
        <ul>
            <li><a href="game_stats_menu.jsp">Go back to game statistics menu.</a></li>
            <li><a href="menu.jsp">Go to the main menu.</a></li>
            <li><a href="LogoutServlet.do">Logout.</a></li>
        </ul>        
    </body>
</html>

