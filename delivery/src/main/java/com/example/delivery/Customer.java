package com.example.delivery;

public class Customer {
    private int customerID;
    private String name;
    private String address;
    private String contactNumber;

    public Customer(int customerID, String name, String address, String contactNumber) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

// getters and setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", name=" + name + ", address=" + address + ", contactNumber=" + contactNumber + "]";
    }
}
