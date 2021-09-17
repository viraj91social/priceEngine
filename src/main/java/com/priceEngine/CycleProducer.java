package com.priceEngine;

import com.priceEngine.model.Cycle;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CycleProducer implements Runnable {

    private BlockingQueue<Cycle> cycleBlockingQueuequeue;
    private final int NO_OF_CYCLES;
    private List<Cycle> cycles;

    CycleProducer(BlockingQueue<Cycle> queue, int noOfProducers, List<Cycle> cycles) {
        this.cycleBlockingQueuequeue = queue;
        this.NO_OF_CYCLES = noOfProducers;
        this.cycles = cycles;
    }

    public void run() {
        try {
            for(Cycle cycle : cycles) {
                cycleBlockingQueuequeue.put(cycle);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
