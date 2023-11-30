/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BXHDAO;
import dao.MatchDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BXH;
import model.Player;

/**
 *
 * @author 84382
 */
@WebServlet(name = "BXHController", urlPatterns = {"/bxh"})
public class BXHController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            Player player = (Player) session.getAttribute("player");
            List<BXH> listBXH = BXHDAO.getRanking();
            request.setAttribute("listBXH", listBXH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("GDBXH.jsp").forward(request, response);
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