package application;

import db.DB;
import model.dao.impl.EleitorDAOJDBC;
import model.dao.impl.UrnaDAOJDBC;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn;
        ResultSet rs;
        Statement st;


        conn = DB.getConnection();
        EleitorDAOJDBC e = new EleitorDAOJDBC(conn);
        UrnaDAOJDBC u = new UrnaDAOJDBC(conn);
        u.votar(e.findByTitulo(2316230), 10);

    }
}
