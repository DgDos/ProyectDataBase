package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.TrabajoARealizar;
import util.DbUtil;

public class TrabajoARealizarDAO {

    private Connection connection;

    public TrabajoARealizarDAO() {
        connection = DbUtil.getConnection();
    }

    public void addTrabajoARealizar(TrabajoARealizar t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into trabajoarealizar(idEmpresa,idServicio,Urgencia,Detalles,estado) values (?,?,?,?,1)");
        preparedStatement.setInt(1, t.getIdEmpresa());
        preparedStatement.setInt(2, t.getIdServicio());
        preparedStatement.setInt(3, t.getUrgencia());
        preparedStatement.setString(4, t.getDetalles());
        preparedStatement.executeUpdate();
    }

    public void deleteTrabajoARealizar(int idTrabajo) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("update trabajoarealizar set estado=0 where idTrabajo=?");
        preparedStatement.setInt(1, idTrabajo);
        preparedStatement.executeUpdate();
    }

    public void updateTrabajoARealizar(TrabajoARealizar t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update trabajoarealizar set Urgencia=?,Detalles=?" + " where idTrabajo=?");
        preparedStatement.setInt(1, t.getUrgencia());
        preparedStatement.setString(2, t.getDetalles());
        preparedStatement.setInt(3, t.getIdTrabajo());
        preparedStatement.executeUpdate();
    }

    public ArrayList<TrabajoARealizar> getAllTrabajosARealizar() throws SQLException {
        ArrayList<TrabajoARealizar> trabajos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from trabajoarealizar where estado=1");
        while (rs.next()) {
            TrabajoARealizar t = new TrabajoARealizar();
            t.setIdTrabajo(rs.getInt("idTrabajo"));
            t.setIdEmpresa(rs.getInt("idEmpresa"));
            t.setIdServicio(rs.getInt("idServicio"));
            t.setUrgencia(rs.getInt("Urgencia"));
            t.setDetalles(rs.getString("Detalles"));
            t.setEstado(rs.getInt("estado"));
            trabajos.add(t);
        }
        return trabajos;
    }

    public TrabajoARealizar getTrabajoARealizarById(int idTrabajo) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from trabajoarealizar where idTrabajo=" + idTrabajo);
        TrabajoARealizar t = new TrabajoARealizar();
        if (rs.next()) {
            t.setIdTrabajo(idTrabajo);
            t.setIdEmpresa(rs.getInt("IdEmpresa"));
            t.setIdServicio(rs.getInt("idServicio"));
            t.setUrgencia(rs.getInt("Urgencia"));
            t.setDetalles(rs.getString("Detalles"));
            t.setEstado(rs.getInt("estado"));
        }
        return t;
    }
}
