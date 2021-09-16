package com.priceEngine.model.components.seat.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public class SeatMaterial implements Part {

    private String type;
    private double price;

    public SeatMaterial(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) {
        this.price = PartPrice.getInstance().fetchSeatMaterialPrice(type, date);
        return this.price;
    }
}
