package Controlador;

import dao.HorarioDAO;
import dao.TrabajadorDAO;
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
import model.Horario;
import model.Trabajador;
import model.TrabajoARealizar;

public class HorarioC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("delete")) {
            HorarioDAO h = new HorarioDAO();
            ArrayList<Horario> horarios = new ArrayList();
            try {
                horarios = h.getAllHorarios();
            } catch (SQLException ex) {
                Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("horarios", horarios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioD.jsp");
            rd.forward(request, response);
        }
        TrabajadorDAO u = new TrabajadorDAO();
        ArrayList<Trabajador> usuarios = new ArrayList<>();
        TrabajoARealizarDAO t = new TrabajoARealizarDAO();
        ArrayList<TrabajoARealizar> trabajos = new ArrayList();
        HorarioDAO h = new HorarioDAO();
        ArrayList<Horario> horarios = new ArrayList();
        try {
            trabajos = t.getAllTrabajosARealizar();
            usuarios = u.getAllTrabajadores();
            horarios = h.getAllHorarios();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (action.equals("create")) {
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("trabajos", trabajos);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            request.setAttribute("horarios", horarios);
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioU.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!(request.getParameter("horaI1")).equals("-") && !(request.getParameter("horaI2")).equals("-")
                && !(request.getParameter("horaF1")).equals("-") && !(request.getParameter("horaF2")).equals("-")
                && !(request.getParameter("fechaD")).equals("-") && !(request.getParameter("fechaM")).equals("-")
                && !(request.getParameter("fechaA")).equals("-")) {
            int idT = Integer.parseInt(request.getParameter("idT"));
            int idU = Integer.parseInt(request.getParameter("idU"));
            String horaInicial = request.getParameter("horaI1") + "" + request.getParameter("horaI2");
            int horaI = Integer.parseInt(horaInicial);
            String horaFinal = request.getParameter("horaF1") + "" + request.getParameter("horaF2");
            int horaF = Integer.parseInt(horaFinal);
            String fecha = request.getParameter("fechaD") + "/" + request.getParameter("fechaM") + "/" + request.getParameter("fechaA");
            HorarioDAO h = new HorarioDAO();
            Horario horario = new Horario(0, idT, idU, horaI, horaF, fecha, 0);
            try {
                h.addHorario(horario);
            } catch (SQLException ex) {
                Logger.getLogger(HorarioC.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        } else {
            TrabajadorDAO u = new TrabajadorDAO();
            ArrayList<Trabajador> usuarios = new ArrayList<>();
            TrabajoARealizarDAO t = new TrabajoARealizarDAO();
            ArrayList<TrabajoARealizar> trabajos = new ArrayList();
            try {
                trabajos = t.getAllTrabajosARealizar();
                usuarios = u.getAllTrabajadores();
            } catch (SQLException ex) {
                Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("respuesta", "aqui hay algo");
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("trabajos", trabajos);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/HorarioC.jsp");
            rd.forward(request, response);
        }
    }
}
