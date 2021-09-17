package com.priceEngine.model.components.frame.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.FetchPartPrice;
import com.priceEngine.service.PartPriceNotFoundException;

import java.time.LocalDate;

public class Paint implements Part {

    private String type;
    private double price;

    public Paint(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) throws PartPriceNotFoundException {
        this.price = FetchPartPrice.getInstance().fetchPaintPrice(type, date);
        return this.price;
    }

}
