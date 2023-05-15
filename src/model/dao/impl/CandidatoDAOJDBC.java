package model.dao.impl;

import db.DB;
import model.dao.CandidatoDAO;
import model.entities.Candidato;
import model.entities.Partido;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CandidatoDAOJDBC implements CandidatoDAO {

    private final Connection conn;

    public CandidatoDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Candidato obj) {
        try {
            PreparedStatement st = conn.prepareStatement(
                     "INSERT INTO candidatos "
                    +"(Name, Numero, partidosId) "
                    +"VALUES "
                    +"(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setInt(2, obj.getNumero());
            st.setInt(3, obj.getPartido().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Candidato obj) {

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                     "DELETE FROM candidatos "
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
    public Candidato findByNumber(Integer numero) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                     "SELECT * FROM candidatos "
                    +"WHERE candidatos.Numero = ?"
            );
            st.setInt(1, numero);
            rs = st.executeQuery();
            while (rs.next()){
                return instantiateCandidato(rs, null);
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
    public Set<Candidato> findAll() {

        Statement st = null;
        ResultSet rs = null;
        Set<Candidato> candidatoSet = new HashSet<>();

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM candidatos");

            while (rs.next()){
                candidatoSet.add(instantiateCandidato(rs, null));
            }
        return candidatoSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.getConnection();
        }
    }

    private Candidato instantiateCandidato(ResultSet rs, Integer partidoId){
        Candidato candidato = new Candidato();
        PartidoDAOJDBC jd = new PartidoDAOJDBC(conn);
        Partido partido = null;
        try {
            partido = jd.findById(rs.getInt("partidosId"));
            candidato.setId(rs.getInt("Id"));
            candidato.setNumero(rs.getInt("Numero"));
            candidato.setNome(rs.getString("Name"));
            candidato.setVotos(rs.getInt("Votos"));
            candidato.setPartido(partido);
            return candidato;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
