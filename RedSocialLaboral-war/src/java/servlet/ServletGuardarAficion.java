/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.AficionFacade;
import entity.Aficion;
import entity.AficionPK;
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
        String str = request.getParameter("nombreAficion");
        if (usuarioId != null) {
            String anterior = request.getParameter("anterior");
            Aficion a;            
            if (str != null && !str.isEmpty()) {
                if (anterior != null && !anterior.isEmpty()) {
                    if (!str.equals(anterior)) {
                        a = aficionFacade.findByIdUsuarioAndNombreAficion(usuarioId, anterior);
                        if (a != null) {
                            aficionFacade.remove(a);
                            a = aficionFacade.findByIdUsuarioAndNombreAficion(usuarioId, str);
                            if (a == null) {
                                AficionPK apk = new AficionPK(str, usuarioId);
                                a = new Aficion(apk);
                                aficionFacade.create(a);
                            }
                            str = "/EditarAficiones";
                        } else {
                            str = "/Logout";
                        }
                    } else {
                        str = "/EditarAficiones";
                    }
                } else {
                    a = aficionFacade.findByIdUsuarioAndNombreAficion(usuarioId, str);
                    if (a == null) {
                        AficionPK apk = new AficionPK(str, usuarioId);
                        a = new Aficion(apk);
                        aficionFacade.create(a);
                    }
                    str = "/EditarAficiones";
                }
            } else {
                str = "/Logout";
            }
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