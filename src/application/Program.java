package application;

import db.DB;
import model.dao.impl.EleitorDAOJDBC;
import model.dao.impl.UrnaDAOJDBC;
import model.entities.Eleitor;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn;
        ResultSet rs;
        Statement st;


        conn = DB.getConnection();
        UrnaDAOJDBC urna = new UrnaDAOJDBC(conn);
        EleitorDAOJDBC eleitor = new EleitorDAOJDBC(conn);
        urna.votar(eleitor.findByTitulo(666777), 13);



    }
}
