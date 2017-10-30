package Controlador;

import dao.EmpresaClienteDAO;
import dao.ServicioDAO;
import dao.TrabajoARealizarDAO;
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
import model.EmpresaCliente;
import model.Servicio;
import model.TrabajoARealizar;

public class TrabajoARealizarC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("create")) {
            ServicioDAO s = new ServicioDAO();
            ArrayList<Servicio> servicios = new ArrayList<>();
            EmpresaClienteDAO e = new EmpresaClienteDAO();
            ArrayList<EmpresaCliente> empresas = new ArrayList<>();
            try {
                servicios = s.getAllServicios();
                empresas = e.getAllEmpresas();
            } catch (SQLException ex) {
                Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("empresas", empresas);
            request.setAttribute("servicios", servicios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRC.jsp");
            rd.forward(request, response);
        }
        TrabajoARealizarDAO t = new TrabajoARealizarDAO();
        ArrayList<TrabajoARealizar> trabajos = new ArrayList<>();
        try {
            trabajos = t.getAllTrabajosARealizar();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("trabajos", trabajos);
        if (action.equals("update")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TaRD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idE = Integer.parseInt(request.getParameter("idE"));
        int idS = Integer.parseInt(request.getParameter("idS"));
        int urgencia = Integer.parseInt(request.getParameter("urgencia"));
        String detalles = request.getParameter("detalles");
        TrabajoARealizarDAO t = new TrabajoARealizarDAO();
        TrabajoARealizar tar = new TrabajoARealizar(0, idE, idS, urgencia, detalles, 0);
        try {
            t.addTrabajoARealizar(tar);
        } catch (SQLException ex) {
            Logger.getLogger(TrabajoARealizarC.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }

}
