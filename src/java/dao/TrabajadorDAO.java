package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Trabajador;
import util.DbUtil;

public class TrabajadorDAO {

    private Connection connection;

    public TrabajadorDAO() {
        connection = DbUtil.getConnection();
    }

    public void addTrabajador(Trabajador t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into trabajador(usuarioT,passwordT,nombre,cargo,supervisor,estado) values (?,?,?,?,?,1)");
        preparedStatement.setString(1, t.getUsuarioT());
        preparedStatement.setString(2, t.getPasswordT());
        preparedStatement.setString(3, t.getNombre());
        preparedStatement.setString(4, t.getCargo());
        preparedStatement.setInt(5, t.getSupervisor());
        preparedStatement.executeUpdate();
    }

    public void deleteTrabajador(int idT) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("update trabajador set estado=0 where idUsuario=?");
        preparedStatement.setInt(1, idT);
        preparedStatement.executeUpdate();
    }

    public void updateTrabajador(Trabajador t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update trabajador set passwordT=?,nombre=?,cargo=?,supervisor=?" + " where idUsuario=?");
        preparedStatement.setString(1, t.getPasswordT());
        preparedStatement.setString(2, t.getNombre());
        preparedStatement.setString(3, t.getCargo());
        preparedStatement.setInt(4, t.getSupervisor());
        preparedStatement.setInt(5, t.getIdUsuario());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Trabajador> getAllTrabajadores() throws SQLException {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from trabajador where estado=1");
        while (rs.next()) {
            Trabajador t = new Trabajador();
            t.setIdUsuario(rs.getInt("idUsuario"));
            t.setUsuarioT(rs.getString("usuarioT"));
            t.setPasswordT(rs.getString("passwordT"));
            t.setNombre(rs.getString("nombre"));
            t.setCargo(rs.getString("cargo"));
            t.setSupervisor(rs.getInt("supervisor"));
            t.setEstado(rs.getInt("estado"));
            trabajadores.add(t);
        }
        return trabajadores;
    }

    public Trabajador getTrabajadorById(int idT) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from trabajador where idUsuario=" + idT);
        Trabajador t = new Trabajador();
        if (rs.next()) {
            t.setIdUsuario(rs.getInt("idUsuario"));
            t.setUsuarioT(rs.getString("usuarioT"));
            t.setPasswordT(rs.getString("passwordT"));
            t.setNombre(rs.getString("nombre"));
            t.setCargo(rs.getString("cargo"));
            t.setSupervisor(rs.getInt("supervisor"));
            t.setEstado(rs.getInt("estado"));
        }
        return t;
    }
}
