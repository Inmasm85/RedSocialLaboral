/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.UsuarioFacade;
import entity.Usuario;
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
@WebServlet(name = "ServletGuardarUsuario", urlPatterns = {"/Guardar"})
public class ServletGuardarUsuario extends HttpServlet {
    
    @EJB
    private final UsuarioFacade usuarioFacade;
    
    public ServletGuardarUsuario() {
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
        
        int error = 0;
        String email = request.getParameter("email");
        if (email == null || email.isEmpty()) {
            error = 1; // error = [1 3 5 7]
        }
        String pass = request.getParameter("pass");
        if (pass == null || pass.isEmpty()) {
            error += 2; // error = [2 3 6 7]
        }
        String nombre = request.getParameter("nombre");
        if (nombre == null || nombre.isEmpty()) {
            error += 4; // error = [4 5 6 7]
        }
        String apellidos = request.getParameter("apellidos");
        String twitter = request.getParameter("twitter");
        String instagram = request.getParameter("instagram");
        String web = request.getParameter("web");
        String foto = request.getParameter("foto");
        
        Usuario u;
        String next = "/Principal";
        if (error == 0) {
            Boolean nuevo = Boolean.FALSE;
            if (id == null) {
                u = new Usuario();
                nuevo = Boolean.TRUE;
                next = "/login.jsp";
            } else {
                u = usuarioFacade.find(id);
            }
            u.setEmail(email);
            u.setPass(pass);
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setTwitter(twitter);
            u.setInstagram(instagram);
            u.setWeb(web);
            u.setFoto(foto);
            if (nuevo) {
                usuarioFacade.create(u);
            } else {
                usuarioFacade.edit(u);
            }
        } else {
            request.setAttribute("error", error);
            next = "/editarPerfil.jsp";
            // COMPLETAR
            // Faltan datos para del insert y se vuelve al jsp correspondiente
            // indicando los campos que faltan por rellenar
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
