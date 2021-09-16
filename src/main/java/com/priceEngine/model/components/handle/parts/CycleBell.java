package com.priceEngine.model.components.handle.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public class CycleBell implements Part {

    private String type;
    private double price;

    public CycleBell(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) {
        this.price = PartPrice.getInstance().fetchCycleBellPrice(type, date);
        return this.price;
    }
}
