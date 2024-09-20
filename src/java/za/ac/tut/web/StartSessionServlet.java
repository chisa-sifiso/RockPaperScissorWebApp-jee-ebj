/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.entity.ComputerGeneratedValue;
import za.ac.tut.model.entity.UserGuess;

/**
 *
 * @author MemaniV
 */
public class StartSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        
        initializeSession(session, name, id);
        
        RequestDispatcher disp = request.getRequestDispatcher("menu.jsp");
        disp.forward(request, response);
    }

    private void initializeSession(HttpSession session, String name, String id) {
        Integer userScore = 0, computerScore = 0, numTies = 0, numGamesPlayed = 0;
        List<UserGuess> userGuesses = new ArrayList<>();
        List<ComputerGeneratedValue> computerValues = new ArrayList<>();
        
        session.setAttribute("name", name);
        session.setAttribute("id", id);
        session.setAttribute("userScore", userScore);
        session.setAttribute("computerScore", computerScore);
        session.setAttribute("numTies", numTies);
        session.setAttribute("numGamesPlayed", numGamesPlayed);
        session.setAttribute("userGuesses", userGuesses);
        session.setAttribute("computerValues", computerValues);
    }

}
