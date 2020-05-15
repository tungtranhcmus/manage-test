package web;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MEOW
 */
@WebServlet(urlPatterns = {"/back"})
public class back extends HttpServlet {

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
        processRequest(request, response);
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
            HttpSession session = request.getSession();
            int a = Integer.parseInt(session.getAttribute("CH").toString());
            String name = session.getAttribute("username").toString();
            String cautraloi = String.valueOf(request.getParameter("traloi"));
            String action = request.getParameter("submit");
            if("Back".equals(action) || "Next".equals(action)){
                if(SQL.KiemTraCauTL(name, a)){
                    if(request.getParameter("traloi") != null)
                        SQL.updateCTL(name, a, cautraloi);
                }else{
                    if(request.getParameter("traloi") != null)
                        SQL.inserCautraloi(name, a, cautraloi);
                }
            }
            if ("Back".equals(action)) {
                if(a>1)
                    a--;
            } else if ("Next".equals(action)) {
                if(a<SQL.DemCauHoi())
                    a++;
            }else if("Exit".equals(action)){
                session.invalidate();
                RequestDispatcher dispatcher = request.getRequestDispatcher("batdau.jsp");
                dispatcher.forward(request, response);
            }
            
            session.setAttribute("CH", a);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dangnhap.jsp");
            dispatcher.forward(request, response);

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
