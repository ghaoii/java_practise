package interview;

import java.util.*;

public class Num3_2_MinStack {

    private Deque<Integer> stack = new ArrayDeque<>();

    private Deque<Integer> minStack = new ArrayDeque<>();

    public Num3_2_MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        }else {
            int min = minStack.peek();
            if(x < min) {
                min = x;
            }
            minStack.push(min);
        }
    }

    public void pop() {
        stack.poll();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
