package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Servicio;
import util.DbUtil;

public class ServicioDAO {

    private Connection connection;

    public ServicioDAO() {
        connection = DbUtil.getConnection();
    }

    public void addServicio(Servicio s) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into servicio(nombreS,estado) values (?,1)");
        preparedStatement.setString(1, s.getNombreS());
        preparedStatement.executeUpdate();
    }

    public void deleteServicio(int idServicio) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("update servicio set estado=0 where idServicio=?");
        preparedStatement.setInt(1, idServicio);
        preparedStatement.executeUpdate();
    }

    public void updateServicio(Servicio servicio) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update servicio set nombreS=?" + " where idServicio=?");
        preparedStatement.setString(1, servicio.getNombreS());
        preparedStatement.setInt(2, servicio.getIdServicio());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Servicio> getAllServicios() throws SQLException {
        ArrayList<Servicio> servicios = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from servicio where estado=1");
        while (rs.next()) {
            Servicio s = new Servicio();
            s.setIdServicio(rs.getInt("idServicio"));
            s.setNombreS(rs.getString("nombreS"));
            s.setEstado(rs.getInt("estado"));
            servicios.add(s);
        }
        return servicios;
    }

    public Servicio getServicioById(int idS) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from servicio where idServicio=" + idS);
        Servicio s = new Servicio();
        if (rs.next()) {
            s.setIdServicio(idS);
            s.setNombreS(rs.getString("nombreS"));
            s.setEstado(rs.getInt("estado"));
        }
        return s;
    }
}
