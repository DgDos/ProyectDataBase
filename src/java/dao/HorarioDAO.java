package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    // estado 1=activo, 2=terminado falta revision, 3=revisado
    public void addHorario(Horario h) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into horario(idTaR,idTrabajador,horaInicio,horaFinal,Fecha,estado) values (?,?,?,?,?,?)");
        preparedStatement.setInt(1, h.getIdTaR());
        preparedStatement.setInt(2, h.getIdTrabajador());
        preparedStatement.setInt(3, h.getHoraInicio());
        preparedStatement.setInt(4, h.getHoraFinal());
        preparedStatement.setString(5, h.getFecha());
        preparedStatement.setInt(6, 1);
        preparedStatement.executeUpdate();
    }

    public void deleteHorario(int idHorario) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("delete from horario where idHorario=?");
        preparedStatement.setInt(1, idHorario);
        preparedStatement.executeUpdate();
    }

    public void updateHorario(Horario h) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update horario set idTrabajador=?,horaInicio=?,horaFinal=?,Fecha=?" + " where idHorario=?");
        preparedStatement.setInt(1, h.getIdTrabajador());
        preparedStatement.setInt(2, h.getHoraInicio());
        preparedStatement.setInt(3, h.getHoraFinal());
        preparedStatement.setString(4, h.getFecha());
        preparedStatement.setInt(5, h.getIdHorario());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Horario> getAllHorarios() throws SQLException {
        ArrayList<Horario> horarios = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from horario");
        while (rs.next()) {
            Horario h = new Horario();
            h.setIdHorario(rs.getInt("idHorario"));
            h.setIdTaR(rs.getInt("idTaR"));
            h.setIdTrabajador(rs.getInt("idTrabajador"));
            h.setHoraInicio(rs.getInt("horaInicio"));
            h.setHoraFinal(rs.getInt("horaFinal"));
            h.setFecha(rs.getString("Fecha"));
            h.setEstado(rs.getInt("estado"));
            horarios.add(h);
        }
        return horarios;
    }

    public Horario getHorarioById(int idHorario) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from horario where idHorario=" + idHorario);
        Horario h = new Horario();
        if (rs.next()) {
            h.setIdHorario(idHorario);
            h.setIdTaR(rs.getInt("idTaR"));
            h.setIdTrabajador(rs.getInt("idTrabajador"));
            h.setHoraInicio(rs.getInt("horaInicio"));
            h.setHoraFinal(rs.getInt("horaFinal"));
            h.setFecha(rs.getString("Fecha"));
            h.setEstado(1);
        }
        return h;
    }
}
