package stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStack<E> {
    List<E> list = new ArrayList<>();

    int size;

    public void push(E val) {
        list.add(val);
        size++;
    }

    public E peek() {
        if(isEmpty()) {
           throw new NoSuchElementException("stack is empty! cannot peek!");
        }
        return list.get(size - 1);
    }

    public E pop() {
        if(isEmpty()) {
            throw new NoSuchElementException("stack is empty! cannot peek!");
        }
        E ret = list.remove(size - 1);
        size--;
        return ret;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
