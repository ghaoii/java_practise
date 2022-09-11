package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Num752_OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String str : deadends) {
            set.add(str);
        }
        if(set.contains("0000")) {
            return -1;
        }
        Set<String> hasTried = new HashSet<>();
        hasTried.add("0000");
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("0000");

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if(target.equals(str)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    String newStr1 = plusOne(str, j);
                    if(!set.contains(newStr1) && !hasTried.contains(newStr1)) {
                        queue.offer(newStr1);
                        hasTried.add(newStr1);
                    }
                    String newStr2 = minusOne(str, j);
                    if(!set.contains(newStr2) && !hasTried.contains(newStr2)) {
                        queue.offer(newStr2);
                        hasTried.add(newStr2);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private String plusOne(String str, int index) {
        char[] ch = str.toCharArray();
        if(ch[index] == '9') {
            ch[index] = '0';
        }else {
            ch[index]++;
        }
        return new String(ch);
    }

    private String minusOne(String str, int index) {
        char[] ch = str.toCharArray();
        if(ch[index] == '0') {
            ch[index] = '9';
        }else {
            ch[index]--;
        }
        return new String(ch);
    }
}
