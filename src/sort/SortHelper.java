package sort;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 测试七大排序的性能以及产生辅助的测试数组
 */
public class SortHelper {
    //生成一个随机数的一个类
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * 产生一个大小为n的随机整数数组，数组的取值范围是[l, r)
     * @param n 数组的元素个数
     * @param l 随机元素值的最小值
     * @param r 随机元素值的最大值
     * @return 返回生成后的数组
     */
    public static int[] generaRandomArray(int n, int l, int r){
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            //生成一个[l, r)的随机数
            data[i] = random.nextInt(l, r);
        }
        return data;
    }


    /**
     * 生成一个数组大小为n的近乎有序的数组
     * @param n 元素的个数
     * @param swapTimes 交换的次数，即近乎有序的程度
     * @return 返回近乎有序的数组
     */
    public static int[] generateSortedArray(int n, int swapTimes){
        //1.生成一个完全有序的数组
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        //2.在这个完全有序的数组上，交换某几个元素的位置，这样就做到近乎有序了
        for (int i = 0; i < swapTimes; i++) {
            //生成一个[0, n)之间的随机数
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            int tmp = data[a];
            data[a] = data[b];
            data[b] = tmp;
        }
        return data;
    }

    /**
     * 拷贝原数组
     * @param arr 原数组
     * @return 返回拷贝后的数组
     */
    public static int[] arrCopy(int[] arr){
        return Arrays.copyOf(arr, arr.length);
    }

    public static void testSort(int[] arr, String sortName){
        Class<SortTest> cls = SortTest.class;
        try {
            Method method = cls.getDeclaredMethod(sortName,int[].class);
            long start = System.nanoTime();
            method.invoke(null,arr);
            long end = System.nanoTime();
            if (isSorted(arr)) {
                System.out.println(sortName + "排序完成，共耗时:" + (end - start) / 1000000.0 + "ms");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查当前的arr数组是否是一个非降序数组，前一个元素 <= 后一个元素
     * @param arr
     * @return
     */
    private static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]){
                System.out.println("排序算法有误！");
                return false;
            }
        }
        return true;
    }

}
