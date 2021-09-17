package com.priceEngine.model.components;

import com.priceEngine.model.components.seat.Seating;
import com.priceEngine.service.PriceUtil;
import com.priceEngine.service.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SeatingTest {

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
    void testSoftSeatingPrice() {
        Seating seating = testUtils.getSoftSeating();
        try {
            assertEquals(200, priceUtil.getPartsPrice(seating.getParts(), date));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    void testDefaultSeatingPrice() {
        Seating seating = testUtils.getDefaultSeating();
        try {
            assertEquals(180, priceUtil.getPartsPrice(seating.getParts(), date));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @AfterEach
    void tearDown() {
    }
}