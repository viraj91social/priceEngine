package com.priceEngine.model.components.chain.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public class ChainRing implements Part {

    private String type;
    private double price;

    public ChainRing(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) {
        this.price = PartPrice.getInstance().fetchChainRingPrice(type, date);
        return this.price;
    }
}
