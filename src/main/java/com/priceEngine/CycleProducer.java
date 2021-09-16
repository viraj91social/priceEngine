package com.priceEngine;

import com.priceEngine.model.Cycle;
import com.priceEngine.service.Utils;

import java.util.concurrent.BlockingQueue;

public class CycleProducer implements Runnable {

    private BlockingQueue<Cycle> cycleBlockingQueuequeue;
    private static Utils utils = new Utils();
    private final int NO_OF_CYCLES;

    CycleProducer(BlockingQueue<Cycle> queue, int noOfProducers) {
        this.cycleBlockingQueuequeue = queue;
        this.NO_OF_CYCLES = noOfProducers;
    }

    public void run() {
        try {
            for(int i = 0; i < this.NO_OF_CYCLES; i++) {
                cycleBlockingQueuequeue.put(utils.getDefaultCycle());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
