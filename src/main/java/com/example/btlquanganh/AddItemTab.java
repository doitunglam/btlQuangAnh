package com.example.btlquanganh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class AddItemTab {
    public TextField genreTextField;
    public TextField rentalStatusTextField;
    public TextField titleTextField;
    public TextField rentalFeeTextField;
    public TextField rentalTypeTextField;
    public TextField loanTypeTextField;
    public TextField IDTextField;

    @FXML
    public void confirmButtonOnClick(ActionEvent actionEvent) {

        ArrayList<TextField> allTextFields = new ArrayList<>();
        allTextFields.add(IDTextField);
        allTextFields.add(titleTextField);
        allTextFields.add(rentalTypeTextField);
        allTextFields.add(loanTypeTextField);
        allTextFields.add(rentalStatusTextField);
        allTextFields.add(rentalFeeTextField);
        allTextFields.add(genreTextField);

        ArrayList<String> dataArrayList = new ArrayList<>();
        for (TextField tf:allTextFields)
            dataArrayList.add(tf.getText());
        String[] dataArray = dataArrayList.toArray(new String[0]);
        PublicDataHouse.itemArrayList.add(new Item(dataArray));

        Alert completeAlert = new Alert(Alert.AlertType.INFORMATION);
        completeAlert.setTitle("Input Done");
        completeAlert.setContentText("The information has entered successfully.");
        completeAlert.showAndWait();
        for(TextField tf:allTextFields)
            tf.clear();
    }
}
