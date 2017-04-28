/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.AficionFacade;
import entity.Aficion;
import java.io.IOException;
import java.math.BigDecimal;
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
 * @author Roberto Sanchez
 */
@WebServlet(name = "ServletGuardarAficion", urlPatterns = {"/GuardarAficion"})
public class ServletGuardarAficion extends HttpServlet {

    @EJB
    private final AficionFacade aficionFacade;
    
    public ServletGuardarAficion() {
        aficionFacade = new AficionFacade();
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
        String nombreAficion = request.getParameter("nombreAficion");
        String anterior = request.getParameter("anterior");
        String next = "/EditarAficiones";
        
        if (usuarioId != null) {
            if (anterior != null && !anterior.isEmpty()) {
                Aficion origen = aficionFacade.findByIdUsuarioAndNombreAficion(usuarioId, anterior);
                if (origen != null) {
                    if (nombreAficion != null && !nombreAficion.isEmpty()) {
                        Aficion destino = aficionFacade.findByIdUsuarioAndNombreAficion(usuarioId, nombreAficion);
                        if (destino != null) {
                            aficionFacade.remove(origen);
                        } else {
                            // Se que hacer un edit mediante remove/create no es precisamente elegante, pero en este caso esta justificado.
                            // El atributo nombre de AficionPK esta definido como clave primaria, por lo que no nos permite modificar ese
                            // valor una vez introducido. El error generado al tratar de hacer un edit es el siguiente:
                            // %>    The attribute [nombre] of class [entity.AficionPK] is mapped to a primary key column in the database
                            // Por este motivo, y debido a que se quiere dotar de dicha funcionalidad a la aplicacion, debemos recurrir a
                            // esta estrategia para poder "actualizar" el nombre de una aficion.
                            aficionFacade.remove(origen);
                            destino = new Aficion(nombreAficion, usuarioId);
                            aficionFacade.create(destino);
                        }
                    } else {
                        next = "/Logout";
                    }
                } else {
                    next = "/Logout";
                }
            } else {
                if (nombreAficion != null && !nombreAficion.isEmpty()) {
                    Aficion destino = aficionFacade.findByIdUsuarioAndNombreAficion(usuarioId, nombreAficion);
                    if (destino == null) {
                        Aficion nueva = new Aficion(nombreAficion, usuarioId);
                        aficionFacade.create(nueva);
                    }
                } else {
                    next = "/Logout";
                }
            }
        } else {
            next = "/Logout";
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