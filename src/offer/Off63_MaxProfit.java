package offer;

public class Off63_MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int max = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prev > prices[i]) {
                prev = prices[i];
            }else {
                max = Math.max(prices[i] - prev, max);
            }
        }
        return max;
    }
}
