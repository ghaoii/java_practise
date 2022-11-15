package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Off41_MedianFinder {
    // 保存中位数左侧数据的最大堆
    private Queue<Integer> leftHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    // 保存中位数右侧数据的最小堆
    private Queue<Integer> rightHeap = new PriorityQueue<>();

    public void addNum(int num) {
        // 如果两堆的元素数量为偶数，则插入到右侧最小堆中
        if(((leftHeap.size() + rightHeap.size()) & 1) == 0) {
            // 如果插入元素小于左侧最大堆的堆顶元素
            // 那么先插入到最大堆，然后再将最大堆的堆顶元素取出，插入到右侧最小堆中
            if(leftHeap.size() > 0 && num < leftHeap.peek()) {
                leftHeap.offer(num);
                num = leftHeap.poll();
            }
            rightHeap.offer(num);
        }else {// 两队元素数量之和为奇数，则插入到左侧最大堆中
            // 如果插入元素大于右侧最小堆的堆顶元素
            // 那么先插入到右侧最小堆中，然后取出最小堆的堆顶元素，插入到左侧最大堆中
            if(rightHeap.size() > 0 && num > rightHeap.peek()) {
                rightHeap.offer(num);
                num = rightHeap.poll();
            }
            leftHeap.offer(num);
        }
    }

    public double findMedian() {
        int size = leftHeap.size() + rightHeap.size();
        double ret = 0;
        if(size == 0) {
            return ret;
        }

        if((size & 1) == 1) {
            ret = rightHeap.peek();
        }else {
            ret = (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }

        return ret;
    }

    // 测试代码
    public static void main(String[] args) {
        Off41_MedianFinder test = new Off41_MedianFinder();

        System.out.println(test.findMedian());
        test.addNum(1);
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
    }
}
