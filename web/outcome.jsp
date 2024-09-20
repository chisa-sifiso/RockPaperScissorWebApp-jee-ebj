<%-- 
    Document   : outcome
    Created on : 09 Jun 2024, 9:17:32 PM
    Author     : MemaniV
--%>

<%@page import="za.ac.tut.model.entity.ComputerGeneratedValue"%>
<%@page import="za.ac.tut.model.entity.UserGuess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Outcome</h1>
        <%
            UserGuess userGuess = (UserGuess)request.getAttribute("userGuess");
            String guessValue = userGuess.getUserGuessValue();
            ComputerGeneratedValue computerValue = (ComputerGeneratedValue)session.getAttribute("computerValue");
            String compValue = computerValue.getComputerValue();
            String outcome = (String)session.getAttribute("outcome");
        %>
        <p>
            Below is the outcome:
        </p>
        <table>
            <tr>
                <td>Computer value: </td>
                <td><%=compValue%></td>
            </tr>
            <tr>
                <td>User guess: </td>
                <td><%=guessValue%></td>
            </tr>
            <tr>
                <td>Outcome: </td>
                <td><%=outcome%></td>
            </tr>
        </table>
        <p>
            Please select one of the following options:
        </p>
        <ul>
            <li><a href="GetComputerValueServlet.do">Play again.</a></li>
            <li><a href="summary.jsp">View game summary.</a></li>
        </ul>
    </body>
</html>
