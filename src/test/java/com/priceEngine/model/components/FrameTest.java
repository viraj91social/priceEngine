package com.priceEngine.model.components;

import com.priceEngine.model.components.frame.Frame;
import com.priceEngine.service.PriceUtil;
import com.priceEngine.service.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

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
    void testSteelFramePrice() {
        Frame frame = testUtils.getSteelFrame();
        assertEquals(900, priceUtil.getPartsPrice(frame.getParts(), date));
    }

    @Test
    void testNormalFramePrice() {
        Frame frame = testUtils.getDefaultFrame();
        assertEquals(800, priceUtil.getPartsPrice(frame.getParts(), date));
    }

    @AfterEach
    void tearDown() {
    }
}