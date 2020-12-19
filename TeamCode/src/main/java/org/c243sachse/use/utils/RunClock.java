package org.c243sachse.use.utils;

import java.util.concurrent.TimeUnit;

public class RunClock {
    private long start;

    public RunClock() {
        start = System.nanoTime();
    }

    public long seconds() {
        long elapsed = System.nanoTime() - start;
        return TimeUnit.SECONDS.convert(elapsed, TimeUnit.NANOSECONDS);
    }

    public long milliSeconds() {
        long elapsed = System.nanoTime() - start;
        return TimeUnit.MILLISECONDS.convert(elapsed, TimeUnit.NANOSECONDS);
    }
}
