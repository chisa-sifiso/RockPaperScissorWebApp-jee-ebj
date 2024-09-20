/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bl.RockPaperScissorSBLocal;
import za.ac.tut.model.entity.ComputerGeneratedValue;
import za.ac.tut.model.entity.UserGuess;

/**
 *
 * @author MemaniV
 */
public class OutcomeServlet extends HttpServlet {
    @EJB RockPaperScissorSBLocal rpsl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ComputerGeneratedValue computerValue = (ComputerGeneratedValue)session.getAttribute("computerValue");
        String userGuessStr = request.getParameter("user_guess");
        UserGuess userGuess = createUserGuess(userGuessStr);
        
        String outcome = rpsl.determineOutcome(userGuess.getUserGuessValue(), computerValue.getComputerValue());
        updateSession(session, outcome, computerValue, userGuess);
        request.setAttribute("userGuess", userGuess);
        
        RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);          
    }

    private void updateSession(HttpSession session, String outcome, ComputerGeneratedValue computerValue, UserGuess userGuess) {
        if(outcome.equals("won")){
            Integer userScore = (Integer)session.getAttribute("userScore");
            userScore++;
            session.setAttribute("userScore", userScore);
            outcome = "Player has won.";
        } else if(outcome.equals("lost")){
            Integer computerScore = (Integer)session.getAttribute("computerScore");
            computerScore++;
            session.setAttribute("computerScore", computerScore);
            outcome = "Player has lost.";
        } else {
            Integer numTies = (Integer)session.getAttribute("numTies");
            numTies++;
            session.setAttribute("numTies", numTies);
            outcome = "It's a tie.";
        }
        
        session.setAttribute("outcome", outcome);
        Integer numGamesPlayed = (Integer)session.getAttribute("numGamesPlayed");
        numGamesPlayed++;
        List<ComputerGeneratedValue> computerValues = (List<ComputerGeneratedValue>)session.getAttribute("computerValues");
        computerValues.add(computerValue);
        List<UserGuess> userGuesses = (List<UserGuess>)session.getAttribute("userGuesses");
        userGuesses.add(userGuess);
        
        session.setAttribute("numGamesPlayed", numGamesPlayed);
        session.setAttribute("computerValues", computerValues);
        session.setAttribute("userGuesses", userGuesses);
    }

    private UserGuess createUserGuess(String userGuessStr) {
        UserGuess ug = new UserGuess();
        ug.setUserGuessValue(userGuessStr);
        return ug;
    }

}
