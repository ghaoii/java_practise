package arraylist;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
    private int[] data;

    private int size;

    public MyArray() {
        data = new int[10];
    }

    public MyArray(int init) {
        data = new int[init];
    }

    public boolean add(int val) {
        if(size > data.length) {
            return false;
        }
        data[size] = val;
        size++;
        if(size == data.length) {
            data = grow(data);
        }
        return true;
    }

    private int[] grow(int[] data) {
        return Arrays.copyOf(data, data.length * 2);
    }

    public void add(int index, int val) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is illegal! can not add!");
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = val;
        size++;
        if(size == data.length) {
            data = grow(data);
        }
    }

    public int get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is illegal! can not add!");
        }
        return data[index];
    }

    public boolean contains(int val) {
        return indexOf(val) != -1;
    }

    public int indexOf(int val) {
        for (int i = 0; i < size; i++) {
            if(data[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfLast(int val) {
        for(int i = size - 1; i >= 0; i++) {
            if(data[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public int set(int index, int val) {
        if(!indexInRound(index)) {
            throw new IndexOutOfBoundsException("index is illegal! can not set!");
        }
        int ret = get(index);
        data[index] = val;
        return ret;
    }

    private boolean indexInRound(int index) {
        return index >= 0 && index < size;
    }

    public int remove(int index) {
        if(!indexInRound(index)) {
            throw new IndexOutOfBoundsException("index is illegal! can not remove!");
        }
        int ret = data[index];
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    public void removeFirst(int val) {
        int index = indexOf(val);
        if(index != -1) {
            remove(index);
        }
    }

    public void removeAll(int val) {
        for(int i = 0; i < size; i++) {
            while(i < size && data[i] == val) {
                remove(i);
            }
        }
    }

    public String toString() {
        String ret = "[";
        for (int i = 0; i < size; i++) {
            ret += data[i];
            if(i != size - 1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
}
