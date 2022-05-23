package queue.impl;

import queue.Queue;

import java.util.NoSuchElementException;

/**
 * 链表结点
 * @param <E>
 */
class Node<E> {
    E val;
    Node<E> next;

    public Node(E val) {
        this.val = val;
    }
}

/**
 * 基于链表实现的队列
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;



    @Override
    public void offer(E val) {
        if(isEmpty()){
            //如果链表为空，则直接插入
            head = tail = new Node<>(val);
            size++;
            return;
        }
        //此时链表不为空
        tail.next = new Node<>(val);
        tail = tail.next;
        size++;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException("queue is empty! cannot peek!");
        }
        return head.val;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            throw new NoSuchElementException("queue is empty! cannot poll!");
        }
        E ret = head.val;
        Node<E> node = head;
        head = head.next;
        node = node.next = null;
        size--;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node<E> node = head; node != null; node = node.next) {
            sb.append(node.val);
            if(node.next != null){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
