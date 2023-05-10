package model.dao;

import model.entities.Candidato;

import java.util.Set;

public interface CandidatoDAO{

    void insert(Candidato obj);
    void update(Candidato obj);
    void deleteById(Integer id);
    Candidato findByNumber(Integer numero);
    Set<Candidato> findAll();

}
