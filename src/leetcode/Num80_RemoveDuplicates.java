package leetcode;

public class Num80_RemoveDuplicates {
    //解法二
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int slow = 0;
        int fast = 1;
        int k = 1;
        while(fast < nums.length){
            //计算fast指向的元素出现的次数
            if(nums[slow] == nums[fast]){
                k++;
            }else{
                k = 1;
            }
            //如果是第一二次出现那么就拷贝，否则不拷贝
            if(k <= 2){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


    //解法一
//    public int removeDuplicates(int[] nums) {
//        int slow = 0;
//        int fast = 0;
//        int k = 0;
//        while(fast < nums.length){
//            if(nums[slow] == nums[fast]){
//                fast++;
//                k++;
//            }else{
//                if(k >= 2){
//                    //如果出现两次以上，则拷贝slow，并后移2步
//                    nums[slow + 1] = nums[slow];
//                    slow += 2;
//                }else{
//                    //如果只出现了一次则直接，无需拷贝直接后移
//                    slow++;
//                }
//                //把新出现的数字保存
//                nums[slow] = nums[fast];
//                fast++;
//                k = 1;//将k初始化为1
//            }
//        }
//        if(k >= 2){
//            nums[slow + 1] = nums[slow];
//            return slow + 2;
//        }else{
//            return slow + 1;
//        }
//    }
}
