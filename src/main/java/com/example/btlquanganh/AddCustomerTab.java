package com.example.btlquanganh;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class AddCustomerTab {
    public TextField IDTextField;
    public TextField phoneTextField;
    public TextField nameTextField;
    public TextField usernameTextField;
    public TextField addressTextField;
    public TextField passwordTextField;
    public TextField numberOfRentalsTextField;
    public TextArea rentalsTextArea;
    public TextField customerTypeTextField;

    public void onConfirmButtonClicked(MouseEvent mouseEvent) {
        ArrayList<TextField> allTextField = new ArrayList<>();
        allTextField.add(IDTextField);
        allTextField.add(nameTextField);
        allTextField.add(addressTextField);
        allTextField.add(phoneTextField);
        allTextField.add(numberOfRentalsTextField);
        allTextField.add(numberOfRentalsTextField);
        allTextField.add(usernameTextField);
        allTextField.add(passwordTextField);

        ArrayList<String> dataArrayList = new ArrayList<>();
        for(TextField tf:allTextField)
            dataArrayList.add(tf.getText());
        String[] dataArray = dataArrayList.toArray(new String[0]);

        String[] rentals = rentalsTextArea.getText().split("\n");

        String customerType = customerTypeTextField.getText();
        if (customerType.equals("VIP"))
            PublicDataHouse.customerArrayList.add(new VIPCustomer(dataArray,new ArrayList<>(Arrays.asList(rentals))));
        else if (customerType.equals("Regular"))
            PublicDataHouse.customerArrayList.add(new RegularCustomer(dataArray,new ArrayList<>(Arrays.asList(rentals))));
        else if (customerType.equals("Guest"))
            PublicDataHouse.customerArrayList.add(new GuestCustomer(dataArray,new ArrayList<>(Arrays.asList(rentals))));


    }
}
