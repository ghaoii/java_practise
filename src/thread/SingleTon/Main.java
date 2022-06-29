package thread.SingleTon;

public class Main {
    public static void main(String[] args) {
        HungerSingleTon h1 = HungerSingleTon.getHungerSingleTon();
        HungerSingleTon h2 = HungerSingleTon.getHungerSingleTon();
        HungerSingleTon h3 = HungerSingleTon.getHungerSingleTon();
        System.out.println(h1 == h2);
        System.out.println(h1 == h3);

        Thread t1 = new Thread(() -> {
            System.out.println(LazySingleTon.getLazySingleTon());
        });
        Thread t2 = new Thread(() -> {
            System.out.println(LazySingleTon.getLazySingleTon());
        });
        Thread t3 = new Thread(() -> {
            System.out.println(LazySingleTon.getLazySingleTon());
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
