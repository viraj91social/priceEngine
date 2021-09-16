package com.priceEngine.model;

import com.priceEngine.service.PartPrice;

import java.time.LocalDate;

public interface Part {
    double getPrice(LocalDate date);
}
