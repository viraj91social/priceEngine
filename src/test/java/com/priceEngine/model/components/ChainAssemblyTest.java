package com.priceEngine.model.components;

import com.priceEngine.service.TestUtils;
import com.priceEngine.model.components.chain.ChainAssembly;
import com.priceEngine.service.PriceUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ChainAssemblyTest {

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
    void testDefaultChainAssembly() {
        ChainAssembly chainAssembly = testUtils.getDefaultChainAssembly();
        assertEquals(600.0, priceUtil.getPartsPrice(chainAssembly.getParts(), date));
    }

    @Test
    void testChainAssemblyWith4Gears() {
        ChainAssembly chainAssembly = testUtils.testChainAssemblyWith4Gears(4);
        assertEquals(600.0, priceUtil.getPartsPrice(chainAssembly.getParts(), date));
    }

    @AfterEach
    void tearDown() {
    }
}