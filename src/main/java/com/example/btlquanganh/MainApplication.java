package com.example.btlquanganh;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainApplication extends Application {
    static public Stage stage;
    static ArrayList<Item> itemList = FileHandler.InputItemList("./data/items.txt");
    static ArrayList<Customer> customerList = FileHandler.InputCustomerList("./data/customers.txt");

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        Parent pane = FXMLLoader.load(getClass().getResource("WelcomeScene.fxml"));
        SceneController.scene.setRoot(pane);
        stage.setTitle("Welcome!");
        stage.setScene(SceneController.scene);
        stage.setWidth(450);
        stage.setHeight(350);
        stage.show();
    }
    public static void main(String[] args) {
        PublicDataHouse.setItemArrayList(itemList);
        PublicDataHouse.setCustomerArrayList(customerList);
        try {
            launch();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}