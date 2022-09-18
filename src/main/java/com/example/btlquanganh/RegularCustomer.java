package com.example.btlquanganh;

import java.util.ArrayList;

public final class RegularCustomer extends Customer {
    public RegularCustomer(String[] attributes, ArrayList<String> rentals){
        super(attributes,(ArrayList<String>) rentals.clone());
    }

    @Override
    public void rentItem(Item item) throws RentalExceptions {
        if(item.rentalStatus <= 0)
            throw new RentalExceptions("Rental item limit exceed");
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
                        throw new RentalExceptions("Return Item Successfully.");
                    }
                throw new RentalExceptions("Can't find item in item list.");
            }
        throw new RentalExceptions("Can't find item in rental list.");
    }

}
