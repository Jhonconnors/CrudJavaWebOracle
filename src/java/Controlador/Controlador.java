/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author J Connors
 */
public class Controlador extends HttpServlet {

    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona();
    
    
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String accion=request.getParameter("accion");
        switch (accion){
            case "Listar":
                List<Persona>datos = dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "Guardar":
                String id = request.getParameter("txtid");
                String nom = request.getParameter("txtnom");
                String correo = request.getParameter("txtcorreo");
                String tel = request.getParameter("txttelefono");
                p.setId(id);
                p.setNom(nom);
                p.setCorreo(correo);
                p.setTel(tel);
                dao.agregar(p);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Editar":
                String ide=request.getParameter("id");
                Persona pe = dao.listarId(ide);
                request.setAttribute("persona", pe);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                 break;
            case "Actualizar":
                String id1 = request.getParameter("txtid");
                String nom1 = request.getParameter("txtnom");
                String correo1 = request.getParameter("txtcorreo");
                String tel1 = request.getParameter("txttelefono");
                p.setId(id1);
                p.setNom(nom1);
                p.setCorreo(correo1);
                p.setTel(tel1);
                dao.actualizar(p);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Delete":
               String id2 = request.getParameter("id");
               dao.delete(id2);
               request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
                
        }
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
