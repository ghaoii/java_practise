package leetcode;

public class Num11_MaxArea {
    // 双指针
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }


    // 剪枝
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            // 每一次都从两端开始往中间找，找到一个高于自己的就停止
//            int left = 0;
//            while(left < i && height[left] < height[i]) {
//                left++;
//            }
//            int right = height.length - 1;
//            while(right > i && height[right] < height[i]) {
//                right--;
//            }
//            int instance = Math.max(right - i, i - left);
//            if(instance != 0) {
//                max = Math.max(max, height[i] * instance);
//            }
//        }
//        return max;
//    }
}
