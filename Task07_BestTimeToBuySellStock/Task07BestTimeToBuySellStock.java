public class Task07BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Output: " + maxProfit(prices));
    }
}
