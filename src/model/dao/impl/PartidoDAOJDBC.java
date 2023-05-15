package model.dao.impl;

import db.DB;
import model.dao.PartidoDAO;
import model.entities.Partido;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PartidoDAOJDBC implements PartidoDAO {

    private final Connection conn;

    public PartidoDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Partido obj) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO partidos "
                            +"(Name) "
                            +"VALUES "
                            +"(?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Partido obj) {

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "DELETE FROM partidos "
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

    @Override
    public Partido findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM partidos "
                            +"WHERE partidos.Id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()){
                return instantiatePartido(rs);
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
    public Set<Partido> findAll() {

        Statement st = null;
        ResultSet rs = null;
        Set<Partido> partidoSet = new HashSet<>();

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM partidos");

            while (rs.next()){
                partidoSet.add(instantiatePartido(rs));
            }
            return partidoSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.getConnection();
        }
    }

    private Partido instantiatePartido(ResultSet rs){
        Partido partido = new Partido();
        try {
            partido.setId(rs.getInt("Id"));
            partido.setNome(rs.getString("Name"));
            return partido;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
