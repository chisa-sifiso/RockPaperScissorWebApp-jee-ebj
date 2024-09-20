/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bl.RockPaperScissorSBLocal;
import za.ac.tut.model.entity.ComputerGeneratedValue;

/**
 *
 * @author MemaniV
 */
public class GetComputerValueServlet extends HttpServlet {
    @EJB RockPaperScissorSBLocal rpsl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String computerValueStr = rpsl.generateSign();
        ComputerGeneratedValue computerValue = createComputerValue(computerValueStr);
        
        session.setAttribute("computerValue", computerValue);
        
        RequestDispatcher disp = request.getRequestDispatcher("user_guess.jsp");
        disp.forward(request, response);        
    }

    private ComputerGeneratedValue createComputerValue(String computerValueStr) {
        ComputerGeneratedValue cgv = new ComputerGeneratedValue();
        cgv.setComputerValue(computerValueStr);
        return cgv;
    }

}
