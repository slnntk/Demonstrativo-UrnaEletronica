package model.dao.impl;

import model.dao.EleitorDAO;
import model.entities.Eleitor;
import model.entities.Partido;

import java.sql.*;

public class EleitorDAOJDBC implements EleitorDAO {

    private Connection conn;

    public EleitorDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Eleitor obj) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO eleitores "
                    +"(Titulo) "
                    +"VALUES "
                    +"(?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, obj.getTitulo().intValue());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasVoted(Eleitor obj) {
        try {
            ResultSet rs = null;
            PreparedStatement st = conn.prepareStatement(
                     "SELECT hasVoted FROM eleitores "
                    +"WHERE Titulo = ? "
            );
            st.setInt(1, obj.getTitulo().intValue());
            st.executeQuery();
            rs = st.getResultSet();
            while (rs.next()){
                if (rs.getInt("hasVoted") == 1){
                    return true;
                }
            }
        return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Eleitor instantiateEleitor(ResultSet rs){
        Eleitor eleitor = new Eleitor();
        try {
            eleitor.setTitulo(rs.getInt("Titulo"));
            return eleitor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void isValido() {

    }
}
