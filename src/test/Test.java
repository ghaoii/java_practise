package test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        byte a = 10;
//        byte b = 20;
//        byte c = a;
//        System.out.println(c);

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        while(b != 0){
            int tmp = a % b;
            if(tmp == 0){
                break;
            }
            a = b;
            b = tmp;
        }
        System.out.println(b);
    }
}
