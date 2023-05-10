package application;

import db.DB;
import model.dao.CandidatoDAO;
import model.dao.impl.CandidatoDAOJDBC;
import model.entities.Candidato;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn;
        ResultSet rs;
        Statement st;

        CandidatoDAOJDBC candDAO = new CandidatoDAOJDBC();

        try {
           conn = DB.getConnection();
           st = conn.createStatement();
           st.executeQuery("SELECT * FROM candidatos");

           rs = st.getResultSet();

           while (rs.next()){
               System.out.println(rs.getInt("Id") + "," + rs.getInt("Numero") + "," + rs.getString("Nome") + "," + rs.getInt("Votos"));
               Candidato c = candDAO.instantiateCandidato(rs, null);
               System.out.println(c);
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
