package com.example.btlquanganh;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public abstract class Customer {
    private String ID;
    private final String name;
    private final String address;
    private final String phone;
    protected ArrayList<String> rentals;
    protected Integer numberOfRentals;
    public String username;
    private final String password;
    private String[] attributes = null;

    public Customer(String name, String address, String phone, ArrayList<String> rentals, String username, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rentals = rentals;
        this.username = username;
        this.password = password;
    }

    public Customer(String[] attributes, ArrayList<String> rentals) {
        this.attributes = attributes;
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
        return this.password.equals(password);
    }

    abstract void rentItem(Item item) throws RentalExceptions;
    abstract void returnItem(String itemID) throws RentalExceptions;

    public String[] getAttributes()
    {
        return attributes;
    }

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
