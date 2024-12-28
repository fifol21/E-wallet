// not used

package com.example.delivery;

import java.sql.*;

public class QueryExecutor {
    public static ResultSet executeQuery(String query) {
        Connection connection = DatabaseConnector.getConnection();
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int executeUpdate(String query) {
        Connection connection = DatabaseConnector.getConnection();
        try{
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
