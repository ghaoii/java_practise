package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStack<E> {
    private List<E> data = new ArrayList<>();
    private int size;

    /**
     * 向栈顶压入元素
     * @param val
     */
    public void push(E val){
        data.add(val);
        size++;
    }

    /**
     * 弹出栈顶元素，返回被弹出的元素值
     * @return
     */
    public E pop(){
        if(isEmpty()){
            throw new NoSuchElementException("stack is empty! cannot pop!");
        }
        E ret = peek();
        data.remove(size - 1);
        size--;
        return ret;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public E peek(){
        if(isEmpty()){
            throw new NoSuchElementException("stack is empty! cannot pook!");
        }
        return data.get(size - 1);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i));
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
