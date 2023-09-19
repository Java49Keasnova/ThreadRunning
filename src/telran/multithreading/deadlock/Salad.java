package telran.multithreading.deadlock;

public class Salad extends Thread {

    public String chiefsName;
    public static Object vegetable = new Object();
    public static Object knife = new Object();


    public Salad(String chiefsName) {
        this.chiefsName = chiefsName;
    }


    public void cuttingTomato() {
        synchronized (vegetable) {
            System.out.println(chiefsName + " takes tomato");
            synchronized (knife) {
                System.out.println(chiefsName + " takes knife to cut tomato");
            }
        }
    }

    public void cuttingCucumber() {
        synchronized (knife) {
            System.out.println(chiefsName + " takes knife to cut cucumber");
            synchronized (vegetable) {
                System.out.println(chiefsName + " takes cucumber");
            }
        }
        }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cuttingTomato();
            cuttingCucumber();
        }
    }
}
