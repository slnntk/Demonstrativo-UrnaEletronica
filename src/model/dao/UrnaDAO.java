package model.dao;

import model.entities.Eleitor;

public interface UrnaDAO {

    void votar(Eleitor eleitor, Integer numeroDoCandidato);


}
