package com.priceEngine.model.components.handle.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public class Brake implements Part {

    private String type;
    private double price;

    public Brake(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) {
        this.price = PartPrice.getInstance().fetchBrakePrice(type, date);
        return this.price;
    }
}
