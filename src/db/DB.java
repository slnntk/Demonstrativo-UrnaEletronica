package db;

import interfaces.InterfaceDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB implements InterfaceDB{

        private static Connection conn = null;
        private static Statement st = null;
        private static ResultSet rs = null;


        public static Connection getConnection(){

            if (conn == null){
                try {
                    Properties props = loadProperties();
                    String url = props.getProperty("dburl");
                    conn = DriverManager.getConnection(url, props);
                } catch (SQLException e){
                    throw new DbException("Error in connect with DataBase" + e.getMessage());
                }
            }
            return conn;
        }

        private static Properties loadProperties(){
            try (FileInputStream fs = new FileInputStream("db.properties")){

                Properties properties = new Properties();
                properties.load(fs);
                return properties;
            } catch (IOException e) {
                throw new DbException("Error in load the properties to the DataBase" + e.getMessage());
            }
        }

        public static void closeConnection(){
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DbException("Error in close the connection" + e.getMessage());
                }
            }
        }

        public static void closeStatement(){
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DbException("Error in close the statement" + e.getMessage());
                }
            }
        }

        public static void closeResultSet(){
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DbException("Error in close the resultSet" + e.getMessage());
                }
            }
        }


}
