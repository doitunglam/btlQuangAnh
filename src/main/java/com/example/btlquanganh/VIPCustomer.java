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
    public void rentItem(Item item) throws RentalExceptions {
        if(item.rentalStatus <= 0)
            throw new RentalExceptions("Rent Item not available");
        item.rentalStatus = item.rentalStatus -1;
        this.rentals.add(item.ID);
    }
    @Override
    void returnItem(String itemID) throws RentalExceptions {
        ArrayList<Item> items = PublicDataHouse.itemArrayList;
        for(String s:this.rentals)
            if (s.equals(itemID))
            {
                for (Item it:items)
                    if(it.ID.equals(s))
                    {
                        this.numberOfRentals++;
                        it.rentalStatus++;
                        this.rentals.remove(s);
                        this.rewardPoint += 10;
                        throw new RentalExceptions("Return Item Successfully.");
                    }
                throw new RentalExceptions("Can't find item in item list.");
            }
        throw new RentalExceptions("Can't find item in rental list.");
    }

}
