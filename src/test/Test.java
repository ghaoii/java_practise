package test;

import java.util.Random;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
//    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("猜数字游戏开始！");
        Random random = new Random();
        int key = random.nextInt(100) + 1;
        while(true) {
            System.out.print("请猜一个数字：");
            if(!scanner.hasNextInt()) {
                System.out.println("输入不合法，请重新输入！");
                scanner.nextLine();
                continue;
            }
            int num = scanner.nextInt();
            if(key == num) {
                System.out.println("恭喜你，猜对了！");
                System.out.println("是否要重新开始猜数字游戏？");
                if(!restartGame()) {
                    break;
                }
                key = random.nextInt(100) + 1;
            }else if(key > num) {
                System.out.println("猜小了");
            }else {
                System.out.println("猜大了");
            }
        }
        System.out.println("游戏结束！");
    }

    private static boolean restartGame() {
        scanner.nextLine();
        while(true) {
            String str = scanner.nextLine();
            if ("yes".equals(str)) {
                return true;
            } else if ("no".equals(str)) {
                return false;
            }
            System.out.print("输入错误，请重新输入:");
        }
    }
}

