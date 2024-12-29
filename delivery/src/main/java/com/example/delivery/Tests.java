package com.example.delivery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tests {

    public static void main(String[] args){
        Connection connection = DatabaseConnector.getConnection();
        CustomerDAO customerDAO = new CustomerDAO(connection);
        OrderDAO orderDAO = new OrderDAO(connection);
        VehicleDAO vehicleDAO = new VehicleDAO(connection);
        PackageDAO packageDAO = new PackageDAO(connection);
        LoginService loginService = new LoginService(connection);

//        Package paczka = new Package(375,4,"S",false);
//        packageDAO.createPackage(paczka);
//        Vehicle nowy_samochod = new Vehicle(2,"BUS",true,500,800);
//        System.out.println(nowy_samochod.isAvailable());
//        vehicleDAO.createVehicle(nowy_samochod);
//        Customer nowy_klient = new Customer(2,"janusz","bydgoszcz","123456789");
//        customerDAO.saveCustomer(nowy_klient);
//        Order nowy = new Order(1,2,"kraczkowa","Ndadany",2, 50,375);
//        orderDAO.createOrder(nowy);
//        Order kolejny = new Order(1,2,"kraczkowa","dostarczony",2, 50,375);
//        orderDAO.updateOrder(kolejny);
//        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
//        System.out.println(vehicles.get(0).getVehicleID());
        System.out.println(loginService.login("worker123","strongPassword"));
    }
}
