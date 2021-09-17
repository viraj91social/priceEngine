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
        assertEquals(450.0, priceUtil.getPartsPrice(chainAssembly.getParts(), date));
    }

    @Test
    void testChainAssemblyWith4Gears() {
        ChainAssembly chainAssembly = testUtils.getChainAssemblyWith4Gears();
        assertEquals(600.0, priceUtil.getPartsPrice(chainAssembly.getParts(), date));
    }

    @AfterEach
    void tearDown() {
    }
}