package hu.bme.mit.sette.snippets._8_multithreading.dependencies;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import hu.bme.mit.sette.common.annotations.SetteDependency;

@SetteDependency
public final class ThreadUtils {
    private ThreadUtils() {
        throw new UnsupportedOperationException("Static class");
    }

    public static void startAll(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void joinAll(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                // ignore
            }
        }
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            // ignore
        }
    }

    public static void busyWait(long ms) {
        long start = System.currentTimeMillis();
        while (start + ms >= System.currentTimeMillis()) {
            // wait
        }
    }

    public static void await(Condition condition) {
        try {
            condition.await();
        } catch (InterruptedException ex) {
            // ignore
        }
    }

    public static boolean await(Condition condition, long time, TimeUnit unit) {
        try {
            return condition.await(time, unit);
        } catch (InterruptedException ex) {
            // ignore
            return false;
        }
    }
}
