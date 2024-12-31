package com.example.delivery;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class HelloApplication extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primarystage) throws IOException {
        stg = primarystage;
        primarystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primarystage.setTitle("WELCOME TO MileDeliverEx!");
        primarystage.setScene(scene);
        primarystage.show();


    }
    public static void changescene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newstage = new Stage();
        newstage.setScene(scene);
        newstage.setTitle("WELCOME TO MileDeliverEx!");
        newstage.show();
        stg.close();
        stg=newstage;
    }

    public void addCustomer(String name, String address, String phone,CustomerDAO customerDAO) {
        Customer newCustomer = new Customer(name,address,phone,customerDAO);
        customerDAO.saveCustomer(newCustomer);
    }

    public void addVehicle(int VehicleID,int capacity, VehicleDAO vehicleDAO) {
        if(capacity <= 500){
            miniBus minibus = new miniBus(VehicleID);
            vehicleDAO.createVehicle(minibus);
        }else{
            Van van = new Van(VehicleID);
            vehicleDAO.createVehicle(van);
        }
    }
    public static int AssignVehicle(VehicleDAO vehicleDAO, float weight) {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        for(Vehicle vehicle : vehicles) {
            if(vehicle.isAvailable() && (vehicle.getLoad() + weight <= vehicle.getCapacity())) {
                if(vehicle.getLoad() + weight == vehicle.getCapacity()) {
                    vehicle.setAvailable(false);
                    vehicleDAO.updateVehicle(vehicle);
                }
                return vehicle.getVehicleID();
            }
        }return -1;
    }

    public static void createOrder(String customerPhoneNumber, String name, String address, String destination, String size, float weight, boolean ifFragile, CustomerDAO customerDAO,PackageDAO packageDAO,OrderDAO orderDAO, VehicleDAO vehicleDAO) {
        int customerID;
        int orderID;
        String status;
        int vehicleID;
        float cost;
        int packageID;
        Customer orderMaking =customerDAO.readCustomer(customerPhoneNumber);
        if( orderMaking != null) {
            customerID = orderMaking.getCustomerID();
        }else{
            Customer nowy = new Customer(name,address,customerPhoneNumber,customerDAO);
            customerDAO.saveCustomer(nowy);
            customerID = nowy.getCustomerID();
        }

        Package pack = new Package(packageDAO.getLastPackage().getPackageId()+1,weight,size,ifFragile);
        packageDAO.createPackage(pack);
        packageID = pack.getPackageId();
        cost = pack.calculateCost();
        status = "ACCEPTED";
        vehicleID = AssignVehicle(vehicleDAO, weight);
        orderID = orderDAO.getLastOrder().getOrderID()+1;

        Order nowe = new Order(orderID,customerID,destination,status,vehicleID,cost,packageID);
        orderDAO.createOrder(nowe);
    }

    public List<Order> displayAllOrders(OrderDAO orderDAO) {
        return orderDAO.getAllOrders();
    }

    public List<Order> displayPendingOrders(OrderDAO orderDAO) {
        return orderDAO.getPendingOrders();
    }

    public int displayVehicleLoad(int vehicleID,VehicleDAO vehicleDAO) {
        Vehicle read = vehicleDAO.getVehicle(vehicleID);
        return read.getLoad();
    }



    public static void main(String[] args) {
        launch();
    }
}