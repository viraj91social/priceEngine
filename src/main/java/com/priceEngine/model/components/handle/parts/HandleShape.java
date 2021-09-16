package com.priceEngine.model.components.handle.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public class HandleShape implements Part {

    private String type;
    private double price;

    public HandleShape(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) {
        this.price = PartPrice.getInstance().fetchHandleShapePrice(type, date);
        return this.price;
    }
}