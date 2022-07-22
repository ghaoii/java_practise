package leetcode;

public class Num42_Trap {
    // 双引用
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max_left = 0;
        int max_right = 0;
        int sum = 0;
        while(left <= right) {
            if(height[left] < height[right]) {
                if(height[left] >= max_left) {
                    max_left = height[left];
                }else {
                    sum += max_left - height[left];
                }
                left++;
            }else {
                if(height[right] >= max_right) {
                    max_right = height[right];
                }else {
                    sum += max_right - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    // 动归解法，实际上是按列求解的进阶版
//    public int trap(int[] height) {
//        int[] max_left = new int[height.length];
//        int[] max_right = new int[height.length];
//        // 计算每一列的左边最高柱
//        for (int i = 1; i < height.length - 1; i++) {
//            // 左边最高列和当前列比较取大值
//            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
//        }
//        // 计算每一类的右边最高柱
//        for (int i = height.length - 2; i > 0; i--) {
//            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
//        }
//        // 计算每一列的积水量
//        int count = 0;
//        // 第一二列不会积水，不需要判断
//        for (int i = 1; i < height.length - 1; i++) {
//            int temp = Math.min(max_left[i], max_right[i]);
//            if(height[i] < temp) {
//                count += temp - height[i];
//            }
//        }
//        return count;
//    }


    // 按列求解
//    public int trap(int[] height) {
//        if(height.length <= 2) {
//            // 如果只有两列，不可能积水
//            return 0;
//        }
//        int sum = 0;
//        // 第一列和最后一列都不需要判断，不可能积水
//        for (int i = 1; i < height.length - 1; i++) {
//            // 找当前列左边的最高列
//            int max_left = 0;
//            for (int j = 0; j < i; j++) {
//                if(height[j] > max_left) {
//                    max_left = height[j];
//                }
//            }
//            // 找到当前列右边的最高列
//            int max_right = 0;
//            for (int j = i + 1; j < height.length; j++) {
//                if(height[j] > max_right) {
//                    max_right = height[j];
//                }
//            }
//            int temp = Math.min(max_left, max_right);
//            // 如果当前柱子高度要大于等于较矮的柱子，不能积水
//            if (height[i] < temp) {
//                // 如果当前柱子的高度小于较矮的柱子，则可以积水
//                sum += temp - height[i];
//            }
//        }
//        return sum;
//    }
}
