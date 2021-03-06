package com.priceEngine.model.components.wheel.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.FetchPartPrice;
import com.priceEngine.exception.PartPriceNotFoundException;

import java.time.LocalDate;

public class Spoke implements Part {

    private String type;
    private double price;

    public Spoke(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) throws PartPriceNotFoundException {
        this.price = FetchPartPrice.getInstance().fetchSpokePrice(type, date);
        return this.price;
    }

}
