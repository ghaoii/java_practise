package exam;

public class Main {
    public static int maxMoney(int[] prices) {
        if(prices == null || prices.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int ret = maxMoney(prices);
        System.out.println(ret);
        int[] prices2 = {7,7,7,7,7};
        int ret2 = maxMoney(prices2);
        System.out.println(ret2);
    }
}