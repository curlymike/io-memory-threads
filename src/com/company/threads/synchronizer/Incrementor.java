package com.company.threads.synchronizer;

public class Incrementor extends Thread {
    Monitor monitor;

    public Incrementor(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            monitor.increment();
        }
    }
}

class Monitor {
    public int store;

    public synchronized int increment() {
        store += 1;
        return store;
    }
}