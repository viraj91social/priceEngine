package com.priceEngine.model.components.wheel;

import com.priceEngine.model.Component;
import com.priceEngine.model.Part;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wheels implements Component {

    List<Part> frontWheelParts;
    List<Part> rearWheelParts;
    public Wheels() {}

    public Wheels(List<Part> frontWheelParts, List<Part> rearWheelParts) {
        this.frontWheelParts = frontWheelParts;
        this.rearWheelParts = rearWheelParts;
    }

    @Override
    public List<Part> getParts() {
        return Stream.of(frontWheelParts, rearWheelParts)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
