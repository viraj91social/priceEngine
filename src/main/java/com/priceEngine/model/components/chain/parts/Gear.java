package com.priceEngine.model.components.chain.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.FetchPartPrice;
import com.priceEngine.service.PartPriceNotFoundException;

import java.time.LocalDate;

public class Gear implements Part {

    private String type;
    private int numberOfGears;
    private double price;

    public Gear(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    @Override
    public double getPrice(LocalDate date) throws PartPriceNotFoundException {
        this.price = FetchPartPrice.getInstance().fetchGearPrice(numberOfGears, date);
        return this.price;
    }
}
