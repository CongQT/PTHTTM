/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MatchDAO;
import dao.GameBoardDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Match;
import model.GameBoard;
import model.Player;

/**
 *
 * @author 84382
 */
@WebServlet(name = "BanCoChiTietController", urlPatterns = {"/bcct"})
public class BanCoChiTietController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            Player player = (Player) session.getAttribute("player"); 
            int matchId = Integer.parseInt(request.getParameter("matchId"));
            int result = Integer.parseInt(request.getParameter("result"));
            int symbol = Integer.parseInt(request.getParameter("symbol"));
            request.setAttribute("matchId", matchId);
            request.setAttribute("result", result);
            request.setAttribute("symbol", symbol);
            Match match = new Match(matchId, player, result, symbol);
            List<GameBoard> listMove = GameBoardDAO.getGameBoardByMatch(match);
            request.setAttribute("listMove", listMove);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("GDBanCoChiTiet.jsp").forward(request, response);
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

