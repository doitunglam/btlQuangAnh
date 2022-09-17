package com.example.btlquanganh;

import java.util.ArrayList;

public final class GuestCustomer extends Customer{
    private static final int MAX_RENT_ITEM = 2;
    public GuestCustomer(String[] attributes, ArrayList<String> rentals){
        super(attributes,(ArrayList<String>) rentals.clone());
    }

    @Override
    public void rent(Item item) throws RentalExceptions {
        if (this.rentals.size() >=2)
            throw new RentalExceptions("Rental item limit exceed");
        if (item.rentalStatus <= 0)
            throw new RentalExceptions("Item not available");
        if (item.rentType.equals("2-day"))
            throw new RentalExceptions("Guest cannot rent this item, only VIP or Regular can");
        rentals.add(item.ID);
        item.rentalStatus--;
    }

}
