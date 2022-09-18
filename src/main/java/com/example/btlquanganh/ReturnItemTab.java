package com.example.btlquanganh;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ReturnItemTab {
    public TextField returnItemIDTextField;

    public void onConfirmButtonClick(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Return Status");
        alert.setHeaderText("Your Return Status is:");
        Customer customer = PublicDataHouse.currentCustomer;
        String returnItemID = returnItemIDTextField.getText();
            try {
                customer.returnItem(returnItemID);
                alert.setContentText("Item returned successfully.");
            } catch (RentalExceptions re) {
                alert.setContentText(re.getMessage());
            }
        alert.showAndWait();
    }
}
