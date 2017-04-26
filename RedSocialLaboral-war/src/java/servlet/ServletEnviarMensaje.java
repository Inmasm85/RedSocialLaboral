/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ejb.MensajeFacade;
import ejb.UsuarioFacade;
import entity.Mensaje;
import entity.Usuario;

/**
 *
 * @author anton
 */
@WebServlet(name = "ServletEnviarMensaje", urlPatterns = {"/ServletEnviarMensaje"})
public class ServletEnviarMensaje extends HttpServlet {

    @EJB
    private MensajeFacade mensajeFacade;

    @EJB
    private UsuarioFacade usuarioFacade;
    
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    
    public ServletEnviarMensaje(){
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

        BigDecimal idDestinatario = new BigDecimal(request.getParameter("destinatario"));
        String texto = (String)request.getParameter("mensaje");
        Usuario usuario = usuarioFacade.find(id);
        Usuario receptor = usuarioFacade.find(idDestinatario);
        Date fechaHora = new Date(System.currentTimeMillis());
        
        Mensaje mensaje = new Mensaje();
        
        mensaje.setMensaje(texto);
        mensaje.setEmisor(usuario);
        mensaje.setReceptor(receptor);
        mensaje.setFecha(fechaHora);
        mensaje.setVisto("F".charAt(0));
        
        mensajeFacade.create(mensaje);
        
        response.sendRedirect("ServletMostrarMensajesEnviados");
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
