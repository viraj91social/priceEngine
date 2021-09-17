package com.priceEngine.model.components;

import com.priceEngine.model.components.chain.ChainAssembly;
import com.priceEngine.service.PriceUtil;
import com.priceEngine.service.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ChainAssemblyTest {

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
    void testDefaultChainAssembly() {
        ChainAssembly chainAssembly = testUtils.getDefaultChainAssembly(1);
        try {
            assertEquals(450.0, priceUtil.getPartsPrice(chainAssembly.getParts(), date));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    void testChainAssemblyWith4Gears() {
        ChainAssembly chainAssembly = testUtils.getChainAssemblyWith4Gears();
        try {
            assertEquals(600, priceUtil.getPartsPrice(chainAssembly.getParts(), date));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @AfterEach
    void tearDown() {
    }
}