package offer;

import java.util.LinkedList;
import java.util.List;

public class Off62_LastRemaining {
    public int lastRemaining(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }

    // 模拟链表(超时)
//    public int lastRemaining(int n, int m) {
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(i);
//        }
//        int k = --m % n;
//        while(list.size() > 1) {
//            list.remove(k);
//            k = (k + m) % list.size();
//        }
//        return list.get(0);
//    }
}
