package com.example.btlquanganh;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class DeleteItemTab {
    public TextField deleteIDTextField;

    public void onConfirmButtonClicked(MouseEvent mouseEvent) {
        String deleteID = deleteIDTextField.getText();
        ArrayList<Item> itemArrayList = PublicDataHouse.itemArrayList;
        for(Item it:itemArrayList){
            if (it.ID.equals(deleteID)){
                itemArrayList.remove(it);
                break;
            }
        }
    }
}
