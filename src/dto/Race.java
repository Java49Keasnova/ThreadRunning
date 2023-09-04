package dto;

public class Race {

    private final int minSleep;
    private final int maxSleep;
    private final int distance;
    public int winner = -1;

    public Race(int minSleep, int maxSleep, int distance) {
        this.minSleep = minSleep;
        this.maxSleep = maxSleep;
        this.distance = distance;
    }

    public int getMinSleep() {
        return minSleep;
    }

    public int getMaxSleep() {
        return maxSleep;
    }

    public int getDistance() {
        return distance;
    }
}
