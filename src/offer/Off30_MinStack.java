package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Off30_MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public Off30_MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
