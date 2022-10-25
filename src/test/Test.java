package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



public class Test {
    public static void main(String[] args) {
        final byte a = 1;
        System.out.println(a);
        Test test = new Test();
        test.show("hello");
    }

    public static void test() {
        System.out.println("静态方法");
    }

    public void show(final String str) {
        System.out.println(str);
        System.out.println("准备调用静态方法……");
        Test test = new Test();
        test.test();
    }

}

