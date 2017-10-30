package Controlador;

import dao.ServicioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Servicio;

public class ServicioC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ServicioDAO s = new ServicioDAO();
        ArrayList<Servicio> servicios = new ArrayList<>();
        try {
            servicios = s.getAllServicios();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("servicios", servicios);
        if (action.equals("create")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServicioC.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServicioU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServicioD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServicioDAO s = new ServicioDAO();
        ArrayList<Servicio> servicios = new ArrayList<>();
        try {
            servicios = s.getAllServicios();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        String servicio = request.getParameter("servicio");
        boolean t = true;
        for (Servicio ser : servicios) {
            if (ser.getNombreS().equalsIgnoreCase(servicio)) {
                t = false;
                break;
            }
        }
        if (t) {
            Servicio ser = new Servicio(servicio);
            try {
                s.addServicio(ser);
            } catch (SQLException ex) {
                Logger.getLogger(ServicioC.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        } else {
            request.setAttribute("servicios", servicios);
            request.setAttribute("Respuesta", "Ese servicio ya esta creado");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServicioC.jsp");
            rd.forward(request, response);
        }
    }

}
