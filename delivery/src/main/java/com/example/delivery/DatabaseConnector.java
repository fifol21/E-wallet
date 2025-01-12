package com.example.delivery;

import java.sql.*;

public class DatabaseConnector {
    private static Connection connection;

    public static Connection getConnection() {
        String url = "jdbc:mysql://mysql.agh.edu.pl:3306/mbem1";
        String user = "mbem1";
        String password = "Lm5jf2Zjux0MtU9T";
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
                        //      Statement statement = connection.createStatement();
                //ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

            } catch (SQLException e) {
                e.printStackTrace();
            }catch (RuntimeException e) {
                HelloApplication.ErrorAlert("Error in connection to database", "Error");

            }
        }return connection;
    }
}
