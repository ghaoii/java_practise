package bintree.heap;

public class MaxHeapTest {
    public static void main(String[] args) {
        int[] arr = {18, 15, 22, 36, 29, 51};
        MaxHeap heap = new MaxHeap(arr);
        System.out.println(heap);
    }
}
