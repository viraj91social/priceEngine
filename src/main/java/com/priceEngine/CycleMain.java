package com.priceEngine;

import com.priceEngine.model.Cycle;
import com.priceEngine.service.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CycleMain {

    private static int CAPACITY = 100;
    private static int NO_OF_THREADS = 10;
    private static int NO_OF_CYCLES = 100;
    private static Utils utils = new Utils();

    public static void main(String args[]) {

//        List<Cycle> cycles = ParseCyclesFromInput(args);

        List<Cycle> cycles = new ArrayList<>();

        for(int i = 0; i < NO_OF_CYCLES; i++) {
            cycles.add(utils.getDefaultCycle());
        }

        BlockingQueue<Cycle> queue = new LinkedBlockingQueue<>(CAPACITY);

        new Thread(new CycleProducer(queue, NO_OF_CYCLES, cycles)).start();

        for(int i = 0; i < NO_OF_THREADS; i++) {
            new Thread(new CycleConsumer(queue, NO_OF_CYCLES)).start();
        }
    }

    /**
     * Responsible for creating list of cycle object from input.
     * Will handle the logic to validate the cycle correctness and
     * throwing exceptions if any.
     * @param args
     * @return
     */
    private static List<Cycle> ParseCyclesFromInput(String[] args) {

        return new ArrayList<Cycle>();
    }
}

//