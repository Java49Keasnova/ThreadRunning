import controller.ThreadRunningItems;
import servise.Competition;
import servise.CompetitionImpl;
import view.ConsoleInputOutput;
import view.InputOutput;
import view.Menu;

public class RaceControllerApp {
    public static void main(String[] args) {

        InputOutput io = new ConsoleInputOutput();
        Competition competition = new CompetitionImpl();
        Menu menu = new Menu("Tread Running", ThreadRunningItems.getItems(competition));
        menu.perform(io);

    }
}
