package com.priceEngine.model;

import com.priceEngine.service.TestUtils;
import com.priceEngine.service.PriceUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CycleTest {

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
    void testCyclePrice() {
        Cycle cycle = testUtils.getDefaultCycle();
        assertEquals(3470.0, priceUtil.getComponentsPrice(cycle.getComponents(), date));
    }

    @AfterEach
    void tearDown() {
    }
}