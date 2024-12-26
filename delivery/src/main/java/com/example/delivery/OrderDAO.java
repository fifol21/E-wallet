package com.example.delivery;
import java.sql.*;

public class OrderDAO {
    private Connection connection;

    public OrderDAO(Connection connection_) {
        this.connection = connection_;
    }

//    public void createOrder(Order order) {
//        String sql = "INSERT INTO orders (ORDERS_ID,CUSTOMER,DESTINATION,STATUS,VEHICLE,COST) VALUES(?,?,?,?,?,?)";
//        try(PreparedStatement stmt = connection.prepareStatement(sql)){
//            stmt.setInt();
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
