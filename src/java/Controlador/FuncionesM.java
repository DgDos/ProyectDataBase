package Controlador;

import dao.FuncionesDAO;
import dao.ServicioDAO;
import dao.TrabajadorDAO;
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
import model.Funciones;
import model.Servicio;
import model.Trabajador;

public class FuncionesM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("idU"));
        int idS = Integer.parseInt(request.getParameter("idS"));
        FuncionesDAO f = new FuncionesDAO();
        try {
            f.deleteFunciones(idU, idS);
        } catch (SQLException ex) {
            Logger.getLogger(MensajeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("idU"));
        int idS = Integer.parseInt(request.getParameter("idS"));
        String valoracion = request.getParameter("valoracion");
        FuncionesDAO f = new FuncionesDAO();
        Funciones funcionU = new Funciones();
        try {
            funcionU = f.getFuncionesByIds(idS, idU);
        } catch (SQLException ex) {
            Logger.getLogger(MensajeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (funcionU != null) {
            if (!valoracion.equals("")) {
                funcionU.setValoracion(Integer.parseInt(valoracion));
            }
            try {
                f.updateFunciones(funcionU);
            } catch (SQLException ex) {
                Logger.getLogger(MensajeM.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        } else {
            ServicioDAO s = new ServicioDAO();
            ArrayList<Servicio> servicios = new ArrayList<>();
            TrabajadorDAO t = new TrabajadorDAO();
            ArrayList<Trabajador> usuarios = new ArrayList<>();
            try {
                servicios = s.getAllServicios();
                usuarios = t.getAllTrabajadores();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("servicios", servicios);
            request.setAttribute("respuesta", "algooo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/FuncionU.jsp");
            rd.forward(request, response);
        }

    }
}
