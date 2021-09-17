package com.priceEngine.service;

import com.priceEngine.model.Component;
import com.priceEngine.model.Part;

import java.time.LocalDate;
import java.util.List;

public class PriceUtil {

    public double getComponentsPrice(List<Component> components, LocalDate date) throws PartPriceNotFoundException{
        double price = 0;
        for (Component component : components) {
            price += getPartsPrice(component.getParts(), date);
        }
        return price;
    }

    public double getPartsPrice(List<Part> parts, LocalDate date) throws PartPriceNotFoundException{
        double price = 0;
        for (Part part : parts) {
            price += part.getPrice(date);
        }
        return price;
    }

    public double getPartsAssemblyCost() {
        return 0;
    }

    public double getComponentsAssemblyCost() {
        return 0;
    }
}
