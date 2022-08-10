package leetcode;

public class Num461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int num = x ^ y;
        while(num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
