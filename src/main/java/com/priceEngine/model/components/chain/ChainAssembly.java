package com.priceEngine.model.components.chain;

import com.priceEngine.model.Component;
import com.priceEngine.model.Part;

import java.util.List;

public class ChainAssembly implements Component {

    List<Part> parts;

    public ChainAssembly(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public List<Part> getParts() {
        return this.parts;
    }

}
