package application;

import db.DB;
import model.dao.CandidatoDAO;
import model.dao.impl.*;
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
        CandidatoDAO candidato = DaoFactory.createCandidatoDao();

        System.out.println("=== TEST 1: candidato findByNumber -> (10) =====");
        Candidato candidatoByNumber = candidato.findByNumber(10);
        System.out.println(candidatoByNumber);




    }
}
