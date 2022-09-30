package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Num752_OpenLock {
    // 双向bfs
    public int openLock(String[] deadends, String target) {
        // 该集合中除了保存死亡锁之外，还用来保存已经遍历过的情况，这样就不需要再来一个集合了
        Set<String> deadSet = new HashSet<>();
        for(String s : deadends) {
            deadSet.add(s);
        }

        if(deadSet.contains("0000")) {
            return -1;
        }

        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();

        s1.add("0000");
        s2.add(target);
        int step = 0;

        while(!s1.isEmpty() && !s2.isEmpty()) {
            // 通过更少量的元素扩散来提升效率
            if(s1.size() > s2.size()) {
                Set<String> temp = s1;
                s1 = s2;
                s2 = temp;
            }
            // 用来临时保存当前s1的下一次扩散情况
            Set<String> temp = new HashSet<>();
            for(String s : s1) {
                // 如果该锁是死亡锁，那么直接判断下一个
                if(deadSet.contains(s)) {
                    continue;
                }
                // 如果和s2产生交集了，那么说明已经找到了最小旋转次数
                if(s2.contains(s)) {
                    return step;
                }
                // 如果不是以上两种情况，那么继续扩散
                for (int i = 0; i < 4; i++) {
                    String str = up(s, i);
                    if(!deadSet.contains(str)) {
                        temp.add(str);
                    }
                    str = down(s, i);
                    if(!deadSet.contains(str)) {
                        temp.add(str);
                    }
                }
                deadSet.add(s);
            }

            step++;
            s1 = s2;
            s2 = temp;
        }
        return -1;
    }


    private String up(String str, int pos) {
        char[] ch = str.toCharArray();
        if(ch[pos] == '9') {
            ch[pos] = 0;
        }else {
            ch[pos]++;
        }
        return new String(ch);
    }

    private String down(String str, int pos) {
        char[] ch = str.toCharArray();
        if(ch[pos] == '0') {
            ch[pos] = '9';
        }else {
            ch[pos]--;
        }
        return new String(ch);
    }
}

//public class Num752_OpenLock {
//    public int openLock(String[] deadends, String target) {
//        Set<String> set = new HashSet<>();
//        for(String str : deadends) {
//            set.add(str);
//        }
//        if(set.contains("0000")) {
//            return -1;
//        }
//        Set<String> hasTried = new HashSet<>();
//        hasTried.add("0000");
//        Deque<String> queue = new ArrayDeque<>();
//        queue.offer("0000");
//
//        int count = 0;
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String str = queue.poll();
//                if(target.equals(str)) {
//                    return count;
//                }
//                for (int j = 0; j < 4; j++) {
//                    String newStr1 = plusOne(str, j);
//                    if(!set.contains(newStr1) && !hasTried.contains(newStr1)) {
//                        queue.offer(newStr1);
//                        hasTried.add(newStr1);
//                    }
//                    String newStr2 = minusOne(str, j);
//                    if(!set.contains(newStr2) && !hasTried.contains(newStr2)) {
//                        queue.offer(newStr2);
//                        hasTried.add(newStr2);
//                    }
//                }
//            }
//            count++;
//        }
//        return -1;
//    }
//
//    private String plusOne(String str, int index) {
//        char[] ch = str.toCharArray();
//        if(ch[index] == '9') {
//            ch[index] = '0';
//        }else {
//            ch[index]++;
//        }
//        return new String(ch);
//    }
//
//    private String minusOne(String str, int index) {
//        char[] ch = str.toCharArray();
//        if(ch[index] == '0') {
//            ch[index] = '9';
//        }else {
//            ch[index]--;
//        }
//        return new String(ch);
//    }
//}
