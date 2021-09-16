package com.priceEngine.model.components;

import com.priceEngine.service.TestUtils;
import com.priceEngine.model.components.handle.HandleBarWithBrake;
import com.priceEngine.service.PriceUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HandleBarWithBrakeTest {

    private static LocalDate date;
    private static PriceUtil priceUtil;
    private static TestUtils testUtils;

    @BeforeAll
    static void setUp() {
        date = LocalDate.now();
        priceUtil = new PriceUtil();
        testUtils = new TestUtils();
    }

    @Test
    void testHandleBarAndBrakesPrice() {
        HandleBarWithBrake handleBarWithBrake = testUtils.getDefaultHandleAndBrakes();
        assertEquals(930, priceUtil.getPartsPrice(handleBarWithBrake.getParts(), date));
    }

    @Test
    void testHandleBarWithDiskBrakesPrice() {
        HandleBarWithBrake handleBarWithBrake = testUtils.getHandleWithDiskBrakes();
        assertEquals(980, priceUtil.getPartsPrice(handleBarWithBrake.getParts(), date));
    }

}