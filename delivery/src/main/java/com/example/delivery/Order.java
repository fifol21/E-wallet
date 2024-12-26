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
}
