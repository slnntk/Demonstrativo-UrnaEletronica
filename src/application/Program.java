package application;

import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        Statement stw = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            stw = conn.createStatement();
            stw.executeQuery("SELECT * FROM candidatos");
            rs = stw.getResultSet();

            System.out.println(rs.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet();
            DB.closeStatement();
            DB.closeConnection();
        }


    }
}
