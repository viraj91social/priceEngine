package com.priceEngine.model;

import java.time.LocalDate;
import java.util.List;

public class Cycle {

    List<Component> components;

    public Cycle() {}

    public Cycle(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

}
