package thread.SingleTon;

public class LazySingleTon {
    private static volatile LazySingleTon lazySingleTon;

    private LazySingleTon() {}

    public static LazySingleTon getLazySingleTon() {
        if(lazySingleTon == null) {
            synchronized (LazySingleTon.class) {
                if (lazySingleTon == null) {
                    lazySingleTon = new LazySingleTon();
                }
            }
        }
        return lazySingleTon;
    }
}
