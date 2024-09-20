<%-- 
    Document   : user_guess
    Created on : 09 Jun 2024, 8:53:01 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Guess Page</title>
    </head>
    <body>
        <h1>User Guess</h1>
        <%
            String name = (String)session.getAttribute("name");
            String computerName = pageContext.getServletContext().getInitParameter("computer_name");
        %>
        <p>
            Hi <b><%=name%></b>. <b><%=computerName%></b> has generated a value. Please guess it.
        </p>
        <form action="OutcomeServlet.do" method="POST">
            <table>
                <tr>
                    <td>My guess:</td>
                    <td>
                        <select name="user_guess">
                            <option value="Rock">Rock</option>
                            <option value="Paper">Paper</option>
                            <option value="Scissor">Scissor</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="GUESS" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
