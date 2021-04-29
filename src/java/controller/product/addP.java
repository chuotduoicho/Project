/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import dal.GroupProductDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GroupProduct;
import model.Product;

/**
 *
 * @author Admin
 */
public class addP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

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
        GroupProductDAO db1 = new GroupProductDAO();
        ArrayList<GroupProduct> GroupProducts = db1.list();
        request.setAttribute("GroupProducts", GroupProducts);
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
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
        String name = request.getParameter("namep");
        String detail = request.getParameter("detailp");
        String image = request.getParameter("imagep");
        Date date = Date.valueOf(request.getParameter("datep"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        float price=Float.parseFloat(request.getParameter("pricep"));
        ProductDAO db = new ProductDAO();
//        GroupProduct g=new GroupProduct();
//        Product s=new Product();
//        s.setName(name);
//        s.setImage(image);
//        s.setDetail(detail);
//        s.setPrice(price);
//        s.setDate(date);
//        g.setId(bid);
//        s.setGroupProduct(g);
        db.insert2(name, detail, price, image, date, bid);
        response.sendRedirect("Home");
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
