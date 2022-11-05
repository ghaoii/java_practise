package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



public class Test {
    public static void main(String[] args) {
        Integer i1 = 20;
        int i2 = 20;
        Integer i3 = Integer.valueOf(20);
        Integer i4 = new Integer(20);
        System.out.println(i2 == i4);
        System.out.println(i2 == i3);
    }


}

