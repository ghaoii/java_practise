package thread.SingleTon;

public class HungerSingleTon {
    // 类在加载的时候将对象创建好了
    private static HungerSingleTon hungerSingleTon = new HungerSingleTon();

    private HungerSingleTon() {}

    public static HungerSingleTon getHungerSingleTon() {
        return hungerSingleTon;
    }
}
