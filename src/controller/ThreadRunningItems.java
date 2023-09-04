package controller;

import servise.Competition;
import view.InputOutput;
import view.Item;

public class ThreadRunningItems {

    private final static int MIN_TIME_SlEEP = 2;
    private final static int MAX_TIME_SlEEP = 5;

    static Competition competition;

    public static Item[] getItems(Competition competition) {
        ThreadRunningItems.competition = competition;
        ThreadRunningItems.competition.setMinTimeSleep(MIN_TIME_SlEEP);
        ThreadRunningItems.competition.setMaxTimeSleep(MAX_TIME_SlEEP);

        return new Item[]{Item.of("Start running", ThreadRunningItems::startCompetition),
                Item.ofExit()
        };
    }

    private static void startCompetition(InputOutput io) {
        int nRunners = io.readInt("Please enter numbers of runners", "wrong number", 3, 10);
        int distance = io.readInt("Please choose the distance", "Wrong number", 100, 3500);
        competition.setDistance(distance);
        competition.setNRunners(nRunners);

        io.writeLine(String.format("Congratulations to thread #%d (WINNER)) ", competition.getWinner()));
    }

}
