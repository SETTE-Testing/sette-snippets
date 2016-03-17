package hu.bme.mit.sette.snippets._8_multithreading.dependencies;

import hu.bme.mit.sette.common.annotations.SetteDependency;

@SetteDependency
public class Storage {
    private volatile int data;
    private volatile boolean hasData;

    public synchronized int get() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                // ignore
            }
        }

        hasData = false;
        notifyAll();
        return data;
    }

    public synchronized void put(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                // ignore
            }
        }

        data = value;
        hasData = true;
        notifyAll();
    }
}
