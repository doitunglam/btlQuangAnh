package com.example.btlquanganh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminView implements Initializable {
    public AnchorPane addItemTab;
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Item> itemTable = new TableView<>();
    @FXML
    private TableView<Customer> customerTable = new TableView<>();

    @FXML
    private TabPane mainTabPane;

    private TableColumn createCol(Class c, String columnName, String propertyName) {
        if (c.equals(Item.class)) {
            TableColumn<Item, String> returnCol = new TableColumn<>(columnName);
            returnCol.setCellValueFactory(new PropertyValueFactory<Item, String>(propertyName));
            return returnCol;
        } else if (c.equals(Customer.class)) {
            TableColumn<Customer, String> returnCol = new TableColumn<>(columnName);
            returnCol.setCellValueFactory(new PropertyValueFactory<Customer, String>(propertyName));
            return returnCol;
        } else return null;

    }

    @FXML
    protected void onCreateItemTableButtonClick() {
        Tab newTab = new Tab("Items");
        ArrayList<Item> itemArrayList = PublicDataHouse.itemArrayList;
        ObservableList<Item> itemObservableList = FXCollections.observableList(itemArrayList);
        TableColumn<Item, String> IDCol = createCol(Item.class, "ID", "ID");
        TableColumn<Item, String> titleCol = createCol(Item.class, "Title", "title");
        TableColumn<Item, String> rentTypeCol = createCol(Item.class, "Rent type", "rentType");
        TableColumn<Item, String> loanTypeCol = createCol(Item.class, "Loan type", "loanType");
        TableColumn<Item, String> rentalStatusCol = createCol(Item.class, "Rental status", "rentalStatus");
        TableColumn<Item, String> rentalFeeCol = createCol(Item.class, "Rental fee", "rentalFee");
        TableColumn<Item, String> genreCol = createCol(Item.class, "Genre", "genre");
        itemTable.setItems(itemObservableList);
        itemTable.getColumns().addAll(IDCol, titleCol, rentTypeCol, loanTypeCol, rentalStatusCol, rentalFeeCol, genreCol);
        newTab.setContent(itemTable);
        mainTabPane.getTabs().add(newTab);

    }

    @FXML
    protected void onCreateCustomerTableButtonClick() {
        Tab newTab = new Tab("Customers");

        ArrayList<Customer> customerArrayList = PublicDataHouse.customerArrayList;
        ObservableList<Customer> customerObservableList = FXCollections.observableList(customerArrayList);
        TableColumn<Customer, String> IDCol = createCol(Customer.class, "ID", "ID");
        TableColumn<Customer, String> nameCol = createCol(Customer.class, "Name", "name");
        TableColumn<Customer, String> addressCol = createCol(Customer.class, "Address", "address");
        TableColumn<Customer, String> phoneCol = createCol(Customer.class,"Phone","phone");
        TableColumn<Customer, String> usernameCol = createCol(Customer.class,"Username","username");
        TableColumn<Customer, String> passwordCol = createCol(Customer.class,"Password","password");
        customerTable.setItems(customerObservableList);
        customerTable.getColumns().addAll(IDCol,nameCol,addressCol,phoneCol,usernameCol,passwordCol);
        newTab.setContent(customerTable);
        mainTabPane.getTabs().add(newTab);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainTabPane.setTabClosingPolicy( TabPane.TabClosingPolicy.SELECTED_TAB);
    }
    @FXML
    public void onAddItemMenuClick() throws IOException {
        Tab newTab = new Tab("Add Item");
        BorderPane pane = FXMLLoader.load(getClass().getResource("AddItemTab.fxml"));
        newTab.setContent(pane);
        mainTabPane.getTabs().add(newTab);
    }

    public void onUpdateItemMenuClick(ActionEvent actionEvent) {
    }

    public void onDeleteItemMenuClick(ActionEvent actionEvent) {
    }

    public void onAddCustomerMenuClick(ActionEvent actionEvent) {
    }

    public void onUpdateCustomerMenuClick(ActionEvent actionEvent) {
    }
}