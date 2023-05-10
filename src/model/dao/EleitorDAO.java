package model.dao;

import model.entities.Eleitor;

public interface EleitorDAO {

    void insert(Eleitor obj);
    void hasVoted(Eleitor obj);
    void isValido();

}
