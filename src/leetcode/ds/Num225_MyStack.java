package leetcode.ds;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Num225_MyStack {
    Queue<Integer> queue;

    public Num225_MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

//public class Num225_MyStack {
//    Queue<Integer> queue1;
//    Queue<Integer> queue2;
//
//    public Num225_MyStack() {
//        queue1 = new LinkedList<>();
//        queue2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        queue2.offer(x);
//        while(!queue1.isEmpty()) {
//            queue2.offer(queue1.poll());
//        }
//        Queue<Integer> temp = queue1;
//        queue1 = queue2;
//        queue2 = temp;
//    }
//
//    public int pop() {
//        return queue1.poll();
//    }
//
//    public int top() {
//        return queue1.peek();
//    }
//
//    public boolean empty() {
//        return queue1.isEmpty();
//    }
//}
