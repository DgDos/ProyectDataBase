/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Funciones;
import model.Terminado;
import util.DbUtil;

/**
 *
 * @author FiJus
 */
public class TerminadoDAO {
    private Connection connection;

    public TerminadoDAO() {
        connection = DbUtil.getConnection();
    }

    public void addTerminado(Terminado t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into terminado(idHorario,fechaTerminado,fechaRevisado,supervisor,estado) values (?,?,?,?,0)");
        preparedStatement.setInt(1, t.getIdHorario());
        preparedStatement.setString(2, t.getFechaRevisado());
        preparedStatement.setString(3, t.getFechaTerminado());
        preparedStatement.setInt(4, t.getSupervisor());
        preparedStatement.executeUpdate();
    }

    public void deleteTerminado(int idH) throws SQLException {
        
        PreparedStatement preparedStatement = connection.prepareStatement("delete from terminado where idHorario=?");
        preparedStatement.setInt(1, idH);
        preparedStatement.executeUpdate();
    }

    public void updateTerminado(Terminado t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update terminado set fechaRevisado=?,estado=0" + " where idHorario=?");
        preparedStatement.setString(1, t.getFechaRevisado());
        preparedStatement.setInt(2, t.getIdHorario());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Terminado> getAllTerminados() throws SQLException {
        ArrayList<Terminado> terminados = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from terminado");
        while (rs.next()) {
            Terminado t = new Terminado();
            t.setIdHorario(rs.getInt("idHorario"));
            t.setFechaTerminado(rs.getString("fechaTerminado"));
            t.setFechaRevisado(rs.getString("fechaRevisado"));
            t.setSupervisor(rs.getInt("supervisor"));
            t.setEstado(rs.getInt("estado"));
        }
        return terminados;
    }
}
