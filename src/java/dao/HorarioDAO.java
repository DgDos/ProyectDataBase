/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Horario;
import util.DbUtil;

/**
 *
 * @author FiJus
 */
public class HorarioDAO {
    private Connection connection;

    public HorarioDAO() {
        connection = DbUtil.getConnection();
    }
//falta FECHA DE LA VERGA
    public void addHorario(Horario h) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into horario(idTaR,idTrabajador,horaInicio,horaFinal,Fecha,estado) values (?,?,?,?,?,?)");
        preparedStatement.setInt(1, h.getIdTaR());
        preparedStatement.setInt(2, h.getIdTrabajador());
        preparedStatement.setInt(3, h.getHoraInicio());
        preparedStatement.setInt(4, h.getHoraFinal());
        preparedStatement.setDate(5, new Date(h.getFecha().getTime()));
        preparedStatement.setInt(6, 1);
        preparedStatement.executeUpdate();
    }

    public void deleteHorario(int idHorario) throws SQLException {
        
        PreparedStatement preparedStatement = connection.prepareStatement("update horario set estado=0 where idHorario=?");
        preparedStatement.setInt(1, idHorario);
        preparedStatement.executeUpdate();
    }

    public void updateHorario(Horario h) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update horario set idTrabajador=?,horaInicio=?,horaFinal=?,Fecha=?" + " where idHorario=?");
        preparedStatement.setInt(1,h.getIdTrabajador());
        preparedStatement.setInt(2, h.getHoraInicio());
        preparedStatement.setInt(3, h.getHoraFinal());
        preparedStatement.setDate(4, new Date(h.getFecha().getTime()));
        preparedStatement.setInt(5, h.getIdHorario());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Horario> getAllHorarios() throws SQLException {
        ArrayList<Horario> horarios = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from funciones");
        while (rs.next()) {
            Horario h = new Horario();
            h.setIdHorario(rs.getInt("idHorario"));
            h.setIdTaR(rs.getInt("idTaR"));
            h.setIdTrabajador(rs.getInt("idTrabajador"));
            h.setHoraInicio(rs.getInt("horaInicio"));
            h.setHoraFinal(rs.getInt("horaFinal"));
            h.setFecha(rs.getDate("Fecha"));
            h.setEstado(rs.getInt("estado"));
            horarios.add(h);
        }
        return horarios;
    }
}
