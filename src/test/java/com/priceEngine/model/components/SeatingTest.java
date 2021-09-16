package com.priceEngine.model.components;

import com.priceEngine.service.TestUtils;
import com.priceEngine.model.components.seat.Seating;
import com.priceEngine.service.PriceUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SeatingTest {

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
    void testSoftSeatingPrice() {
        Seating seating = testUtils.getSoftSeating();
        assertEquals(200, priceUtil.getPartsPrice(seating.getParts(), date));
    }

    @Test
    void testDefaultSeatingPrice() {
        Seating seating = testUtils.getDefaultSeating();
        assertEquals(180, priceUtil.getPartsPrice(seating.getParts(), date));
    }

    @AfterEach
    void tearDown() {
    }
}