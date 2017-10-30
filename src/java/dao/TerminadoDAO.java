package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Terminado;
import util.DbUtil;

public class TerminadoDAO {

    private Connection connection;

    public TerminadoDAO() {
        connection = DbUtil.getConnection();
    }

    //estado 0 terminado 1 revision
    public void addTerminado(Terminado t) throws SQLException {
        String s = "pr";
        PreparedStatement preparedStatement = connection.prepareStatement("insert into terminado(idHorario,fechaTerminado,fechaRevisado,supervisor,estado) values (?,?,?,?,0)");
        preparedStatement.setInt(1, t.getIdHorario());
        preparedStatement.setString(2, t.getFechaTerminado());
        preparedStatement.setString(3, s);
        preparedStatement.setInt(4, t.getSupervisor());
        preparedStatement.executeUpdate();
    }

    public void deleteTerminado(int idH) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from terminado where idHorario=?");
        preparedStatement.setInt(1, idH);
        preparedStatement.executeUpdate();
    }

    public void updateTerminado(Terminado t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update terminado set supervisor=? where idHorario=?");
        preparedStatement.setInt(1, t.getSupervisor());
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
            terminados.add(t);
        }
        return terminados;
    }

    public Terminado getTerminadoById(int idHorario) throws SQLException {
        Terminado t = new Terminado();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from terminado where idHorario=" + idHorario);
        if (rs.next()) {
            t.setIdHorario(idHorario);
            t.setFechaTerminado(rs.getString("fechaTerminado"));
            t.setFechaRevisado(rs.getString("fechaRevisado"));
            t.setSupervisor(rs.getInt("supervisor"));
            t.setEstado(rs.getInt("estado"));
        }
        return t;
    }
}
