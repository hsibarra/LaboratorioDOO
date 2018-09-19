package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             String ip = null;
	   
            ip = InetAddress.getLocalHost().getHostAddress();
            
            Calendar c = Calendar.getInstance(); 
            int dia = c.get(Calendar.DAY_OF_MONTH); 
            int mes = c.get(Calendar.MONTH)+1; 
            int anyo = c.get(Calendar.YEAR); 
            int hora, minutos, segundos;
            hora =c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);
            segundos = c.get(Calendar.SECOND);
            
            out.println( "La hora es:");
            out.println(hora + ":" + minutos + ":" + segundos);
            out.println("<br/>");
            out.println("El día de hoy es:  "+dia+"/"+mes+"/"+anyo); 
            out.println("<br/>");
            out.println("<html><head><title>Obtener su IP</title></head><body>");
            out.println("Su IP es: " + ip);
            out.println("</body></html>");
            out.println("</body></html>");
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
