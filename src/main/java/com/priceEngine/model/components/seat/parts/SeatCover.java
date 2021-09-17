package com.priceEngine.model.components.seat.parts;

import com.priceEngine.model.Part;
import com.priceEngine.service.FetchPartPrice;
import com.priceEngine.exception.PartPriceNotFoundException;

import java.time.LocalDate;

public class SeatCover implements Part {

    private String type;
    private double price;

    public SeatCover(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(LocalDate date) throws PartPriceNotFoundException {
        this.price = FetchPartPrice.getInstance().fetchSeatCoverPrice(type, date);
        return this.price;
    }
}
