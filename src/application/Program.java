package application;

import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rt = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "INSERT INTO candidatos "
                    + "(Numero, Nome, Votos, Partido_Id)"
                    + "VALUES "
                    + "(?, ?, ?, ?)"
            );
            st.setInt(1, 13);
            st.setString(2, "Killua");
            st.setInt(3, 0);
            st.setInt(4, 1);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet();
            DB.closeStatement();
            DB.closeConnection();
        }


    }
}
