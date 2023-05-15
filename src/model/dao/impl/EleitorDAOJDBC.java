package model.dao.impl;

import db.DB;
import model.dao.EleitorDAO;
import model.entities.Candidato;
import model.entities.Eleitor;

import java.sql.*;

public class EleitorDAOJDBC implements EleitorDAO {

    private Connection conn;

    public EleitorDAOJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public Eleitor findByTitulo(Integer titulo) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Candidato candidato = null;

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
}
