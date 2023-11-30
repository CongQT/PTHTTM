/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MatchDAO;
import dao.PlayerDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Player;
import model.Match;

/**
 *
 * @author 84382
 */
@WebServlet(name = "MatchController", urlPatterns = {"/lichsu"})
public class MatchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            Player player = (Player) session.getAttribute("player");
            List<Match> listMatch = MatchDAO.getMatchHistoryByPlayer(player);
            request.setAttribute("listMatch", listMatch);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("GDLichSuDau.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
    public String getServletInfo() {
            return "Short description";
        }// </editor-fold>

}
