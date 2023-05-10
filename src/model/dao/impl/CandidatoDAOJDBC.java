package model.dao.impl;

import model.dao.CandidatoDAO;
import model.entities.Candidato;
import model.entities.Partido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class CandidatoDAOJDBC implements CandidatoDAO {

    private Connection conn;

    @Override
    public void insert(Candidato obj) {

    }

    @Override
    public void update(Candidato obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Candidato findById(Integer id) {
        return null;
    }

    @Override
    public Set<Candidato> findAll() {
        return null;
    }

    private Candidato instantiateCandidato(ResultSet rs, Partido partido){
        Candidato candidato = new Candidato();
        try {
            candidato.setId(rs.getInt("Id"));
            candidato.setNumero(rs.getInt("Numero"));
            candidato.setNome(rs.getString("Nome"));
            candidato.setVotos(rs.getInt("Votos"));
            candidato.setPartido(partido);
            return candidato;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Partido instantiatePartido(ResultSet rs){
        Partido partido = new Partido();
        try {
            partido.setId(rs.getInt("Id"));
            partido.setNome(rs.getString("Nome"));
            partido.setSigla(rs.getString("Sigla"));
            return partido;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}