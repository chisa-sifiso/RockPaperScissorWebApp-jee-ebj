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
import za.ac.tut.model.bl.RockPaperScissorSBLocal;
import za.ac.tut.model.entity.GameSummary;

/**
 *
 * @author MemaniV
 */
public class GetGamesInfoServlet extends HttpServlet {
    @EJB GameSummaryFacadeLocal gsfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<GameSummary> games = gsfl.findAll();
        request.setAttribute("games", games);
        
        RequestDispatcher disp = request.getRequestDispatcher("games_outcome.jsp");
        disp.forward(request, response);
    }

}
