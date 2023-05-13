package model.dao;

import model.entities.Eleitor;

public interface EleitorDAO {

    void insert(Eleitor obj);
    boolean hasVoted(Eleitor obj);
    Eleitor findByTitulo(Integer titulo);

}
