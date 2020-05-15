package web;




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
@WebServlet(urlPatterns = {"/login"})
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
            
		String username = String.valueOf(request.getParameter("username"));
		String password = String.valueOf(request.getParameter("password"));
                session.setAttribute("CH", 1);
                if(SQL.KiemTraCauTL(username, 1)){
                            CauhoiTraloi tl = SQL.LayCauTraLoi(1, username);
                            session.setAttribute("cautraloitam",tl.b);
                }
                session.setAttribute("username", username);
                String action = request.getParameter("submit");
                if ("Login".equals(action)){
                    if("admin".equals(username) && "admin".equals(password)){
                        RequestDispatcher dispatcher = request.getRequestDispatcher("dangnhapadmin.jsp");
			dispatcher.forward(request, response);
                    }
                    if(SQL.KiemDangNhap(username, password)){
                        RequestDispatcher dispatcher = request.getRequestDispatcher("dangnhap.jsp");
			dispatcher.forward(request, response);
                    }
                }
                else if ("Create".equals(action)){
                    if( SQL.KiemTraUser(username) ){
                        SQL.insertUser(username, password);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("dangnhap.jsp");
			dispatcher.forward(request, response);
                    }
                }

		response.sendRedirect(request.getContextPath()+"/batdau.jsp?error=0");
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

