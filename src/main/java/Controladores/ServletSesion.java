/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

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
@WebServlet(name = "ServletSesion", urlPatterns = {"/ServletSesion"})
public class ServletSesion extends HttpServlet {

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
                 try {
 
            HttpSession misession= (HttpSession) request.getSession();
            misession.removeAttribute("usuario");
            misession.removeAttribute("estado");
            misession.invalidate();
            PrintWriter out = response.getWriter();
            String msg;
            String html1 = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>TODO supply a title</title>\n"
                        + "        <link rel=\"stylesheet\" \n"
                        + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "        <div class=\"container\">\n"
                        + "            <br><br><br>\n"
                        + "            <div class=\"alert alert-warning d-flex align-items-center mt-10\" role=\"alert\">\n"
                        + "                <svg class=\"bi flex-shrink-0 me-2\" width=\"24\" height=\"24\" role=\"img\" aria-label=\"Danger:\">\n"
                        + "                    <use xlink:href=\"#exclamation-triangle-fill\"/>\n"
                        + "                </svg>\n"
                        + "                <div>\n";
            String html2 = "                    <a href=\"index.html\" class=\"alert-link\">INICIO</a>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "\n"
                        + "\n"
                        + "        </div>\n"
                        + "    </body>\n"
                        + "</html>";

            msg = "USTED HA CERRADO SESIÓN ==> \n";
            out.print(html1+msg+html2);
        }finally{}

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
