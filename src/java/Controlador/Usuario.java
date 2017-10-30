package Controlador;

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
import model.Trabajador;

public class Usuario extends HttpServlet {

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
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioC.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrabajadorDAO t = new TrabajadorDAO();
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        try {
            trabajadores = t.getAllTrabajadores();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        String usuarioT = request.getParameter("usuario");
        boolean tr = true;
        for (Trabajador u : trabajadores) {
            if (usuarioT.equalsIgnoreCase(u.getUsuarioT())) {
                tr = false;
                break;
            }
        }
        if (tr) {
            String passwordT = request.getParameter("password");
            String nombre = request.getParameter("trabajador");
            String cargo = request.getParameter("cargo");
            int supervisor = Integer.parseInt(request.getParameter("supervisor"));
            Trabajador trabajador = new Trabajador();
            trabajador.setUsuarioT(usuarioT);
            trabajador.setPasswordT(passwordT);
            trabajador.setNombre(nombre);
            trabajador.setCargo(cargo);
            trabajador.setSupervisor(supervisor);
            t = new TrabajadorDAO();
            try {
                t.addTrabajador(trabajador);
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        } else {
            request.setAttribute("usuarios", trabajadores);
            request.setAttribute("respuesta", "Hay algo aqui");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioC.jsp");
            rd.forward(request, response);
        }

    }

}
