package model.dao.impl;

import db.DB;
import model.dao.CandidatoDAO;
import model.dao.EleitorDAO;
import model.dao.PartidoDAO;
import model.dao.UrnaDAO;

public class DaoFactory {


    public static CandidatoDAO createCandidatoDao(){
        return new CandidatoDAOJDBC(DB.getConnection());
    }

    public static EleitorDAO createEleitorDAO(){
        return new EleitorDAOJDBC(DB.getConnection());
    }

    public static PartidoDAO createPartidoDAO(){
        return new PartidoDAOJDBC(DB.getConnection());
    }


}
