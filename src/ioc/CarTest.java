package ioc;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        // 把车运行起来
        car.run();
    }

    /**
     * 车
     */
    static class Car {
        public void run() {
            // 依赖于车身
            Framework framework = new Framework();
            framework.init();
        }
    }

    /**
     * 车身
     */
    static class Framework {
        public void init() {
            // 依赖于底盘
            Bottom bottom = new Bottom();
            bottom.init();
        }
    }

    /**
     * 底盘
     */
    static class Bottom {
        public void init() {
            // 依赖于轮子
            Tire tire = new Tire();
            tire.init();
        }
    }

    /**
     * 轮胎 - 最底层
     */
    static class Tire {
        // 轮胎尺寸
        private int size = 15;
        public void init() {
            System.out.println("轮胎尺寸为: " + size);
        }
    }
}
