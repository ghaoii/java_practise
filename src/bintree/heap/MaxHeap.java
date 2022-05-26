package bintree.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxHeap {
    List<Integer> elementData;
    private int size;

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(int size) {
        elementData = new ArrayList<>(size);
    }

    public MaxHeap(int[] arr){
        elementData = new ArrayList<>();
        //现将原数组内的元素拷贝进elementData对象中
        for(int i : arr){
            elementData.add(i);
            size++;
        }
        //从非叶子结点开始，一次执行下沉操作
        for (int i = parent(size - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 往优先级队列中添加元素
     * @param val
     */
    public void add(int val){
        elementData.add(val);
        size++;
        siftUp(size - 1);
    }

    private void siftUp(int k) {
        while(k > 0 && elementData.get(k) > elementData.get(parent(k))){
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void swap(int k, int parent) {
        int childVal = elementData.get(k);
        int parentVal = elementData.get(parent);
        elementData.set(k, parentVal);
        elementData.set(parent, childVal);
    }

    public int extractMax() {
        if(isEmpty()){
            throw new NoSuchElementException("heap is empty! cannot extract!");
        }
        int maxVal = elementData.get(0);
        elementData.set(0, elementData.get(size - 1));
        elementData.remove(size - 1);
        size--;
        siftDown(0);
        return maxVal;
    }

    private void siftDown(int k) {
        while(leftChild(k) < size){
            int j = leftChild(k);
            if( j + 1 < size && elementData.get(j) < elementData.get(j + 1)){
                j++;
            }
            //此时的j一定指向子结点中的最大结点
            swap(k, j);
            k = j;
        }
    }

    private int parent(int k){
        return (k - 1) / 2;
    }

    private int leftChild(int k){
        return k * 2 + 1;
    }

    private int rightChild(int k){
        return k * 2 + 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString() {
        return elementData.toString();
    }
}
