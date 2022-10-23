package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.show();
    }

    public static void test() {
        System.out.println("静态方法");
    }

    public void show() {
        System.out.println("准备调用静态方法……");
        Test test = new Test();
        test.test();
    }

}

