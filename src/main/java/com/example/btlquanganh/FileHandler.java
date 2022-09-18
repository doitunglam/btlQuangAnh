package com.example.btlquanganh;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    static public ArrayList<Item> InputItemList(String pathName) {
        ArrayList<Item> returnList = new ArrayList<>();
        try {
            File inputFile = new File(pathName);
            Scanner readerScanner = new Scanner(inputFile);
            while (readerScanner.hasNextLine()) {
                String inputLine = readerScanner.nextLine();
                if (!inputLine.startsWith("#")) {
                    String[] dataArray = inputLine.split(",");
                    Item newItem = new Item(dataArray);
                    returnList.add(newItem);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return returnList;
    }

    static public ArrayList<Customer> InputCustomerList(String pathName) {
        ArrayList<Customer> returnList = new ArrayList<>();
        String[] currentCustomerData = null;
        ArrayList<String> rentals = new ArrayList<>();
        try {
            File inputFile = new File(pathName);
            Scanner readerScanner = new Scanner(inputFile);
            while (readerScanner.hasNextLine()) {
                String inputLine = readerScanner.nextLine();
                if (!inputLine.startsWith("#")) {
                    String[] dataArray = inputLine.split(",");
                    for (int i = 0; i< dataArray.length;i++)
                        dataArray[i] = dataArray[i].trim();
                    boolean isLastLine = !readerScanner.hasNextLine();
                    if (dataArray.length == 8) {
                        if (currentCustomerData != null) {
                            String customerType = currentCustomerData[5];
                            Customer newCustomer;
                            if (customerType.equals("Regular"))
                                newCustomer = new RegularCustomer(currentCustomerData, rentals);
                            else if (customerType.equals("VIP"))
                                newCustomer = new VIPCustomer(currentCustomerData, rentals);
                            else newCustomer = new GuestCustomer(currentCustomerData, rentals);
                            returnList.add(newCustomer);
                            rentals.clear();
                        }
                        currentCustomerData = dataArray;
                    } else rentals.add(dataArray[0]);
                    if (isLastLine) {
                        String customerType = currentCustomerData[5];
                        Customer newCustomer;
                        if (customerType.equals("Regular"))
                            newCustomer = new RegularCustomer(currentCustomerData, rentals);
                        else if (customerType.equals("VIP"))
                            newCustomer = new VIPCustomer(currentCustomerData, rentals);
                        else newCustomer = new GuestCustomer(currentCustomerData, rentals);
                        returnList.add(newCustomer);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return returnList;
    }
    static public void writeCustomerToFile(String path,ArrayList<Customer> data) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for(Customer cs:data)
        {
            writer.append(String.join(",",cs.getAttributes())+'\n');
            for(String rt:cs.rentals)
                writer.append(rt+'\n');
        }
        writer.close();
    }
    static public void writeItemToFile(String path,ArrayList<Item> data) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for(Item it:data)
            writer.append(String.join(",",it.attributes)+'\n');
        writer.close();
    }
}
