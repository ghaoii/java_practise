package ioc;

public class NewCarTest {
    public static void main(String[] args) {
        // 具体的业务代码(需求方)
        Car car = new Car();
        // 把车运行起来
        car.run(15);
    }

    /**
     * 车
     */
    static class Car {
        public void run(int size) {
            // 依赖于车身
            Framework framework = new Framework();
            framework.init(size);
        }
    }

    /**
     * 车身
     */
    static class Framework {
        public void init(int size) {
            // 依赖于底盘
            Bottom bottom = new Bottom();
            bottom.init(size);
        }
    }

    /**
     * 底盘
     */
    static class Bottom {
        public void init(int size) {
            // 依赖于轮子
            Tire tire = new Tire();
            tire.init(size);
        }
    }

    /**
     * 轮胎 - 最底层
     */
    static class Tire {
        // 轮胎尺寸
//        private int size;
        public void init(int size) {
            System.out.println("轮胎尺寸为: " + size);
        }
    }
}
