package Controlador;

import dao.EmpresaClienteDAO;
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

public class EmpresaC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        EmpresaClienteDAO e = new EmpresaClienteDAO();
        ArrayList<EmpresaCliente> empresas = new ArrayList<>();
        try {
            empresas = e.getAllEmpresas();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("empresas", empresas);
        if (action.equals("update")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EmpresaU.jsp");
            rd.forward(request, response);
        }
        if (action.equals("delete")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EmpresaD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuarioE = request.getParameter("usuario");
        String passwordE = request.getParameter("password");
        String nombre = request.getParameter("nombreE");
        int NIT = Integer.parseInt(request.getParameter("NIT"));
        String direccion = request.getParameter("direccion");
        EmpresaClienteDAO e = new EmpresaClienteDAO();
        ArrayList<EmpresaCliente> empresas = new ArrayList<>();
        try {
            empresas = e.getAllEmpresas();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaC.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean t = true;
        for (EmpresaCliente empresa : empresas) {
            if (empresa.getNIT() == NIT) {
                t = false;
                request.setAttribute("nit", "nit");
            }
            if (empresa.getUsuarioE().equalsIgnoreCase(usuarioE)) {
                t = false;
                request.setAttribute("usuarioE", "usuarioE");
            }
        }
        if (t) {
            EmpresaCliente empresa = new EmpresaCliente(NIT, nombre, usuarioE, passwordE, direccion, 0);
            try {
                e.addEmpresa(empresa);
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EmpresaC.jsp");
            rd.forward(request, response);
        }

    }

}
