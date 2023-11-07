package com.example.demo.util;

import java.time.Duration;
import java.time.Instant;

public final class Stopwatch {

    Instant start;

    private Stopwatch() {
        start = Instant.now();
    }

    public static Stopwatch start() {
        return new Stopwatch();
    }

    /**
     * @return the elapsed time (in milliseconds)
     */
    public long lap() {
        return Duration.between(start, Instant.now()).toMillis();
    }

    /**
     * @return the elapsed time (in minutes)
     */
    public long lapMinutes() {
        return Duration.between(start, Instant.now()).toMinutes();
    }

    /**
     * TODO: consider change format to HH:mm:ss.SSS
     *
     * @return the elapsed time (in milliseconds) as a string
     */
    public String lapStr() {
        return lap() + "ms";
    }

    public void reset() {
        start = Instant.now();
    }
}
