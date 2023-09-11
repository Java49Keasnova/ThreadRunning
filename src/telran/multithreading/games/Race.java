package telran.multithreading.games;

import java.util.*;

public record Race(int distance, int minSleep, int maxSleep) {
    private static Map<Integer, Long> tableRes = Collections.synchronizedMap(new LinkedHashMap<>());

    public  Map<Integer, Long> getTable() {
        return tableRes;
    }

}