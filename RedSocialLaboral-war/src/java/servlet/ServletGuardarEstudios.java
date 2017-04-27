/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.EstudiosFacade;
import ejb.UsuarioFacade;
import entity.Estudios;
import entity.Usuario;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
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
@WebServlet(name = "ServletGuardarEstudios", urlPatterns = {"/GuardarEstudios"})
public class ServletGuardarEstudios extends HttpServlet {

    @EJB
    private final UsuarioFacade usuarioFacade;

    @EJB
    private final EstudiosFacade estudiosFacade;
    
    
    
    public ServletGuardarEstudios() {
        estudiosFacade = new EstudiosFacade();
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
        BigDecimal usuarioId = (BigDecimal) session.getAttribute("usuarioId");
        String str;
        if (usuarioId != null) {
            Usuario u = usuarioFacade.find(usuarioId);
            Estudios e;
            str = request.getParameter("estudiosId");
            BigDecimal estudiosId;
            if (str != null && !str.isEmpty()) {
                estudiosId = new BigDecimal(str);
            } else {
                estudiosId = new BigDecimal(-1);
            }
            
            if (estudiosId.equals(BigDecimal.valueOf(-1))) {
                e = new Estudios();
            } else {
                e = estudiosFacade.find(estudiosId);
            }
            if (e != null) {
                e.setUsuario(u);
                str = request.getParameter("fechaInicio");
                if (str != null && !str.isEmpty()) {
                    e.setFechainicio(new Date(str));
                }
                str = request.getParameter("fechaFin");
                if (str != null && !str.isEmpty()) {
                    e.setFechafin(new Date(str));
                }
                str = request.getParameter("ubicacion");
                e.setUbicacion(str);
                str = request.getParameter("descripcion");
                e.setDescripcion(str);
                if (estudiosId.equals(BigDecimal.valueOf(-1))) {
                    estudiosFacade.create(e);
                } else {
                    estudiosFacade.edit(e);
                }
                str = "/EditarEstudios";
            } else {
                str = "/Logout";
            }
        } else {
            str = "/Logout";
        }
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(str);
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