package com.priceEngine.model.components.seat;

import com.priceEngine.model.Component;
import com.priceEngine.model.Part;

import java.util.List;

public class Seating implements Component {

    List<Part> parts;

    public Seating(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public List<Part> getParts() {
        return this.parts;
    }

}
