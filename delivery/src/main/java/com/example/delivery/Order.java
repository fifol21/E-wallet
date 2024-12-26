package com.example.delivery;

public class Order {
    private int orderID;
    private Customer customer;
    private String destination;
    private String status;
    private Vehicle vehicle;
    private float cost;

    public Order(int orderID, Customer customer, String destination, String status, Vehicle vehicle, float cost) {
        this.orderID = orderID;
        this.customer = customer;
        this.destination = destination;
        this.status = status;
        this.vehicle = vehicle;
        this.cost = cost;
    }
 // getters and setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
