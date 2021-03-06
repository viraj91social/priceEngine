package com.priceEngine.model.components.chain.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.FetchPartPrice;
import com.priceEngine.exception.PartPriceNotFoundException;

import java.time.LocalDate;

public class ChainRing implements Part {

    private String type;
    private double price;

    public ChainRing(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) throws PartPriceNotFoundException {
        this.price = FetchPartPrice.getInstance().fetchChainRingPrice(type, date);
        return this.price;
    }
}
