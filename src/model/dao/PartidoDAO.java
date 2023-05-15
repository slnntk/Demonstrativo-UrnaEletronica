package model.dao;

import model.entities.Partido;

import java.util.Set;

public interface PartidoDAO {

    void insert(Partido obj);
    void update(Partido obj);
    void deleteById(Integer id);
    Partido findByName(String name);

    Set<Partido> findAll();

}
