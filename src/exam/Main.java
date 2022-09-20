package exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int min = 0;
        for (int i = 0; i < n; i += 2) {
            if(nums[i] < nums[min]) {
                min = i;
            }
        }
        int max = 0;
        for (int i = 1; i < n; i += 2) {
            if(nums[i] > nums[max]) {
                max = i;
            }
        }
        if(min != max) {
            int temp = nums[min];
            nums[min] = nums[max];
            nums[max] = temp;
        }
        int sum = 0;
        int flag = 1;
        for (int i = 0; i < n; i++) {
            sum += flag * nums[i];
            flag = -flag;
        }
        System.out.println(sum);
    }
}
