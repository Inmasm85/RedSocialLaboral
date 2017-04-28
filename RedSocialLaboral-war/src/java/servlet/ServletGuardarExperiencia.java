/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.ExperienciaFacade;
import ejb.UsuarioFacade;
import entity.Experiencia;
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
 * @author Antonio Joaquín Luque
 */
@WebServlet(name = "ServletGuardarExperiencia", urlPatterns = {"/GuardarExperiencia"})
public class ServletGuardarExperiencia extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private ExperienciaFacade experienciaFacade;
    
    public ServletGuardarExperiencia() {
        experienciaFacade = new ExperienciaFacade();
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
        if(usuarioId != null){
            Usuario u = usuarioFacade.find(usuarioId);
            Experiencia e;
            str = request.getParameter("experienciaId");
            BigDecimal experienciaId;
            if(str!=null && !str.isEmpty()) experienciaId = new BigDecimal(str);
            else experienciaId = new BigDecimal(-1);
            
            if(experienciaId.equals(BigDecimal.valueOf(-1))) e = new Experiencia();
            else e = experienciaFacade.find(experienciaId);
            
            e.setUsuario(u);
            if(e!=null){
                str = request.getParameter("fechaInicio");
                if(str!=null && !str.isEmpty()) e.setFechainicio(new Date(str));
                str = request.getParameter("fechaFin");
                if(str!=null && !str.isEmpty()) e.setFechafin(new Date(str));
                str = request.getParameter("empresa");
                e.setEmpresa(str);
                str = request.getParameter("puesto");
                e.setPuesto(str);
                str = request.getParameter("webEmpresa");
                e.setWebempresa(str);
                
                if(experienciaId.equals(BigDecimal.valueOf(-1))) experienciaFacade.create(e);
                else experienciaFacade.edit(e);
                
                str = "/EditarExperiencia";
            }else str = "/Logout";
        }else{
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
