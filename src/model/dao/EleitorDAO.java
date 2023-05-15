package model.dao;

import model.entities.Eleitor;

public interface EleitorDAO {

    void insert(Eleitor obj);
    boolean hasVoted(Eleitor obj);
    void deleteById(Integer id);
    Eleitor findByTitulo(Integer titulo);

}
