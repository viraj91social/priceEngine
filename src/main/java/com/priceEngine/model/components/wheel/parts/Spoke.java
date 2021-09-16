package com.priceEngine.model.components.wheel.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public class Spoke implements Part {

    private String type;
    private double price;

    public Spoke(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) {
        this.price = PartPrice.getInstance().fetchSpokePrice(type, date);
        return this.price;
    }

}
