
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.GroupProductDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.GroupProduct;
import model.Product;

/**
 *
 * @author Admin
 */
public class LoadHomePage extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadHomePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadHomePage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        String name = request.getParameter("name");
        String pa_sale = request.getParameter("sale");
        String pa_raw_from = request.getParameter("from");
        String pa_raw_to = request.getParameter("to");
        String pa_bid = request.getParameter("bid");
        Boolean sale = null;
        Float from = null;
        Float to = null;
        GroupProduct gr = null;
        if (pa_raw_from != null && !pa_raw_from.equals("")) {
            from = Float.valueOf(pa_raw_from);
        }
        if (pa_raw_to != null && !pa_raw_to.equals("")) {
            to = Float.valueOf(pa_raw_to);
        }
        if (pa_sale != null) {
            sale = pa_sale.equals("sale");
        }
        if (pa_bid != null && !pa_bid.equals("-1")) {
            int bid = Integer.parseInt(pa_bid);
            gr = new GroupProduct();
            gr.setId(bid);
        }
        int pagesize = 12;
        String raw_pageindex = request.getParameter("page");
        if (raw_pageindex == null || raw_pageindex.equals("")) {
            raw_pageindex = "1";
        }
        int pageindex = Integer.parseInt(raw_pageindex);
        ProductDAO db = new ProductDAO();
        ArrayList<Product> Products = db.search(name, sale, from, to, gr, pagesize, pageindex);
        int totalRows = db.count();
        int totalPage = totalRows / pagesize + (totalRows % pagesize > 0 ? 1 : 0);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("Products", Products)  ;
        GroupProductDAO db1 = new GroupProductDAO();
        ArrayList<GroupProduct> GroupProducts = db1.list();
        request.setAttribute("GroupProducts", GroupProducts);
        Account account = (Account) request.getSession().getAttribute("user");
        if(account!=null){    
        CartDAO db3 = new CartDAO();     
         request.setAttribute("countc",db3.count(account.getUsername()) );
        }
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
