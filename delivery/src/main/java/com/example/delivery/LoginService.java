package com.example.delivery;
import java.sql.*;

public class LoginService {
    private Connection connection;

    public LoginService(Connection connection) {
        this.connection = connection;
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
