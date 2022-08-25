package offer;

public class Off17_PrintNumbers {
    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n + 1);
        int[] arr = new int[num - 1];
        for (int i = 1; i < num; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }
}
