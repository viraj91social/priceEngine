package com.priceEngine.model.components.handle;

import com.priceEngine.model.Component;
import com.priceEngine.model.Part;

import java.util.List;

public class HandleBarWithBrake implements Component {

    List<Part> parts;

    public HandleBarWithBrake(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public List<Part> getParts() {
        return this.parts;
    }
}
