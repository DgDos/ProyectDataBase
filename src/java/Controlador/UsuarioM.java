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

public class UsuarioM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        int idT = Integer.parseInt(request.getParameter("trabajador"));
        TrabajadorDAO t = new TrabajadorDAO();
        if (usuario.equals("root") && password.equals("root")) {
            try {
                t.deleteTrabajador(idT);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioM.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");

        } else {
            ArrayList<Trabajador> trabajadores = new ArrayList<>();
            try {
                trabajadores = t.getAllTrabajadores();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("usuarios", trabajadores);
            request.setAttribute("respuesta", "Aqui hay algo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("updated"));
        String trabajador = request.getParameter("trabajador");
        String cargo = request.getParameter("cargo");
        String pass = request.getParameter("password");
        int idS = Integer.parseInt(request.getParameter("supervisor"));
        TrabajadorDAO t = new TrabajadorDAO();
        Trabajador trabajadorM = new Trabajador();
        try {
            trabajadorM = t.getTrabajadorById(idU);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!trabajador.equals("")) {
            trabajadorM.setNombre(trabajador);
        }
        if (!cargo.equals("0")) {
            trabajadorM.setCargo(cargo);
        }
        if (!pass.equals("")) {
            trabajadorM.setPasswordT(pass);
        }
        if (idS != 0) {
            trabajadorM.setSupervisor(idS);
        }
        try {
            t.updateTrabajador(trabajadorM);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }
}
