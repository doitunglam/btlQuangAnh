package com.example.btlquanganh;

import javafx.beans.property.*;

public class Item {
    String ID;
    String title;
    String rentType;
    String loanType;
    String genre;
    float rentalFee;
    /* number of the items in stock. Greater than 0 denotes available,
        and not greater than 0 denotes not available */
    Integer rentalStatus;

    public Item(String[] attributes) {
        this.ID = attributes[0];
        this.title = attributes[1];
        this.rentType = attributes[3];
        this.loanType = attributes[2];
        this.rentalStatus = Integer.parseInt(attributes[4]);
        this.rentalFee = Float.parseFloat(attributes[5]);
        if (attributes.length != 6)
            this.genre = attributes[6];
    }

    public StringProperty IDProperty() {
        return new SimpleStringProperty(ID);
    };
    public StringProperty titleProperty() {
        return new SimpleStringProperty(title);
    };
    public StringProperty rentTypeProperty() {
        return new SimpleStringProperty(rentType);
    };
    public IntegerProperty rentalStatusProperty() {
        return new SimpleIntegerProperty(rentalStatus);
    };
    public StringProperty loanTypeProperty() {
        return new SimpleStringProperty(loanType);
    };
    public FloatProperty rentalFeeProperty() {
        return new SimpleFloatProperty(rentalFee);
    };
    public StringProperty genreProperty() {
        return new SimpleStringProperty(genre);
    };


}
