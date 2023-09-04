package dto;

import java.util.concurrent.ThreadLocalRandom;

public class Racer extends Thread {
    private final int idRacer;
    private final Race race;


    public Racer(Race race, int idRacer) {
        this.race = race;
        this.idRacer = idRacer;
    }

    private int getRandomNumb(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    public void run() {
        for (int i = 0; i < race.getDistance(); i++) {
            try {
                sleep(getRandomNumb(race.getMinSleep(), race.getMaxSleep()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(idRacer + " racer is running now");
        }
        if (race.winner == -1) {
            race.winner = idRacer;
        }

    }
}
