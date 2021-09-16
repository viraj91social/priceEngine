package com.priceEngine.service;

import java.time.LocalDate;

public class PartPrice {

    private static PartPrice partPrice;

    private PartPrice() {}

    public static PartPrice getInstance() {
        if(partPrice == null)
            partPrice = new PartPrice();

        return partPrice;
    }

    public double fetchSpokePrice(String type, LocalDate date) {
        if(type == "premium") return 100.0;
        else return 90.0;
    }

    public double fetchRimPrice(String type, LocalDate date) {
        if(type == "premium") return 150.0;
        else return 130.0;
    }

    public double fetchTubePrice(String type, LocalDate date) {
        if(type == "none") return 0.0;
        else if(type == "premium") return 80.0;
        else return 70.0;
    }

    public double fetchTyrePrice(String type, LocalDate date) {
        if(type == "tubeless") return 200.0;
        else return 150.0;
    }

    public double fetchFrameMaterialPrice(String type, LocalDate date) {
        if(type == "steel") return 800.0;
        else return 700.0;
    }

    public double fetchPaintPrice(String type, LocalDate date) {
        if(type == "water_resistant") return 100.0;
        else return 80.0;
    }

    public double fetchSeatCoverPrice(String type, LocalDate date) {
        if(type == "soft") return 100.0;
        else return 80.0;
    }

    public double fetchSeatMaterialPrice(String type, LocalDate date) {
        if(type == "foam") return 100.0;
        else return 80.0;
    }

    public double fetchChainRingPrice(String type, LocalDate date) {
        if(type == "normal") return 200.0;
        else return 180.0;
    }

    public double fetchGearPrice(int numberOfGears, LocalDate date) {
        return calculateGearPrice(numberOfGears);
    }

    private double calculateGearPrice(int numberOfGears) {
        double basePrice = 200;
        double multiplier = 50;
        double price = basePrice + multiplier*numberOfGears;
        return price;
    }

    public double fetchBrakePrice(String type, LocalDate date) {
        if(type == "disk") return 400.0;
        else return 350.0;
    }

    public double fetchHandleShapePrice(String type, LocalDate date) {
        if(type == "TShape") return 500.0;
        else if(type == "CShape") return 450;
        else return 400.0;
    }

    public double fetchCycleBellPrice(String type, LocalDate date) {
        if(type == "loud") return 100.0;
        else return 80.0;
    }
}
