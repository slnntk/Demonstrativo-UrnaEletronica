package application;

import db.DB;
import model.dao.CandidatoDAO;
import model.dao.impl.CandidatoDAOJDBC;
import model.dao.impl.EleitorDAOJDBC;
import model.entities.Candidato;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn;
        ResultSet rs;
        Statement st;


        conn = DB.getConnection();
        EleitorDAOJDBC eleitorDAOJDBC = new EleitorDAOJDBC(conn);


    }
}
