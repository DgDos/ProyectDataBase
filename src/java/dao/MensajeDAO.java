package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Mensaje;
import util.DbUtil;

public class MensajeDAO {

    private Connection connection;

    public MensajeDAO() {
        connection = DbUtil.getConnection();
    }

    public void addMensaje(Mensaje m) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into mensaje(idU1,idU2,Asunto,Texto) values (?,?,?,?)");
        preparedStatement.setInt(1, m.getIdU1());
        preparedStatement.setInt(2, m.getIdU2());
        preparedStatement.setString(3, m.getAsunto());
        preparedStatement.setString(4, m.getTexto());
        preparedStatement.executeUpdate();
    }

    public void deleteMensaje(int idU1, int idU2) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("delete from mensaje where idU1=? and idU2=?");
        preparedStatement.setInt(1, idU1);
        preparedStatement.setInt(2, idU2);
        preparedStatement.executeUpdate();
    }

    public void updateMensaje(Mensaje mensaje) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update mensaje set asunto=?,Texto=?" + " where idU1=? and idU2=?");
        preparedStatement.setString(1, mensaje.getAsunto());
        preparedStatement.setString(2, mensaje.getTexto());
        preparedStatement.setInt(3, mensaje.getIdU1());
        preparedStatement.setInt(4, mensaje.getIdU2());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Mensaje> getAllMensaje() throws SQLException {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from mensaje");
        while (rs.next()) {
            Mensaje m = new Mensaje();
            m.setIdU1(rs.getInt("idU1"));
            m.setIdU2(rs.getInt("idU2"));
            m.setAsunto(rs.getString("Asunto"));
            m.setTexto(rs.getString("Texto"));
            mensajes.add(m);
        }
        return mensajes;
    }

    public Mensaje getAllMensajesByIds(int idU1, int idU2) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from mensaje where idU1=" + idU1 + " and idU2=" + idU2);
        if (rs.next()) {
            Mensaje m = new Mensaje();
            m.setIdU1(rs.getInt("idU1"));
            m.setIdU2(rs.getInt("idU2"));
            m.setAsunto(rs.getString("Asunto"));
            m.setTexto(rs.getString("Texto"));
            return m;
        } else {
            return null;
        }
    }
}
