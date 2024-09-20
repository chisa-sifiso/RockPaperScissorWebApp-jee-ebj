/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bl.GameSummaryFacadeLocal;
import za.ac.tut.model.bl.RockPaperScissorSBLocal;
import za.ac.tut.model.entity.ComputerGeneratedValue;
import za.ac.tut.model.entity.GameSummary;
import za.ac.tut.model.entity.UserGuess;

/**
 *
 * @author MemaniV
 */
public class EndSessionServlet extends HttpServlet {
    @EJB GameSummaryFacadeLocal gsfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        resetSession(session);
               
        RequestDispatcher disp = request.getRequestDispatcher("menu.jsp");
        disp.forward(request, response);          
    }

    private void resetSession(HttpSession session) {
        Integer userScore = (Integer)session.getAttribute("userScore");
        Integer computerScore = (Integer)session.getAttribute("computerScore");
        Integer numGamesPlayed = (Integer)session.getAttribute("numGamesPlayed");
        List<ComputerGeneratedValue> computerValues= (List<ComputerGeneratedValue>)session.getAttribute("computerValues");
        List<UserGuess> userGuesses = (List<UserGuess>)session.getAttribute("userGuesses");
        
        userScore = 0;
        computerScore = 0;
        numGamesPlayed = 0;
        computerValues.clear();
        userGuesses.clear();
        
        session.setAttribute("userScore", userScore);
        session.setAttribute("computerScore", computerScore);
        session.setAttribute("numGamesPlayed", numGamesPlayed);
        session.setAttribute("computerValues", computerValues);
        session.setAttribute("userGuesses", userGuesses);        
    }

}
