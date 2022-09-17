package com.example.btlquanganh;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    static ArrayList<Item> itemList = FileHandler.InputItemList("./data/items.txt");
    static ArrayList<Customer> customerList = FileHandler.InputCustomerList("./data/customers.txt");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        PublicDataHouse.setItemArrayList(itemList);
        PublicDataHouse.setCustomerArrayList(customerList);
        launch();
    }
}