package com.priceEngine.model;

import com.priceEngine.exception.PartPriceNotFoundException;

import java.time.LocalDate;

public interface Part {
    double getPrice(LocalDate date) throws PartPriceNotFoundException;
}
