package com.example.delivery;
import java.sql.Connection;

public class AppContext {
    public static Connection connection;
    public static CustomerDAO customerDAO;
    public static OrderDAO orderDAO;
    public static PackageDAO packageDAO;
    public static VehicleDAO vehicleDAO;
    public static LoginService loginService;

    static{
        try{
            connection = DatabaseConnector.getConnection();
            customerDAO = CustomerDAO.getInstance(connection);
            orderDAO = OrderDAO.getInstance(connection);
            packageDAO = PackageDAO.getInstance(connection);
            vehicleDAO = VehicleDAO.getInstance(connection);
            loginService = LoginService.getInstance(connection);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize connection with database!",e);
        }
    }

    //getters and setters for all DAOs classes
    public static CustomerDAO getCustomerDAO(){
        return customerDAO;
    }
    public static OrderDAO getOrderDAO(){
        return orderDAO;
    }
    public static PackageDAO getPackageDAO(){
        return packageDAO;
    }
    public static VehicleDAO getVehicleDAO(){
        return vehicleDAO;
    }
    public static LoginService getLoginService(){
        return loginService;
    }
}
