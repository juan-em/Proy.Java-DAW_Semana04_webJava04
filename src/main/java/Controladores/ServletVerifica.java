/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.cBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jhons
 */
@WebServlet(name = "ServletVerifica", urlPatterns = {"/ServletVerifica"})
public class ServletVerifica extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            String xnom = request.getParameter("xnom");
            String xcla = request.getParameter("xcla");
            cBaseDatos objDB = new cBaseDatos();
            if (objDB.validarUsuario(xnom, xcla)) {
                String est = objDB.obtenerUsuario(xnom, xcla).estado;  //modifcado
                HttpSession misession = request.getSession(true);
                misession.setAttribute("usuario", xnom.toUpperCase());
                misession.setAttribute("estado", est);                    //modificado
                
                out.print("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>LINKS</title>\n"
                        + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                        + "        <link rel=\"stylesheet\" \n"
                        + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "        <br>\n"
                        + "        <div class=\"container text-center\" >\n"
                        + "            <h1>Acabas de Ingresar!</h1>\n"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"container text-center\">\n"
                        + "            <a href=\"areas.jsp\" class=\"btn btn-info w-50\">vamos a areas</a><br>\n"
                        + "            <a href=\"cargos.jsp\"  class=\"btn btn-secondary w-50\">vamos a cargos</a><br>\n"
                        + "        </div>\n"
                        + "    </body>\n"
                        + "</html>");
                
            } else {
                response.sendRedirect("/WebJava04/index.html");
            }
        } finally {            
            out.close();
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
