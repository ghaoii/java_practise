package bintree.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxHeap {
    List<Integer> elementData;

    int size;

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(int size) {
        elementData = new ArrayList<>(size);
    }

    public MaxHeap(int[] arr) {
        elementData = new ArrayList<>();
        for(int i : arr) {
            elementData.add(i);
            size++;
        }
        if(size > 1) {
            heapify();
        }
    }

    public void offer(int value) {
        elementData.add(value);
        siftUp(size);
        size++;
    }

    private void siftUp(int k) {
        int parent = (k - 1) / 2;
        while(parent >= 0 && elementData.get(parent) < elementData.get(k)) {
            swap(parent, k);
            k = parent;
        }
    }

    public int peek() {
        return elementData.get(0);
    }

    public int poll() {
        int ret = peek();
        elementData.set(0, elementData.get(size - 1));
        elementData.remove(size - 1);
        size--;
        siftDown(0);
        return  ret;
    }

    public void heapify() {
        int k = (size - 2) / 2;
        while(k >= 0) {
            siftDown(k);
            k--;
        }
    }

    private void siftDown(int k) {
        while(k * 2 + 1 < size) {
            int child = k * 2 + 1;
            if(child + 1 < size && elementData.get(child) < elementData.get(child + 1)) {
                child++;
            }
            if(elementData.get(k) < elementData.get(child)) {
                swap(k, child);
            }else {
                break;
            }
            k = child;
        }
    }

    private void swap(int i, int j) {
        int temp = elementData.get(i);
        elementData.set(i, elementData.get(j));
        elementData.set(j, temp);
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


//public class MaxHeap {
//    List<Integer> elementData;
//    int size;
//
//    public MaxHeap() {
//        this(10);
//    }
//
//    public MaxHeap(int size) {
//        elementData = new ArrayList<>(size);
//    }
//
//    /**
//     * 将任意数组堆化
//     * @param arr
//     */
//    public MaxHeap(int[] arr){
//        if(arr == null){
//            throw new NoSuchElementException("arr is empty! cannot heapify!");
//        }
//        elementData = new ArrayList<>();
//        for(int i : arr){
//            elementData.add(i);
//            size++;
//        }
//        for (int i = parent(size - 1); i >= 0; i--) {
//            siftDown(i);
//        }
//    }
//
//    /**
//     * 向优先级队列中添加元素
//     * @param val
//     */
//    public void add(int val){
//        elementData.add(val);
//        siftUp(size);
//        size++;
//    }
//
//    //上浮操作
//    private void siftUp(int k) {
//        if(k < 0 || k >= size){
//            return;
//        }
//        int parent = parent(k);
//        while(k > 0 && elementData.get(k) > elementData.get(parent)) {
//            swap(k, parent);
//        }
//    }
//
//    private void swap(int i, int j) {
//        int a = elementData.get(i);
//        int b = elementData.get(j);
//        elementData.set(i, b);
//        elementData.set(j, a);
//    }
//
//    /**
//     * 捕获最大值
//     * @return
//     */
//    public int extractMax(){
//        if(size == 0){
//            throw new NoSuchElementException("heap is empty! cannot extract!");
//        }
//        int ret = elementData.get(0);
//        swap(0, size - 1);
//        elementData.remove(size - 1);
//        size--;
//        siftDown(0);
//        return ret;
//    }
//
//    //下沉操作
//    private void siftDown(int k) {
//        if(k < 0 || k >= size){
//            return;
//        }
//        //存在左子树的时候进入循环
//        while(leftChild(k) < size){
//            int j = leftChild(k);
//            //查看右子树
//            if(j + 1 < size && elementData.get(j + 1) > elementData.get(j)){
//                //如果存在右子树，且右子树根结点大于左子树根结点，则让j指向右子树
//                j++;
//            }
//            if(elementData.get(k) >= elementData.get(j)){
//                break;
//            }
//            swap(k, j);
//            k = j;
//        }
//    }
//
//    //父结点的索引
//    private int parent(int k){
//        return (k - 1) / 2;
//    }
//
//    //左子树的根结点
//    private int leftChild(int k){
//        return k * 2 + 1;
//    }
//
//    //右子树的根结点
//    private int rightChild(int k){
//        return k * 2 + 2;
//    }
//
//    public String toString() {
//        return elementData.toString();
//    }
//}
