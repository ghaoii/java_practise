package test;

import java.util.Scanner;

public class Test {
    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }

//    public static void main(String[] args) {
//        System.out.println(isAdmin("Admin"));// false
//        String s1 = "abcd";
//        String s2 = "ABCD";
//        String s3 = s2.toLowerCase();// 如果一直去看源码，这个方法的返回值是个new String
//        System.out.println(s2.toLowerCase() == s1);// false
//        System.out.println(s3 == s1);// false
//    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = s1.toLowerCase();
        System.out.println(s1 == s2);// true
    }

}