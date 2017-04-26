/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.MensajeFacade;
import ejb.UsuarioFacade;
import entity.Mensaje;
import entity.Usuario;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
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
@WebServlet(name = "ServletCargarPrincipal", urlPatterns = {"/Principal"})
public class ServletCargarPrincipal extends HttpServlet {
    
    @EJB
    private final UsuarioFacade usuarioFacade;
    
    @EJB
    private MensajeFacade mensajeFacade;
    
    public ServletCargarPrincipal() {
        usuarioFacade = new UsuarioFacade();
        mensajeFacade = new MensajeFacade();
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
        HttpSession session = request.getSession();
        BigDecimal id = (BigDecimal) session.getAttribute("usuarioId");
        String next;
        
        if (id != null) {
            Usuario u = usuarioFacade.find(id);
            
            Collection<Mensaje> mensajes = new ArrayList<Mensaje>();
            mensajes = mensajeFacade.findByVistoYReceptor('F', u);
            request.setAttribute("mensajes", new ArrayList<Mensaje>(mensajes));
            
            next = "/principal.jsp";
        } else {
            next = "/error.jsp";
        }
        
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