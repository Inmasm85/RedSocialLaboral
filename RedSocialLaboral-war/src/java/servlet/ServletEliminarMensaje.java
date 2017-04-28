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
 * @author Antonio Joaquín Luque
 */
@WebServlet(name = "ServletEliminarMensaje", urlPatterns = {"/ServletEliminarMensaje"})
public class ServletEliminarMensaje extends HttpServlet {

    @EJB
    private MensajeFacade mensajeFacade;

    @EJB
    private UsuarioFacade usuarioFacade;
    
    public ServletEliminarMensaje(){
        mensajeFacade = new MensajeFacade();
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
        
        HttpSession session = request.getSession();
        
        BigDecimal id = (BigDecimal) session.getAttribute("usuarioId");
        
        Usuario usuario = usuarioFacade.find(id);
        Collection<Mensaje> mensajes = new ArrayList<Mensaje>();
        
        BigDecimal idMensaje = new BigDecimal(request.getParameter("mensaje"));
        String servlet = (String)request.getParameter("servlet");
        Mensaje mensaje = mensajeFacade.find(idMensaje);
        mensajeFacade.remove(mensaje);
        
        if(servlet.equals("ServletMostrarMensajesRecibidos")) mensajes = mensajeFacade.findByReceptor(usuario);
        else mensajes = mensajeFacade.findByEmisor(usuario);

        request.setAttribute("servlet", servlet);        
        request.setAttribute("mensajes", new ArrayList<Mensaje>(mensajes));
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/pantallaMensajes.jsp");
        rd.forward(request, response);
        //response.sendRedirect(request.getContextPath() + "/ServletMostrarMensajes");

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
