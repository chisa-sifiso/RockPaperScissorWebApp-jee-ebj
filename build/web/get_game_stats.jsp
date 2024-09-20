<%-- 
    Document   : get_game_stats
    Created on : 10 Jun 2024, 11:17:56 AM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Game Statistics Page</title>
    </head>
    <body>
        <h1>Get game statistics</h1>
        <p>
            Please enter your the player's ID.
        </p>
        <form action="GetGameStatisticsServlet.do" method="POST">
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id" required=""/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="GET"/></td>
                </tr>
            </table>
        </form>        
    </body>
</html>
