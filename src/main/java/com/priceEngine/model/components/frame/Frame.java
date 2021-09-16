package com.priceEngine.model.components.frame;

import com.priceEngine.model.Component;
import com.priceEngine.model.Part;

import java.util.List;

public class Frame implements Component {

    List<Part> parts;

    public Frame(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public List<Part> getParts() {
        return this.parts;
    }
}
