package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStack<E> {
    List<E> data = new ArrayList<>();

    int size;

    /**
     * 向栈顶插入元素
     * @param val
     */
    public void push(E val){
        data.add(val);
        size++;
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public E pop(){
        if(isEmpty()){
            throw new NoSuchElementException("stack is empty! can not pop!");
        }
        E ret = data.remove(size - 1);
        size--;
        return ret;
    }

    /**
     * 查看当前栈顶元素
     * @return
     */
    public E peek(){
        if (isEmpty()){
            throw new NoSuchElementException("stack is empty! can not peek!");
        }
        return data.get(size - 1);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i));
            if(i < size - 1){
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }


    public boolean isEmpty(){
        return size == 0;
    }

}
