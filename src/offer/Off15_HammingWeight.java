package offer;

public class Off15_HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Off15_HammingWeight test = new Off15_HammingWeight();
        int ret = test.hammingWeight(-3);
        System.out.println(ret);
    }
}
