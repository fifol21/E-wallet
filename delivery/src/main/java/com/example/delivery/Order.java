package com.example.delivery;

public class Order {
    private int orderID;
    private int customerID;
    private String destination;
    private String status;
    private int vehicleID;
    private float cost;
    private int packageID;

    public Order(int orderID, int customerID, String destination, String status, int vehicleID, float cost, int packageID) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.destination = destination;
        this.status = status;
        this.vehicleID = vehicleID;
        this.cost = cost;
        this.packageID = packageID;
    }



 // getters and setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomer(int customerID) {
        this.customerID = customerID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicle(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public void UpdateStatus(String status) {
        this.status = status;

    }
    }

