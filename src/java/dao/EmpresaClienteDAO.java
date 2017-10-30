package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.EmpresaCliente;
import util.DbUtil;

public class EmpresaClienteDAO {

    private Connection connection;

    public EmpresaClienteDAO() {
        connection = DbUtil.getConnection();
    }

    public void addEmpresa(EmpresaCliente e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into empresacliente(NIT,nombreEmpresa,usuarioE,passwordE,direccion,estado) values (?,?,?,?,?,1)");
        preparedStatement.setInt(1, e.getNIT());
        preparedStatement.setString(2, e.getNombreEmpresa());
        preparedStatement.setString(3, e.getUsuarioE());
        preparedStatement.setString(4, e.getPasswordE());
        preparedStatement.setString(5, e.getDireccion());
        preparedStatement.executeUpdate();
    }

    public void deleteEmpresa(int idE) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("update empresacliente set estado=0 where NIT=?");
        preparedStatement.setInt(1, idE);
        preparedStatement.executeUpdate();
    }

    public void updateEmpresa(EmpresaCliente e) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update empresacliente set nombreEmpresa=?,passwordE=?,direccion=?" + " where NIT=?");
        preparedStatement.setString(1, e.getNombreEmpresa());
        preparedStatement.setString(2, e.getPasswordE());
        preparedStatement.setString(3, e.getDireccion());
        preparedStatement.setInt(4, e.getNIT());
        preparedStatement.executeUpdate();
    }

    public ArrayList<EmpresaCliente> getAllEmpresas() throws SQLException {
        ArrayList<EmpresaCliente> empresas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from empresacliente where estado=1");
        while (rs.next()) {
            EmpresaCliente e = new EmpresaCliente();
            e.setNIT(rs.getInt("NIT"));
            e.setUsuarioE(rs.getString("usuarioE"));
            e.setPasswordE(rs.getString("passwordE"));
            e.setNombreEmpresa(rs.getString("nombreEmpresa"));
            e.setDireccion(rs.getString("direccion"));
            e.setEstado(rs.getInt("estado"));
            empresas.add(e);
        }
        return empresas;
    }

    public EmpresaCliente getEmpresaById(int idU) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from empresacliente where NIT=" + idU);
        EmpresaCliente e = new EmpresaCliente();
        if (rs.next()) {
            e.setNIT(idU);
            e.setNombreEmpresa(rs.getString("nombreEmpresa"));
            e.setUsuarioE(rs.getString("usuarioE"));
            e.setPasswordE(rs.getString("passwordE"));
            e.setDireccion(rs.getString("direccion"));
            e.setEstado(rs.getInt("estado"));
        }
        return e;
    }
}
