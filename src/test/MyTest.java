package test;

import java.util.*;

public class MyTest {

//    public static void findDup(List<Integer> list1, List<Integer> list2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i : list1) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for(int i : list2) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        List<Integer> list = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() > 1) {
//                list.add(entry.getKey());
//            }
//        }
//        // 最大堆
//        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
//        for (int i = 0; i < list.size(); i++) {
//            int num = list.get(i);
//            if(i < 5) {
//                queue.offer(num);
//            }else {
//                if(num < queue.peek()) {
//                    queue.poll();
//                    queue.offer(num);
//                }
//            }
//        }
//        int[] arr = new int[queue.size()];
//        for (int i = arr.length - 1; i >= 0; i--) {
//            arr[i] = queue.poll();
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//
//    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        list1.add(5);
//        list1.add(6);
//        list1.add(7);
//        list1.add(8);
//        list1.add(9);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(4);
//        list2.add(6);
//        list2.add(7);
//        list2.add(8);
//        list2.add(9);
//        findDup(list1, list2);
//    }

//    public static void main(String[] args) {
//        String str = "AAB CCD EDC";
//        String[] strings = str.split(" ");
//        StringBuilder stringBuilder = new StringBuilder();
//        int len = strings.length;
//        for (int i = 0; i < len; i++) {
//            char[] ch = strings[i].toCharArray();
//            reverse(ch);
//            stringBuilder.append(ch);
//            if(i != len - 1) {
//                stringBuilder.append(" ");
//            }
//        }
//        System.out.println(stringBuilder);
//    }
//
//    private static void reverse(char[] ch) {
//        int left = 0;
//        int right = ch.length - 1;
//        while(left < right) {
//            char c = ch[left];
//            ch[left] = ch[right];
//            ch[right] = c;
//            left++;
//            right--;
//        }
//    }
}
