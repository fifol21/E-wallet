package com.example.delivery;
import java.sql.*;

public class VehicleDAO {
    private Connection connection;

    public VehicleDAO(Connection connection_) {
        this.connection = connection_;
    }

    public void createVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (VEHICLE_ID, TYPE, IS_AVAIBLE, VEHICLE_LOAD, CAPACITY) VALUES(?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,vehicle.getVehicleID());
            stmt.setString(2,vehicle.getType());
            stmt.setBoolean(3, vehicle.isAvailable());
            stmt.setInt(4, vehicle.getLoad());
            stmt.setInt(5, vehicle.getCapacity());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Vehicle getVehicle(int vehicleID) {
        String sql = "SELECT * FROM vehicle WHERE VEHICLE_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, vehicleID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Vehicle(
                        rs.getInt("VEHICLE_ID"),
                        rs.getString("TYPE"),
                        rs.getBoolean("IS_AVAIBLE"),
                        rs.getInt("VEHICLE_LOAD"),
                        rs.getInt("CAPACITY")
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicle SET TYPE = ?, IS_AVAIBLE = ?, VEHICLE_LOAD = ?, CAPACITY = ? WHERE VEHICLE_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,vehicle.getType());
            stmt.setBoolean(2, vehicle.isAvailable());
            stmt.setInt(3, vehicle.getLoad());
            stmt.setInt(4, vehicle.getCapacity());
            stmt.setInt(5,vehicle.getVehicleID());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteVehicle(int vehicleID) {
        String sql = "DELETE FROM vehicle WHERE VEHICLE_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, vehicleID);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
