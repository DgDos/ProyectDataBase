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

public class EmpresaM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        int idE = Integer.parseInt(request.getParameter("empresa"));
        EmpresaClienteDAO e = new EmpresaClienteDAO();
        if (usuario.equals("root") && password.equals("root")) {
            try {
                e.deleteEmpresa(idE);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioM.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("menu.html");
            
        } else {
            ArrayList<EmpresaCliente> empresas = new ArrayList<>();
            try {
                empresas = e.getAllEmpresas();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("empresas", empresas);
            request.setAttribute("respuesta", "Aqui hay algo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EmpresaD.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idU= Integer.parseInt(request.getParameter("updated"));
        String nombre=request.getParameter("empresa");
        String pass=request.getParameter("password");
        String direccion=request.getParameter("direccion");
        EmpresaClienteDAO e=new EmpresaClienteDAO();
        EmpresaCliente empresaM=new EmpresaCliente();
        try {
            empresaM=e.getEmpresaById(idU);
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!nombre.equals("")){
            empresaM.setNombreEmpresa(nombre);
        }
        if(!pass.equals("")){
            empresaM.setPasswordE(pass);
        }
        if(!direccion.equals("")){
            empresaM.setDireccion(direccion);
        }
        try {
            e.updateEmpresa(empresaM);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioM.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("menu.html");
    }
}
