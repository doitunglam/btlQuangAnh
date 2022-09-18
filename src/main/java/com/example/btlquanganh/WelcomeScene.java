package com.example.btlquanganh;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;

public class WelcomeScene {
    public TextField usernameTextField;
    public PasswordField passwordPasswordField;

    public void onLoginButtonClicked(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        String username = usernameTextField.getText();
        if (username.equals("a") && passwordPasswordField.getText().equals("a")) {
            alert.setTitle("Welcome");
            alert.setHeaderText("Good morning, boss");
            alert.setContentText("Enter the privileged zone");
            alert.showAndWait();
            Parent pane = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            BorderPane borderPane = (BorderPane) pane;
            SceneController.scene.setRoot(pane);
            MainApplication.stage.setHeight(600);
            MainApplication.stage.setWidth(800);
            return;
        }
        ArrayList<Customer> customerArrayList = PublicDataHouse.customerArrayList;
        Customer targetCustomer = null;
        for (Customer cs : customerArrayList)
            if (cs.username.equals(username)) {
                targetCustomer = cs;
                break;
            }
        if (targetCustomer == null) {
            alert.setHeaderText("Warning!");
            alert.setTitle("Not Found!");
            alert.setContentText("Username not found. Please check and try again!");
            alert.showAndWait();
        }
        if (targetCustomer != null) {
            if (targetCustomer.authentication(passwordPasswordField.getText())) {
                alert.setHeaderText("Welcome!");
                alert.setTitle("Login Success");
                alert.setContentText("Login successfully");
                Parent pane = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
                PublicDataHouse.currentCustomer = targetCustomer;
                SceneController.scene.setRoot(pane);
                MainApplication.stage.setHeight(600);
                MainApplication.stage.setWidth(800);
                alert.showAndWait();
            } else {
                alert.setTitle("Wrong Password");
                alert.setContentText("The password is wrong. Please check and try again.");
                alert.setHeaderText("Warning");
                alert.showAndWait();
            }
        }
    }
}
