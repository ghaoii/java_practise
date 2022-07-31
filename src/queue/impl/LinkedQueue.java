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
    Node<E> head;

    Node<E> tail;

    int size;

    @Override
    public void offer(E val) {
        if(tail == null) {
            tail = new Node<>(val);
            head = tail;
        }else {
            tail.next = new Node<>(val);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E peek() {
        return head.val;
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            throw new NoSuchElementException("queue is empty! cannot poll!");
        }
        Node<E> node = head;
        E ret = node.val;
        head = head.next;
        node = node.next = null;
        size--;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
