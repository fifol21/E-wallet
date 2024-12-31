package com.example.delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PackageDAO {
    private Connection connection;
    private static PackageDAO instance;

    private PackageDAO(Connection connection_) {
        this.connection = connection_;
    }

    public static PackageDAO getInstance(Connection connection_) {
        if (instance == null) {
            synchronized (PackageDAO.class) {
                if (instance == null) {
                    instance = new PackageDAO(connection_);
                }
            }
        }
        return instance;
    }

    public void createPackage(Package pack) {
        String sql = "INSERT INTO packages (PACKAGE_ID, WEIGHT, SIZE, IF_FRAGILE) VALUES(?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,pack.getPackageId());
            stmt.setFloat(2,pack.getWeight());
            stmt.setString(3, pack.getSize());
            stmt.setBoolean(4, pack.isIfFragile());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Package getPackage(int packageID) {
        String sql = "SELECT * FROM packages WHERE PACKAGE_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, packageID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Package(
                        rs.getInt("PACKAGE_ID"),
                        rs.getFloat("WEIGHT"),
                        rs.getString("SIZE"),
                        rs.getBoolean("IF_FRAGILE")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updatePackage(Package pack) {
        String sql = "UPDATE packages SET WEIGHT = ?, SIZE = ?, IF_FRAGILE = ? WHERE PACKAGE_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setFloat(1, pack.getWeight());
            stmt.setString(2, pack.getSize());
            stmt.setBoolean(3, pack.isIfFragile());
            stmt.setInt(4,pack.getPackageId());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deletePackage(int PackageID) {
        String sql = "DELETE FROM packages WHERE PACKAGE_ID = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, PackageID);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Package getLastPackage() {
        String sql = "SELECT * FROM packages ORDER BY PACKAGE_ID DESC LIMIT 1";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Package(
                        rs.getInt("PACKGE_ID"),
                        rs.getFloat("WEIGHT"),
                        rs.getString("SIZE"),
                        rs.getBoolean("IF_FRAGILE")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }return null;
    }
}
