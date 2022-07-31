package queue.impl;

import queue.Queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LoopQueue implements Queue<Integer> {
    private Integer[] data;

    private int head;

    private int tail;

    int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int size) {
        data = new Integer[size + 1];
    }

    @Override
    public void offer(Integer val) {
        if((tail + 1) % data.length == head) {
            throw new ArrayIndexOutOfBoundsException("queue is full! cannot offer!");
        }
        data[tail] = val;
        tail = (tail + 1) % data.length;
    }

    @Override
    public Integer peek() {
        return data[head];
    }

    @Override
    public Integer poll() {
        int ret = data[head];
        head = (head + 1) % data.length;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head [ ");
        int lastIndex = tail == 0 ? data.length - 1 : tail - 1;
        for(int i = head; i != tail; ) {
            sb.append(data[i]);
            if(i != lastIndex) {
                sb.append(", ");
            }
            i = (i + 1) % data.length;
        }
        sb.append(" ] tail");
        return sb.toString();
    }
}
