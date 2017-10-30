package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Funciones;
import util.DbUtil;

public class FuncionesDAO {

    private Connection connection;

    public FuncionesDAO() {
        connection = DbUtil.getConnection();
    }

    public void addFunciones(Funciones f) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into funciones(idUsuario,idServicio,valoracion) values (?,?,?)");
        preparedStatement.setInt(1, f.getIdUsuario());
        preparedStatement.setInt(2, f.getIdServicio());
        preparedStatement.setInt(3, f.getValoracion());
        preparedStatement.executeUpdate();
    }

    public void deleteFunciones(int idU, int idS) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("delete from funciones where idUsuario=? and idServicio=?");
        preparedStatement.setInt(1, idU);
        preparedStatement.setInt(2, idS);
        preparedStatement.executeUpdate();
    }

    public void updateFunciones(Funciones f) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update funciones set valoracion=?" + " where idUsuario=? and idServicio=?");
        preparedStatement.setInt(1, f.getValoracion());
        preparedStatement.setInt(2, f.getIdUsuario());
        preparedStatement.setInt(3, f.getIdServicio());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Funciones> getAllFunciones() throws SQLException {
        ArrayList<Funciones> funciones = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from funciones");
        while (rs.next()) {
            Funciones f = new Funciones();
            f.setIdServicio(rs.getInt("idServicio"));
            f.setIdUsuario(rs.getInt("idUsuario"));
            f.setValoracion(rs.getInt("valoracion"));
            funciones.add(f);
        }
        return funciones;
    }

    public Funciones getFuncionesByIds(int idS, int idU) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from funciones where idUsuario=" + idU + " and idServicio=" + idS);
        Funciones f = new Funciones();
        if (rs.next()) {
            f.setIdServicio(rs.getInt("idServicio"));
            f.setIdUsuario(rs.getInt("idUsuario"));
            f.setValoracion(rs.getInt("valoracion"));
            return f;
        } else {
            return null;
        }
    }
}
