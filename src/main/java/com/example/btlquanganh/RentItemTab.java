package com.example.btlquanganh;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class RentItemTab {
    public TextField rentItemIDTextField;

    public void onConfirmButtonClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rental Status");
        alert.setHeaderText("Your Rental Status is:");
        Customer customer = PublicDataHouse.currentCustomer;
        String rentItemID = rentItemIDTextField.getText();
        ArrayList<Item> itemArrayList = PublicDataHouse.itemArrayList;
        Item rentItem = null;
        for (Item it : itemArrayList)
            if (it.ID.equals(rentItemID)) {
                rentItem = it;
                break;
            }
        if (rentItem == null)
        {
            alert.setContentText("Item not found");
        }
        else
            try {
                customer.rentItem(rentItem);
                alert.setContentText("Item rented successfully.");
            } catch (RentalExceptions re) {
                alert.setContentText(re.getMessage());
            }
            alert.showAndWait();
    }
}
