package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Off9_CQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;

    public Off9_CQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(value);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int deleteHead() {
        return s1.isEmpty() ? -1 : s1.pop();
    }
}
