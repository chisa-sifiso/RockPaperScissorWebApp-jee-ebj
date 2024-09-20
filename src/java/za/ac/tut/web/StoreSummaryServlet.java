/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
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
import za.ac.tut.model.entity.ComputerGeneratedValue;
import za.ac.tut.model.entity.GameSummary;
import za.ac.tut.model.entity.UserGuess;

/**
 *
 * @author MemaniV
 */
public class StoreSummaryServlet extends HttpServlet {
    @EJB GameSummaryFacadeLocal gsfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        String userID = (String)session.getAttribute("id");
        Integer numGamesPlayed = (Integer)session.getAttribute("numGamesPlayed");
        Integer userScore = (Integer)session.getAttribute("userScore");
        Integer computerScore = (Integer)session.getAttribute("computerScore");
        Integer numTies = (Integer)session.getAttribute("numTies");
        List<ComputerGeneratedValue> computerValues = (List<ComputerGeneratedValue>)session.getAttribute("computerValues");
        List<UserGuess> userGuesses = (List<UserGuess>)session.getAttribute("userGuesses");
        
        GameSummary gs = createGameSummary(name, userID, numGamesPlayed, userScore, computerScore, numTies, computerValues, userGuesses);
        gsfl.create(gs);
        
        RequestDispatcher disp = request.getRequestDispatcher("summary_storage_outcome.jsp");
        disp.forward(request, response);          
    }

    private GameSummary createGameSummary(String name, String userID, Integer numGamesPlayed, Integer userScore, Integer computerScore, Integer numTies, List<ComputerGeneratedValue> computerValues, List<UserGuess> userGuesses) {
        GameSummary gs = new GameSummary();
        gs.setComputerScore(computerScore);
        gs.setComputerValues(computerValues);
        gs.setCreationDate(new Date());
        gs.setNumGamesPlayed(numGamesPlayed);
        gs.setUserGuesses(userGuesses);
        gs.setUserID(userID);
        gs.setUserName(name);
        gs.setUserScore(userScore);
        gs.setNumTies(numTies);
        return gs;
    }

}
