package Controlador;

import dao.TerminadoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Terminado;

public class TerminadoM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idT = Integer.parseInt(request.getParameter("idT"));
        TerminadoDAO ter = new TerminadoDAO();
        try {
            ter.deleteTerminado(idT);
        } catch (SQLException ex) {
            Logger.getLogger(TerminadoM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idT = Integer.parseInt(request.getParameter("idT"));
        int supervisor = Integer.parseInt(request.getParameter("supervisor"));
        TerminadoDAO ter = new TerminadoDAO();
        Terminado terminado = new Terminado();
        try {
            terminado = ter.getTerminadoById(idT);
        } catch (SQLException ex) {
            Logger.getLogger(TerminadoM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (supervisor != 0) {
            terminado.setSupervisor(supervisor);
        }
        try {
            ter.updateTerminado(terminado);
        } catch (SQLException ex) {
            Logger.getLogger(TerminadoM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }

}
