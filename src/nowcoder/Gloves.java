package nowcoder;

public class Gloves {
    public int findMinimum(int n, int[] left, int[] right) {
        int leftCount = 0;
        int rightCount = 0;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        int sum = 0;// 用于取出颜色为 0 的手套
        for (int i = 0; i < n; i++) {

            if(left[i] != 0 && right[i] != 0) {
                // 没有 0 的情况
                leftCount += left[i];
                rightCount += right[i];
                leftMin = Math.min(leftMin, left[i]);
                rightMin = Math.min(rightMin, right[i]);
            }else {
                sum += left[i] + right[i];
            }
        }
        return Math.min(leftCount - leftMin, rightCount - rightMin) + 2 + sum;
    }
}
