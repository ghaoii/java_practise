package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num3_1_TripleInOne {
    int[][] arr;

    int[] pos = new int[3];

    int maxSize;

    public Num3_1_TripleInOne(int stackSize) {
        arr = new int[3][stackSize];
        maxSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int index = pos[stackNum];
        if(index < maxSize) {
            arr[stackNum][index] = value;
            pos[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int index = pos[stackNum];
        int val = -1;
        if(index > 0) {
            val = arr[stackNum][index - 1];
            pos[stackNum]--;
        }
        return val;
    }

    public int peek(int stackNum) {
        int index = pos[stackNum];
        if(index > 0) {
            return arr[stackNum][index - 1];
        }else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {
        return pos[stackNum] == 0;
    }
}
