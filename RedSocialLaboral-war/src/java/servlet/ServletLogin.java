/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.UsuarioFacade;
import entity.Usuario;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roberto
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/Login"})
public class ServletLogin extends HttpServlet {
    
    @EJB
    private final UsuarioFacade usuarioFacade;
    
    public ServletLogin() {
        usuarioFacade = new UsuarioFacade();
    }

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
        Usuario u = new Usuario();
        
        int error = 0;
        String email = request.getParameter("email");
        String pass =  request.getParameter("pass");
        
        if (email != null && !email.isEmpty()) {
            u.setEmail(email);
        } else {
            u.setEmail("");
            error = 1;
        }
        
        if (pass != null && !pass.isEmpty()) {
            u.setPass(pass);
        } else {
            u.setPass("");
            error += 2;
        }
        
        if (error == 0) {
            u = usuarioFacade.findByEmail(email);
            if (u == null || !pass.equals(u.getPass())) {
                error = 4;
            }
        }
        
        String next;
        if (error == 0) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioId", u.getId());
            next = "/Principal";
        } else {
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            next =  "/login.jsp";
        }
        request.setAttribute("error", new Integer(error));
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(next);
        rd.forward(request, response);
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
