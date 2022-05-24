package queue.impl;

import queue.Queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LoopQueue implements Queue<Integer> {
    private Integer[] data;
    private int head;
    private int tail;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int size) {
        data = new Integer[size];
    }

    @Override
    public void offer(Integer val) {
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException("queue is full! cannot offer!");
        }
        if(isEmpty()){
            data[head] = val;
        }else{
            data[tail] = val;
        }
        tail = (tail + 1) % data.length;
    }

    @Override
    public Integer peek() {
        return data[head];
    }

    @Override
    public Integer poll() {
        Integer ret = data[head];
        head = (head + 1) % data.length;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull(){
        return (tail + 1) % data.length == head;
    }

    public String toString(){
        //int tmp = head;
        StringBuilder sb = new StringBuilder();
        int lastOps = tail == 0? data.length - 1 : tail - 1;
        sb.append("[");
        for(int tmp = head; tmp != tail; tmp = (tmp + 1) % data.length){
            sb.append(data[tmp]);
            if(tmp != lastOps){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
