package Controlador;

import dao.HorarioDAO;
import dao.TerminadoDAO;
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
import model.Horario;
import model.Terminado;
import model.Trabajador;

public class TerminadoC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        TrabajadorDAO t = new TrabajadorDAO();
        ArrayList<Trabajador> usuarios = new ArrayList<>();
        HorarioDAO h = new HorarioDAO();
        ArrayList<Horario> horarios = new ArrayList();
        TerminadoDAO ter = new TerminadoDAO();
        ArrayList<Terminado> terminados = new ArrayList();
        try {
            horarios = h.getAllHorarios();
            terminados = ter.getAllTerminados();
            usuarios = t.getAllTrabajadores();
        } catch (SQLException ex) {
            Logger.getLogger(TerminadoM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (action.equals("create")) {
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("horarios", horarios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TerminadoC.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("terminados", terminados);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TerminadoU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            request.setAttribute("terminados", terminados);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TerminadoD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idH = Integer.parseInt(request.getParameter("idH"));
        String fechaTerminado = request.getParameter("fechaT");
        int supervisor = Integer.parseInt(request.getParameter("supervisor"));
        TerminadoDAO ter = new TerminadoDAO();
        Terminado t = new Terminado(idH, fechaTerminado, "rs", supervisor, 0);
        try {
            ter.addTerminado(t);
        } catch (SQLException ex) {
            Logger.getLogger(TerminadoC.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }

}
