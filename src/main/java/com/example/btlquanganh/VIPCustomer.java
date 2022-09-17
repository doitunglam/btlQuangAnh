package com.example.btlquanganh;

import java.util.ArrayList;

public final class VIPCustomer extends Customer{
    Integer rewardPoint;

    public VIPCustomer(String[] attributes, ArrayList<String> rentals)
    {
        super(attributes,(ArrayList<String>) rentals.clone());
        this.rewardPoint = 0;
    }
    @Override
    public void rent(Item item) throws RentalExceptions {
        if(item.rentalStatus <= 0)
            throw new RentalExceptions("Rental item limit exceed");
        item.rentalStatus = item.rentalStatus -1;
        this.rewardPoint += 10;
        this.rentals.add(item.ID);
    }
}
