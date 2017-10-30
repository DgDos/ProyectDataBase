package Controlador;

import dao.HorarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Horario;

public class HorarioM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idH = Integer.parseInt(request.getParameter("idH"));
        HorarioDAO h = new HorarioDAO();
        try {
            h.deleteHorario(idH);
        } catch (SQLException ex) {
            Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idH = Integer.parseInt(request.getParameter("idH"));
        int idU = Integer.parseInt(request.getParameter("idU"));
        String horaInicial = request.getParameter("horaI1") + "" + request.getParameter("horaI2");

        String horaFinal = request.getParameter("horaF1") + "" + request.getParameter("horaF2");

        String fecha = request.getParameter("fechaD") + "/" + request.getParameter("fechaM") + "/" + request.getParameter("fechaA");
        HorarioDAO h = new HorarioDAO();
        Horario horario = new Horario();
        try {
            horario = h.getHorarioById(idH);
        } catch (SQLException ex) {
            Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (idU != 0) {
            horario.setIdTrabajador(idU);
        }
        if (!(request.getParameter("horaI1")).equals("-") && !(request.getParameter("horaI2")).equals("-")) {
            int horaI = Integer.parseInt(horaInicial);
            horario.setHoraInicio(horaI);
        }
        if (!(request.getParameter("horaF1")).equals("-") && !(request.getParameter("horaF2")).equals("-")) {
            int horaF = Integer.parseInt(horaFinal);
            horario.setHoraFinal(horaF);
        }
        if (!(request.getParameter("fechaD")).equals("-") && !(request.getParameter("fechaM")).equals("-") && !(request.getParameter("fechaA")).equals("-")) {
            horario.setFecha(fecha);
        }
        try {
            h.updateHorario(horario);
        } catch (SQLException ex) {
            Logger.getLogger(HorarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }
}
