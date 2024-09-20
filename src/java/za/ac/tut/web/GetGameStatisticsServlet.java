/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.GameSummaryFacadeLocal;
import za.ac.tut.model.entity.GameSummary;

/**
 *
 * @author MemaniV
 */
public class GetGameStatisticsServlet extends HttpServlet {
    @EJB GameSummaryFacadeLocal gsfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        
        List<GameSummary> gameStatistics = gsfl.find(id);
        String url;
        
        if(gameStatistics == null){
           url = "no_game_statistics_found.jsp"; 
        } else {
            url = "get_game_stats_outcome.jsp"; 
            request.setAttribute("gameStatistics", gameStatistics);
            request.setAttribute("id", id);
        }
        
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);                
    }

}
