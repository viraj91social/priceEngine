package com.priceEngine;

import com.priceEngine.model.Cycle;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CycleMain {

    private static int CAPACITY = 100;
    private static int NO_OF_THREADS = 10;
    private static int NO_OF_CYCLES = 1000;

    public static void main(String args[]) {

        BlockingQueue<Cycle> queue = new LinkedBlockingQueue<>(CAPACITY);

        new Thread(new CycleProducer(queue, NO_OF_CYCLES)).start();

        for(int i = 0; i < NO_OF_THREADS; i++) {
            new Thread(new CycleConsumer(queue, NO_OF_CYCLES)).start();
        }
    }
}
