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

/**
 *
 * @author MemaniV
 */
public class GetWinnersServlet extends HttpServlet {
    @EJB GameSummaryFacadeLocal gsfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> winners = gsfl.getWinners();
        String url;
        
        if(winners == null){
           url = "no_winners.jsp"; 
        } else {
            url = "get_winners_outcome.jsp"; 
            request.setAttribute("winners", winners);
        }
        
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);  
    }

}
