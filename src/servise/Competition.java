package servise;

public interface Competition {
    void setDistance(int distance);
    void setNRunners(int nRunners);
    void setMinTimeSleep(int minTimeSleep);
    void setMaxTimeSleep(int maxTimeSleep);
    int getWinner();
}
