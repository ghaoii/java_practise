package ioc;

public class IoCCarTest {
    public static void main(String[] args) {
        Tire tire = new Tire(20, "Blue");
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.run();
    }

    /**
     * 车
     */
    static class Car {
        private Framework framework;

        public Car(Framework framework) {
            this.framework = framework;
        }

        public void run() {
            // 依赖于车身
            framework.init();
        }
    }

    /**
     * 车身
     */
    static class Framework {
        private Bottom bottom;

        public Framework(Bottom bottom) {
            // 依赖注入/依赖注册
            this.bottom = bottom;
        }

        public void init() {
            // 依赖于底盘
            bottom.init();
        }
    }

    /**
     * 底盘
     */
    static class Bottom {
        // 接收注入的轮胎对象
        private Tire tire;

        public Bottom(Tire tire) {
            // 注入下层依赖对象(轮胎)
            this.tire = tire;
        }

        public void init() {
            // 初始化轮胎
            tire.init();
        }
    }

    /**
     * 轮胎
     */
    static class Tire {
        // 轮胎尺寸
        private int size;
        // 轮胎的颜色
        private String color;

        public Tire(int size, String color) {
            this.size = size;
            this.color = color;
        }

        public void init() {
            System.out.println("轮胎尺寸为: " + size);
            System.out.println("轮胎的颜色: " + color);
        }
    }
}
