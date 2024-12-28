package com.example.delivery;
import java.sql.*;

public class OrderDAO {
    private Connection connection;

    public OrderDAO(Connection connection_) {
        this.connection = connection_;
    }

    public void createOrder(Order order) {
        String sql = "INSERT INTO orders (ORDERS_ID,CUSTOMER,DESTINATION,STATUS,VEHICLE,COST,PACKAGE_ID) VALUES(?,?,?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,order.getOrderID());
            stmt.setInt(2,order.getCustomerID());
            stmt.setString(3,order.getDestination());
            stmt.setString(4,order.getStatus());
            stmt.setInt(5,order.getVehicleID());
            stmt.setFloat(6,order.getCost());
            stmt.setInt(7,order.getPackageID());
            stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Order readOrder(int orderID, PackageDAO packageDAO) {
        String sql = "SELECT * FROM orders WHERE ORDERS_ID=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,orderID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Order(
                        rs.getInt("ORDERS_ID"),
                        rs.getInt("CUSTOMER"),
                        rs.getString("DESTINATION"),
                        rs.getString("Status"),
                        rs.getInt("VEHICLE"),
                        rs.getFloat("COST"),
                        rs.getInt("PACKAGE_ID")
                );
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }return null;
    }

    public void updateOrder(Order order) {
        String sql = "UPDATE orders SET CUSTOMER = ?, DESTINATION = ?, STATUS = ?, VEHICLE = ?, COST = ? WHERE ORDERS_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,order.getCustomerID());
            stmt.setString(2,order.getDestination());
            stmt.setString(3,order.getStatus());
            stmt.setInt(4,order.getVehicleID());
            stmt.setFloat(5,order.getCost());
            stmt.setInt(6,order.getOrderID());
            stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int orderID) {
        String sql = "DELETE FROM orders WHERE ORDERS_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,orderID);
            stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
