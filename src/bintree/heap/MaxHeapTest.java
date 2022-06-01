package bintree.heap;

public class MaxHeapTest {
    public static void main(String[] args) {
        int[] arr = {23, 15, 25, 8, 18};
        MaxHeap heap = new MaxHeap(arr);

        System.out.println(heap);
    }
}
