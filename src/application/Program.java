package application;

import db.DB;
import model.dao.impl.CandidatoDAOJDBC;
import model.dao.impl.EleitorDAOJDBC;
import model.dao.impl.PartidoDAOJDBC;
import model.dao.impl.UrnaDAOJDBC;
import model.entities.Candidato;
import model.entities.Eleitor;
import model.entities.Partido;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn;
        ResultSet rs;
        Statement st;


        conn = DB.getConnection();
        UrnaDAOJDBC urna = new UrnaDAOJDBC(conn);
        CandidatoDAOJDBC daojdbc = new CandidatoDAOJDBC(conn);
        PartidoDAOJDBC partidoDAOJDBC = new PartidoDAOJDBC(conn);
        daojdbc.insert(new Candidato("Gon", 10, partidoDAOJDBC.findById(1)));




    }
}
