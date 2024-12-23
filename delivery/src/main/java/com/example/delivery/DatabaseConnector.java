package com.example.delivery;

import java.sql.*;

public class DatabaseConnector {
    private static Connection connection;

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/delivery";
        String user = "root";
        String password = "MYsql28@#";
        if(connection == null) {
            try {
                Connection connection = DriverManager.getConnection(url, user, password);

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }return connection;
    }
}
