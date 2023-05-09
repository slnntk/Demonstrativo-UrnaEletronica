package interfaces;

import java.sql.*;
import java.util.Properties;

public interface InterfaceDB {

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;


    static Connection getConnection() {
        return null;
    }

    static Properties loadProperties() {
        return null;
    }

    static void closeConnection() {

    }

    public static void closeStatement(){

    }

    public static void closeResultSet(){

    }

}
