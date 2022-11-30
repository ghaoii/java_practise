package offer;

public class Off66_ConstructArr {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        if(a.length == 0) {
            return res;
        }
        int[] left = new int[a.length];// 左乘积
        int[] right = new int[a.length];// 右乘积
        left[0] = 1;
        right[a.length - 1] = 1;
        // 分别计算左右乘积
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
            right[a.length - 1 - i] = right[a.length - i] * a[a.length - i];
        }
        // 遍历原数组求结果集
        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
