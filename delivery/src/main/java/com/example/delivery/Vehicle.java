package com.example.delivery;

public class Vehicle {
    private int vehicleID;
    private String type;
    private boolean isAvailable;
    private int load;
    private int capacity;
    private int weight;

    public Vehicle(int vehicleID, String type, boolean available, int load, int capacity, int weight) {
        this.vehicleID = vehicleID;
        this.type = type;
        this.isAvailable = available;
        this.load = load;
        this.capacity = capacity;
        this.weight = weight;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
