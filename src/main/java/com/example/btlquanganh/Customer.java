package com.example.btlquanganh;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public abstract class Customer {
    private String ID;
    private String name;
    private String address;
    private String phone;
    protected ArrayList<String> rentals;
    protected Integer numberOfRentals;
    public String username;
    private String password;

    public Customer(String name, String address, String phone, ArrayList<String> rentals, String username, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rentals = rentals;
        this.username = username;
        this.password = password;
    }

    public Customer(String[] attributes, ArrayList<String> rentals) {
        this.ID = attributes[0];
        this.name = attributes[1];
        this.address = attributes[2];
        this.phone = attributes[3];
        this.numberOfRentals = Integer.parseInt(attributes[4]);
        this.rentals = rentals;
        this.username = attributes[6];
        this.password = attributes[7];
    }

    public boolean authentication(String password) {
        if (this.password.equals(password)) return true;
        else return false;
    }

    abstract void rent(Item item) throws RentalExceptions;

    public StringProperty IDProperty() {
        return new SimpleStringProperty(ID);
    }
    public StringProperty nameProperty(){
        return new SimpleStringProperty(name);
    }
    public StringProperty addressProperty(){
        return new SimpleStringProperty(address);
    }
    public StringProperty phoneProperty(){
        return new SimpleStringProperty(phone);
    }
    public StringProperty usernameProperty(){
        return new SimpleStringProperty(username);
    }
    public  StringProperty passwordProperty(){
        return new SimpleStringProperty(password);
    }
}
