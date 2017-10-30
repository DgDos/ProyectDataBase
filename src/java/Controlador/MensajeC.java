package Controlador;

import dao.MensajeDAO;
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
import model.Mensaje;
import model.Trabajador;

public class MensajeC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        TrabajadorDAO t = new TrabajadorDAO();
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        try {
            trabajadores = t.getAllTrabajadores();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("usuarios", trabajadores);
        if (action.equals("create")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/MensajeC.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/MensajeU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/MensajeD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idU1 = Integer.parseInt(request.getParameter("idU1"));
        int idU2 = Integer.parseInt(request.getParameter("idU2"));
        String Asunto = request.getParameter("asunto");
        String Texto = request.getParameter("texto");
        if (idU1 == idU2) {
            TrabajadorDAO t = new TrabajadorDAO();
            ArrayList<Trabajador> trabajadores = new ArrayList<>();
            try {
                trabajadores = t.getAllTrabajadores();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("usuarios", trabajadores);
            request.setAttribute("invalido", "invalido");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/MensajeC.jsp");
            rd.forward(request, response);
        } else {
            MensajeDAO mdao = new MensajeDAO();
            Mensaje m = new Mensaje(idU1, idU2, Asunto, Texto);
            try {
                mdao.addMensaje(m);
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        }
    }

}
