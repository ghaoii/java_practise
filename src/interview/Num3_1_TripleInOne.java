package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num3_1_TripleInOne {
    List<Integer> arr;

    int maxSize;

    public Num3_1_TripleInOne(int stackSize) {
        arr = new ArrayList<>(stackSize);
        maxSize = stackSize;
    }

    public void push(int stackNum, int value) {
        if(stackNum < 0 || stackNum >= maxSize || arr.size() >= maxSize) {
            return;
        }
        arr.add(stackNum, value);
    }

    public int pop(int stackNum) {
        if(stackNum < 0 || stackNum >= maxSize || arr.size() == 0) {
            return -1;
        }
        return arr.remove(stackNum);
    }

    public int peek(int stackNum) {
        if(stackNum < 0 || stackNum >= maxSize || arr.size() == 0) {
            return -1;
        }
        return arr.get(stackNum);
    }

    public boolean isEmpty(int stackNum) {
        return arr.size() == 0;
    }
}
