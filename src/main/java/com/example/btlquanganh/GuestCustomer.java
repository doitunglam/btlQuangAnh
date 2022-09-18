package com.example.btlquanganh;

import java.util.ArrayList;

public final class GuestCustomer extends Customer{
    private static final int MAX_RENT_ITEM = 2;
    public GuestCustomer(String[] attributes, ArrayList<String> rentals){
        super(attributes,(ArrayList<String>) rentals.clone());
    }

    @Override
    public void rentItem(Item item) throws RentalExceptions {
        if (this.rentals.size() >=2)
            throw new RentalExceptions("Rental item limit exceed");
        if (item.rentalStatus <= 0)
            throw new RentalExceptions("Item not available");
        if (item.rentType.equals("2-day"))
            throw new RentalExceptions("Guest cannot rent this item, only VIP or Regular can");
        rentals.add(item.ID);
        item.rentalStatus--;
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
