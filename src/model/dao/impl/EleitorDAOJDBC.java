package model.dao.impl;

import db.DB;
import model.dao.EleitorDAO;
import model.entities.Eleitor;

import java.sql.*;

public class EleitorDAOJDBC implements EleitorDAO {

    private final Connection conn;

    public EleitorDAOJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public Eleitor findByTitulo(Integer titulo) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM eleitores "
                            +"WHERE eleitores.Titulo = ?"
            );
            st.setInt(1, titulo);
            rs = st.executeQuery();
            while (rs.next()){
                return instantiateEleitor(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.getConnection();
        }
        return null;
    }

    @Override
    public void insert(Eleitor obj) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO eleitores "
                    +"(Titulo, hasVoted) "
                    +"VALUES "
                    +"(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, obj.getTitulo());
            st.setBoolean(2, false);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasVoted(Eleitor obj) {
        try {
            ResultSet rs;
            PreparedStatement st = conn.prepareStatement(
                     "SELECT hasVoted FROM eleitores "
                    +"WHERE Titulo = ? "
            );
            st.setInt(1, obj.getTitulo());
            st.executeQuery();
            rs = st.getResultSet();
            while (rs.next()){
                if (rs.getBoolean("hasVoted")){
                    return true;
                }
            }
        return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "DELETE FROM eleitores "
                            +"WHERE "
                            +"Id = ?"
            );
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.getConnection();
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
}
