package com.priceEngine.model.components.wheel.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public class Rim implements Part {

    private String type;
    private double price;

    public Rim(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) {
        this.price = PartPrice.getInstance().fetchRimPrice(type, date);
        return this.price;
    }
}
