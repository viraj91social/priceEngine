package com.priceEngine.model.components.frame.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.FetchPartPrice;
import com.priceEngine.service.PartPriceNotFoundException;

import java.time.LocalDate;

public class FrameMaterial implements Part {

    private String material;
    private double price;

    public FrameMaterial(String type) {
        this.material = type;
    }

    @Override
    public double getPrice(LocalDate date) throws PartPriceNotFoundException {
        this.price = FetchPartPrice.getInstance().fetchFrameMaterialPrice(material, date);
        return this.price;
    }

}
