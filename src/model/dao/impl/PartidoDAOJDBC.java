package model.dao.impl;

import model.dao.PartidoDAO;
import model.entities.Candidato;
import model.entities.Partido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class PartidoDAOJDBC implements PartidoDAO {

    private Connection conn;

    @Override
    public void insert(Partido obj) {

    }

    @Override
    public void update(Partido obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Partido findById(Integer id) {
        return null;
    }

    @Override
    public Set<Partido> findAll() {
        return null;
    }
}
