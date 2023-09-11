package telran.multithreading.games;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Runner extends Thread {
    private final Race race;
    private final int runnerId;
    private static final Instant startTime = Instant.now();

    public Runner(Race race, int runnerId) {
        this.race = race;
        this.runnerId = runnerId;
    }

    @Override
    public void run() {
        int sleepRange = race.maxSleep() - race.minSleep() + 1;
        int minSleep = race.minSleep();
        int distance = race.distance();
        for (int i = 0; i < distance; i++) {
            try {
                sleep((long) (minSleep + Math.random() * sleepRange));
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
            System.out.println(runnerId);
        }
        long timeRunning = ChronoUnit.MILLIS.between(startTime, Instant.now());
        race.getTable().put(runnerId, timeRunning);
    }

}