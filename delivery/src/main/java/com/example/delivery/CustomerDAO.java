package com.example.delivery;
import java.sql.*;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO(Connection connection_) {
        this.connection = connection_;
    }

    public void saveCustomer(Customer customer) {
        String sql = "INSERT INTO customers (CUSTOMER_ID, NAME, ADDRESS, CONTACT_NUMBER) values (?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,customer.getCustomerID());
            stmt.setString(2,customer.getName());
            stmt.setString(3,customer.getAddress());
            stmt.setString(4, customer.getContactNumber());
            stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public Customer readCustomer(int customer_id){
        String sql = "SELECT * FROM customers WHERE CUSTOMER_ID=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,customer_id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Customer(
                        rs.getInt("CUSTOMER_ID"),
                        rs.getString("NAME"),
                        rs.getString("ADDRESS"),
                        rs.getString("Contact_NUMBER")
                );
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }return null;
    }

    public void UpdateCustomer(Customer customer) {
        String sql = "UPDATE customers SET NAME=?,ADDRESS=?,CONTACT_NUMBER=? WHERE CUSTOMER_ID=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,customer.getName());
            stmt.setString(2,customer.getAddress());
            stmt.setString(3,customer.getAddress());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customer_id) {
        String sql = "DELETE FROM customers WHERE CUSTOMER_ID=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,customer_id);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Customer getLastCustomer(){
        String sql = "SELECT * FROM customers ORDER BY PACKAGE_ID DESC LIMIT 1";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Customer(
                        rs.getInt("CUSTOMER_ID"),
                        rs.getString("NAME"),
                        rs.getString("ADDRESS"),
                        rs.getString("Contact_NUMBER")
                );
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }return null;
    }

}
