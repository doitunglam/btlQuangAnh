package com.example.btlquanganh;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerView implements Initializable {

    public TabPane mainTabPane;

    public void onRentItemButtonClick(MouseEvent mouseEvent) throws IOException{
        Tab newTab = new Tab("Rent Item");
        BorderPane pane = FXMLLoader.load(getClass().getResource("RentItemTab.fxml"));
        newTab.setContent(pane);
        mainTabPane.getTabs().add(newTab);
    }

    public void onReturnItemButtonClick(MouseEvent mouseEvent) throws IOException {
        Tab newTab = new Tab("Return Item");
        BorderPane pane = FXMLLoader.load(getClass().getResource("ReturnItemTab.fxml"));
        newTab.setContent(pane);
        mainTabPane.getTabs().add(newTab);
    }

    public void onLogoutButtonClick(MouseEvent mouseEvent) throws IOException {
        String outPath = "./data/customers.txt";
        File outFile = new File(outPath);
        outFile.createNewFile();
        FileHandler.writeCustomerToFile(outPath,PublicDataHouse.customerArrayList);
        outPath = "./data/items.txt";
        outFile = new File(outPath);
        outFile.createNewFile();
        FileHandler.writeItemToFile(outPath,PublicDataHouse.itemArrayList);
        Parent pane = FXMLLoader.load(getClass().getResource("WelcomeScene.fxml"));
        SceneController.scene.setRoot(pane);
        MainApplication.stage.setHeight(350);
        MainApplication.stage.setWidth(450);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainTabPane.setTabClosingPolicy( TabPane.TabClosingPolicy.SELECTED_TAB);
    }
}
