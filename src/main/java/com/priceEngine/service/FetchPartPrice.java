package com.priceEngine.service;

import java.time.LocalDate;


/**
 * Responsible for fetching prices of various parts
 * from DB or through API.
 */
public class FetchPartPrice {

    private static FetchPartPrice fetchPartPrice;

    private FetchPartPrice() {}

    public static FetchPartPrice getInstance() {
        if(fetchPartPrice == null)
            fetchPartPrice = new FetchPartPrice();

        return fetchPartPrice;
    }

    public double fetchSpokePrice(String type, LocalDate date) throws PartPriceNotFoundException {
        if(type == "premium") return 100.0;
        else throw new PartPriceNotFoundException("Spoke Price not Found for the type: " + type);
    }

    public double fetchRimPrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "premium") return 150.0;
        else return 130.0;
    }

    public double fetchTubePrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "none") return 0.0;
        else if(type == "premium") return 80.0;
        else return 70.0;
    }

    public double fetchTyrePrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "tubeless") return 200.0;
        else return 150.0;
    }

    public double fetchFrameMaterialPrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "steel") return 800.0;
        else return 700.0;
    }

    public double fetchPaintPrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "water_resistant") return 100.0;
        else return 80.0;
    }

    public double fetchSeatCoverPrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "soft") return 100.0;
        else return 80.0;
    }

    public double fetchSeatMaterialPrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "foam") return 100.0;
        else return 80.0;
    }

    public double fetchChainRingPrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "normal") return 200.0;
        else return 180.0;
    }

    public double fetchGearPrice(int numberOfGears, LocalDate date) throws PartPriceNotFoundException {
        return calculateGearPrice(numberOfGears);
    }

    private double calculateGearPrice(int numberOfGears) throws PartPriceNotFoundException{
        double basePrice = 200;
        double multiplier = 50;
        double price = basePrice + multiplier*numberOfGears;
        return price;
    }

    public double fetchBrakePrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "disk") return 400.0;
        else return 350.0;
    }

    public double fetchHandleShapePrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "TShape") return 500.0;
        else if(type == "CShape") return 450;
        else return 400.0;
    }

    public double fetchCycleBellPrice(String type, LocalDate date) throws PartPriceNotFoundException{
        if(type == "loud") return 100.0;
        else return 80.0;
    }
}
