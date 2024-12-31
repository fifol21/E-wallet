package com.example.delivery;
import java.sql.*;

public class LoginService {
    private Connection connection;
    private static LoginService instance;

    private LoginService(Connection connection) {
        this.connection = connection;
    }

    public static LoginService getInstance(Connection connection) {
        if (instance == null) {
            synchronized (LoginService.class) {
                if (instance == null) {}
            }
        }
        return instance;
    }

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE LOGIN = ? AND PASSWORD = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
