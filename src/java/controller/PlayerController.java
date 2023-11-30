/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PlayerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Player;

/**
 *
 * @author 84382
 */
@WebServlet(name = "PlayerController", urlPatterns = {"/dangnhap"})
public class PlayerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            Player player = new Player();
            player.setUsername(username);
            player.setPassword(pass);
            boolean kq = PlayerDAO.kiemtraDangnhap(player);
            if(kq){
                HttpSession session = request.getSession();
                session.setAttribute("player", player);
                response.sendRedirect("GDTrangChu.jsp");               
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
