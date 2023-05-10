package model.dao.impl;

import model.dao.EleitorDAO;
import model.entities.Eleitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void hasVoted(Eleitor obj) {
        try {
            PreparedStatement st = conn.prepareStatement(
                     "SELECT hasVoted FROM eleitores "
                    +"WHERE Titulo = ? "
            );
            st.setInt(1, obj.getTitulo().intValue());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void isValido() {

    }
}
