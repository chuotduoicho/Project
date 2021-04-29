/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.account;

import dal.AccountDAO;
import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Admin
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        String username = "";
        String password = "";
        if (cookies != null) {

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("cuser")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("cpass")) {
                    password = cookie.getValue();
                }
            }
        }
        AccountDAO db = new AccountDAO();
        Account account = db.getAccountByUsernameAndPassword(username, password);
        if (account != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", account);
            response.sendRedirect("Home");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        AccountDAO db = new AccountDAO();
        Account account = db.getAccountByUsernameAndPassword(username, password);
        if (account != null) {
//            CartDAO db1 = new CartDAO();
//            request.setAttribute("countc",db1.count(account.getUsername()) );
            request.getSession().setAttribute("user", account);
            if (remember != null && remember.equals("remember")) {
                Cookie user = new Cookie("cuser", username);
                Cookie pass = new Cookie("cpass", password);
                user.setMaxAge(3600 * 24 * 30 );
                pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(pass);
                response.addCookie(user);
            }
            response.sendRedirect("Home");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
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
