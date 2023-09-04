package servise;

import dto.Race;
import dto.Racer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CompetitionImpl implements Competition {

    private Race race;
    private int nRunners;
    private int distance;
    private  int minTimeSleep;
    private  int maxTimeSleep;




    @Override
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public void setNRunners(int nRunners) {
        this.nRunners = nRunners;
    }

    @Override
    public void setMinTimeSleep(int minTimeSleep) {
        this.minTimeSleep = minTimeSleep;
    }

    @Override
    public void setMaxTimeSleep(int maxTimeSleep) {
        this.maxTimeSleep = maxTimeSleep;
    }

    @Override
    public int getWinner() {
        startCompetition();
        return race.winner;
    }

    private void startCompetition() {
        if(distance <= 0 || nRunners <= 0 || minTimeSleep <= 0 || maxTimeSleep <= 0 ){
            throw new RuntimeException("The race is not ready");
        }
                race = new Race(minTimeSleep, maxTimeSleep, distance);
       List<Racer> runners = createRunners();
       startRunners(runners);
       joinRunners(runners);

    }
    private List<Racer> createRunners() {
        List<Racer> runners = new ArrayList<>();
        IntStream.rangeClosed(1, nRunners).forEach(i -> runners.add(new Racer(race, i)));
        return runners;
    }
    private void startRunners(List<Racer> runners) {
        runners.forEach(Thread::start);
    }
    private void joinRunners(List<Racer> runners) {
        runners.forEach(r -> {
            try {
                r.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }




}
