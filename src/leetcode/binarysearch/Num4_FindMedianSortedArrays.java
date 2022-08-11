package leetcode.binarysearch;

public class Num4_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = 0;
        int right = len1;
        // 切割数组的位置的范围在[0,len1]之间任意位置
        // 在0处切，则说明数组全在右边；在len1处切，说明数组全在左边
        int mid1 = 0;
        int mid2 = 0;
        while(left <= right) {
            int i = left + (right - left) / 2;
            int j = (len1 + len2 + 1) / 2 - i;
            // 由于切割位置可能越界，因此取无穷大或者无穷小
            // 如果i == 0了，那么nums1数组前面没有元素，取无穷小
            // 因为nums2数组的j前面必有元素，否则左右两边元素就不平衡了，所以无穷小不影响取最大值
            int frontI = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int frontJ = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            // 与上同理，如果nums1右边没元素了，则取无穷大，因为nums2右边肯定有元素，所以无穷大影响取最小值
            int numI = i == len1 ? Integer.MAX_VALUE : nums1[i];
            int numJ = j == len2 ? Integer.MAX_VALUE : nums2[j];

            if(frontI <= numJ) {
                mid1 = Math.max(frontI, frontJ);
                mid2 = Math.min(numI, numJ);
                left = i + 1;
            }else {
                right = i - 1;
            }
        }
        return (len1 + len2) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        int mid = (len1 + len2) / 2;
//        if((len1 + len2) % 2 == 1) {
//            return helper(nums1, nums2, mid + 1);
//        }
//        return (helper(nums1, nums2, mid) + helper(nums1, nums2, mid + 1)) * 1.0 / 2;
//    }

    private int helper(int[] num1, int[] num2, int k) {
        int len1 = num1.length;
        int len2 = num2.length;
        int index1 = 0;
        int index2 = 0;
        while(true) {
            if(index1 == len1) {
                return num2[index2 + k - 1];
            }
            if(index2 == len2) {
                return num1[index1 + k - 1];
            }
            if(k == 1) {
                return Math.min(num1[index1], num2[index2]);
            }
            int half = k / 2;
            // 下标可能会越界
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            if(num1[newIndex1] <= num2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            }else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
