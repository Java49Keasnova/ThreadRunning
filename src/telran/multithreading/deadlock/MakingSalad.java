package telran.multithreading.deadlock;


public class MakingSalad {
    public static void main(String[] args) {
        Salad ann = new Salad("Ann");
        Salad katy = new Salad("Katy");
        ann.start();
        katy.start();

    }
}
