package test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        //test.add(null);
        for(Integer i : test){
            System.out.println("进入循环");
            System.out.println(i);
        }
    }
}
