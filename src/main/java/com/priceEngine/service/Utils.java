package com.priceEngine.service;

import com.priceEngine.model.Component;
import com.priceEngine.model.Cycle;
import com.priceEngine.model.Part;
import com.priceEngine.model.components.chain.ChainAssembly;
import com.priceEngine.model.components.chain.parts.ChainRing;
import com.priceEngine.model.components.chain.parts.Gear;
import com.priceEngine.model.components.frame.Frame;
import com.priceEngine.model.components.frame.parts.FrameMaterial;
import com.priceEngine.model.components.frame.parts.Paint;
import com.priceEngine.model.components.handle.HandleBarWithBrake;
import com.priceEngine.model.components.handle.parts.Brake;
import com.priceEngine.model.components.handle.parts.CycleBell;
import com.priceEngine.model.components.handle.parts.HandleShape;
import com.priceEngine.model.components.seat.Seating;
import com.priceEngine.model.components.seat.parts.SeatCover;
import com.priceEngine.model.components.seat.parts.SeatMaterial;
import com.priceEngine.model.components.wheel.Wheels;
import com.priceEngine.model.components.wheel.parts.Rim;
import com.priceEngine.model.components.wheel.parts.Spoke;
import com.priceEngine.model.components.wheel.parts.Tube;
import com.priceEngine.model.components.wheel.parts.Tyre;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public Cycle getDefaultCycle() {
        List<Component> components = new ArrayList<>();
        components.add(getDefaultWheels());
        components.add(getDefaultFrame());
        components.add(getDefaultSeating());
        components.add(getDefaultChainAssembly());
        components.add(getDefaultHandleAndBrakes());
        Cycle cycle = new Cycle(components);
        return cycle;
    }

    public Wheels getDefaultWheels() {
        List<Part> wheelParts = new ArrayList<>();
        wheelParts.add(new Spoke("premium"));
        wheelParts.add(new Rim("premium"));
        wheelParts.add(new Tube("premium"));
        wheelParts.add(new Tyre("premium"));
        Wheels wheels = new Wheels(wheelParts, wheelParts);
        return wheels;
    }

    public Wheels getTubelessWheels() {
        List<Part> wheelParts = new ArrayList<>();
        wheelParts.add(new Spoke("premium"));
        wheelParts.add(new Rim("premium"));
        wheelParts.add(new Tube("none"));
        wheelParts.add(new Tyre("tubeless"));
        Wheels wheels = new Wheels(wheelParts, wheelParts);
        return wheels;
    }

    public Frame getDefaultFrame() {
        List<Part> frameParts = new ArrayList<>();
        frameParts.add(new Paint("water_resistant"));
        frameParts.add(new FrameMaterial(("normal")));
        Frame frame = new Frame(frameParts);
        return frame;
    }

    public Frame getSteelFrame() {
        List<Part> frameParts = new ArrayList<>();
        frameParts.add(new Paint("water_resistant"));
        frameParts.add(new FrameMaterial(("steel")));
        Frame frame = new Frame(frameParts);
        return frame;
    }

    public Seating getDefaultSeating() {
        List<Part> seatParts = new ArrayList<>();
        seatParts.add(new SeatCover("hard"));
        seatParts.add(new SeatMaterial(("foam")));
        Seating seating = new Seating(seatParts);
        return seating;
    }

    public Seating getSoftSeating() {
        List<Part> seatParts = new ArrayList<>();
        seatParts.add(new SeatCover("soft"));
        seatParts.add(new SeatMaterial(("foam")));
        Seating seating = new Seating(seatParts);
        return seating;
    }

    public ChainAssembly testChainAssemblyWith4Gears(int numberOfGears) {
        List<Part> chainAssemblyParts = new ArrayList<>();
        chainAssemblyParts.add(new ChainRing("normal"));
        chainAssemblyParts.add(new Gear(4));
        ChainAssembly chainAssembly = new ChainAssembly(chainAssemblyParts);
        return chainAssembly;
    }

    public ChainAssembly getDefaultChainAssembly() {
        return testChainAssemblyWith4Gears(1);
    }

    public HandleBarWithBrake getDefaultHandleAndBrakes() {
        List<Part> handleParts = new ArrayList<>();
        handleParts.add(new Brake("normal"));
        handleParts.add(new CycleBell("normal"));
        handleParts.add(new HandleShape("TShape"));
        HandleBarWithBrake handleAndBrakes = new HandleBarWithBrake(handleParts);
        return handleAndBrakes;
    }

    public HandleBarWithBrake getHandleWithDiskBrakes() {
        List<Part> handleParts = new ArrayList<>();
        handleParts.add(new Brake("disk"));
        handleParts.add(new CycleBell("normal"));
        handleParts.add(new HandleShape("TShape"));
        HandleBarWithBrake handleAndBrakes = new HandleBarWithBrake(handleParts);
        return handleAndBrakes;
    }

}
