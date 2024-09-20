<%-- 
    Document   : summary
    Created on : 09 Jun 2024, 9:33:02 PM
    Author     : MemaniV
--%>

<%@page import="za.ac.tut.model.entity.UserGuess"%>
<%@page import="za.ac.tut.model.entity.ComputerGeneratedValue"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Page</title>
    </head>
    <body>
        <h1>Summary</h1>
        <%
            Integer numGamesPlayed = (Integer)session.getAttribute("numGamesPlayed");
            Integer userScore = (Integer)session.getAttribute("userScore");
            Integer computerScore = (Integer)session.getAttribute("computerScore");
            Integer numTies = (Integer)session.getAttribute("numTies");
            List<ComputerGeneratedValue> computerValues = (List<ComputerGeneratedValue>)session.getAttribute("computerValues");
            List<UserGuess> userGuesses = (List<UserGuess>)session.getAttribute("userGuesses"); 
        %>
        <p>
            Below is the game summary:
        </p>
        <table>
            <tr>
                <td>Number of games played: </td>
                <td><%=numGamesPlayed%></td>
            </tr>
            <tr>
                <td>User's score: </td>
                <td><%=userScore%></td>
            </tr>
            <tr>
                <td>Computer's score: </td>
                <td><%=computerScore%></td>
            </tr>
            <tr>
                <td>Number of ties: </td>
                <td><%=numTies%></td>
            </tr>
            <tr>
                <td>Computer values: </td>
                <td><%=computerValues%></td>
            </tr>
            <tr>
                <td>User guesses: </td>
                <td><%=userGuesses%></td>
            </tr>
        </table>
        <p>
            Please select one of the following options:
        </p>
        <ul>
            <li><a href="GetComputerValueServlet.do">Play again.</a></li>
            <li><a href="StoreSummaryServlet.do">Store summary in the database.</a></li>
        </ul>
    </body>
</html>
