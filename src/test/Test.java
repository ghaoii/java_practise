package test;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    private static long sum(int n) {
        long sum = 0;
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
            sum += fac;
        }
        return sum;
    }

    private static int max(int a, int b) {
        return a >= b ? a : b;
    }

    private static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    private static int fib(int n) {
        if(n <= 0) {
            return 0;
        }

        int a = 0;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}

