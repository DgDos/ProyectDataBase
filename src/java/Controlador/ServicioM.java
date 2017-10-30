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

public class ServicioM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        int idS = Integer.parseInt(request.getParameter("servicio"));
        ServicioDAO s = new ServicioDAO();
        if (usuario.equals("root") && password.equals("root")) {
            try {
                s.deleteServicio(idS);
            } catch (SQLException ex) {
                Logger.getLogger(ServicioM.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        } else {
            ArrayList<Servicio> servicios = new ArrayList<>();
            try {
                servicios = s.getAllServicios();
            } catch (SQLException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("servicios", servicios);
            request.setAttribute("respuesta", "Aqui hay algo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServicioD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idS = Integer.parseInt(request.getParameter("updated"));
        String nombre = request.getParameter("servicio");
        ServicioDAO s = new ServicioDAO();
        Servicio servicioM = new Servicio();
        try {
            servicioM = s.getServicioById(idS);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!nombre.equals("")) {
            servicioM.setNombreS(nombre);
        }
        try {
            s.updateServicio(servicioM);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }
}
