package com.priceEngine.model.components;

import com.priceEngine.model.components.wheel.Wheels;
import com.priceEngine.service.PriceUtil;
import com.priceEngine.service.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WheelsTest {

    private static LocalDate date;
    private static PriceUtil priceUtil;
    private static Utils testUtils;

    @BeforeAll
    static void setUp() {
        date = LocalDate.now();
        priceUtil = new PriceUtil();
        testUtils = new Utils();
    }

    @Test
    void testWheelPrice() {
        Wheels wheels = testUtils.getDefaultWheels();
        assertEquals(960.0, priceUtil.getPartsPrice(wheels.getParts(), date));
    }

    @Test
    void testTubeLessTyreWheelPrice() {
        Wheels wheels = testUtils.getTubelessWheels();
        assertEquals(900.0, priceUtil.getPartsPrice(wheels.getParts(), date));
    }

    @AfterEach
    void tearDown() {
    }
}