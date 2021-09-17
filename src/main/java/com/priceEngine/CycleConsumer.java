package com.priceEngine;

import com.priceEngine.model.Cycle;
import com.priceEngine.service.PartPriceNotFoundException;
import com.priceEngine.service.PriceUtil;

import java.time.LocalDate;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CycleConsumer implements Runnable {

    BlockingQueue<Cycle> cycleBlockingQueue;
    private static final PriceUtil priceUtil = new PriceUtil();
    private LocalDate date = LocalDate.now();
    private final int NO_OF_CYCLES;
    private static int count = 0;

    public CycleConsumer(BlockingQueue<Cycle> queue, int numberOfCycles) {
        this.cycleBlockingQueue = queue;
        this.NO_OF_CYCLES = numberOfCycles;
    }

    public void run() {
        try{
            while(true) {
                Cycle cycle = cycleBlockingQueue.poll(1, TimeUnit.SECONDS);
                if(this.count >= NO_OF_CYCLES)
                    return;
                double price = 0;
                try {
                    price = priceUtil.getComponentsPrice(cycle.getComponents(), date);
                } catch (PartPriceNotFoundException e) {
                    Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
                }
                System.out.println(Thread.currentThread().getName() + " Cycle Price: " + price);
                this.count++;
            }
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
