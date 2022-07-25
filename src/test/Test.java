package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class Test {
    public static void main(String[] args) {
        String str1 = "abc" + "def";
        String str2 = new String("abcdef");
        System.out.println(str1 == str2);
    }
}


