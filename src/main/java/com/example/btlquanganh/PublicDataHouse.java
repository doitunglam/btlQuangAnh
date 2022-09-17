package com.example.btlquanganh;

import java.util.ArrayList;

public class PublicDataHouse {
    static ArrayList<Item> itemArrayList = null;
    static ArrayList<Customer> customerArrayList = null;
    static void setItemArrayList(ArrayList<Item> input)
    {
        itemArrayList = input;
    }
    static void setCustomerArrayList(ArrayList<Customer> input)
    {
        customerArrayList = input;
    }
}
