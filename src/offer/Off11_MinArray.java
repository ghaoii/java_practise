package offer;

public class Off11_MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                while(left < right) {
                    if(numbers[left + 1] < numbers[left]) {
                        return numbers[left + 1];
                    }
                    left++;
                }
            }
            if(numbers[mid] >= numbers[left] && numbers[mid] <= numbers[right]) {
                // 说明mid目前处于旋转数组的较大侧
                left = mid + 1;
            }else {
                // 说明mid目前处于旋转数组的较小侧
                right = mid;
            }
        }
        return numbers[left];
    }
}
