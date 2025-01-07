package com.example.delivery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection connection;
    private static OrderDAO instance;

    private OrderDAO(Connection connection_) {
        this.connection = connection_;
    }

    public static OrderDAO getInstance(Connection connection_) {
        if (instance == null) {
            synchronized (OrderDAO.class) {
                if(instance == null) {
                    instance = new OrderDAO(connection_);
                }
            }
        }
        return instance;
    }

    public void createOrder(Order order) {
        String sql = "INSERT INTO orders (ORDERS_ID,CUSTOMER,DESTINATION,STATUS,VEHICLE,COST,PACKAGE_ID) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, order.getOrderID());
            stmt.setInt(2, order.getCustomerID());
            stmt.setString(3, order.getDestination());
            stmt.setString(4, order.getStatus());
            stmt.setInt(5, order.getVehicleID());
            stmt.setFloat(6, order.getCost());
            stmt.setInt(7, order.getPackageID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order readOrder(int orderID, PackageDAO packageDAO) {
        String sql = "SELECT * FROM orders WHERE ORDERS_ID=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateOrder(Order order) {
        String sql = "UPDATE orders SET CUSTOMER = ?, DESTINATION = ?, STATUS = ?, VEHICLE = ?, COST = ? WHERE ORDERS_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, order.getCustomerID());
            stmt.setString(2, order.getDestination());
            stmt.setString(3, order.getStatus());
            stmt.setInt(4, order.getVehicleID());
            stmt.setFloat(5, order.getCost());
            stmt.setInt(6, order.getOrderID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int orderID) {
        String sql = "DELETE FROM orders WHERE ORDERS_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order getLastOrder() {
        String sql = "SELECT * FROM orders ORDER BY ORDERS_ID DESC LIMIT 1";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("ORDERS_ID"),
                        rs.getInt("CUSTOMER"),
                        rs.getString("DESTINATION"),
                        rs.getString("Status"),
                        rs.getInt("VEHICLE"),
                        rs.getFloat("COST"),
                        rs.getInt("PACKAGE_ID")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> getPendingOrders(){
        String sql = "SELECT * FROM orders WHERE STATUS = 'PENDING'";
        List<Order> orders = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("ORDERS_ID"),
                        rs.getInt("CUSTOMER"),
                        rs.getString("DESTINATION"),
                        rs.getString("Status"),
                        rs.getInt("VEHICLE"),
                        rs.getFloat("COST"),
                        rs.getInt("PACKAGE_ID")
                );
                orders.add(order);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    public List<List<String>> get_orders_history() {
        String sql = "SELECT * FROM orders_history";
        List<List<String>> orders_history = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                List<String> update = new ArrayList<>();
                update.add(String.valueOf(rs.getInt("ORDER_ID")));
                update.add(rs.getString("STATUS"));
                orders_history.add(update);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders_history;
    }
}
