package Controlador;

import dao.TrabajoARealizarDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TrabajoARealizar;

public class TrabajoARealizarM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idT = Integer.parseInt(request.getParameter("idT"));
        TrabajoARealizarDAO t = new TrabajoARealizarDAO();
        try {
            t.deleteTrabajoARealizar(idT);
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoARealizarM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idT = Integer.parseInt(request.getParameter("idT"));
        String urgencia = request.getParameter("urgencia");
        String detalles = request.getParameter("detalles");
        TrabajoARealizarDAO t = new TrabajoARealizarDAO();
        TrabajoARealizar trabajo = new TrabajoARealizar();
        try {
            trabajo = t.getTrabajoARealizarById(idT);
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoARealizarM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!detalles.equals("")) {
            trabajo.setDetalles(detalles);
        }
        if (!urgencia.equals("0")) {
            trabajo.setUrgencia(Integer.parseInt(urgencia));
        }
        try {
            t.updateTrabajoARealizar(trabajo);
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoARealizarM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }
}
