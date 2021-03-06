public class BestTimetoBuyandSellStockIV {

    public static void main(String[] args) {
        BestTimetoBuyandSellStockIV agent = new BestTimetoBuyandSellStockIV();
//        int[] p = new int[]{2, 1, 3, 2, 3, 1, 100};
        int[] p = new int[]{4, 9, 1, 3, 5, 10, 13, 2, 7};
        int max = agent.maxProfit(2, p);
        System.out.println(max);
    }

    /**
     * we need to use two arrays two track the maximum amount of profit after j transactions (sell[j])
     * and the balance we left after j buy transaction (buy[j]), for example, {1,3,1,9,1,6}, at i = 0, we buy prices[0],
     * then the balance is -1 for buy[1] (buy once) and buy[2] (buy twice, will still be once since there is only one price),
     * but sell[1] and sell[1] are both 0 because we haven't sold yet. Then at i = 1, we sell at prices[1],
     * then the profit sell[1] and sell[2] are both 3-1=2.
     * The KEY point is that the maximum profit should be the maximum between current sell price plus previous balance (prices[i]+buy[j]) and previous sell[j],
     * and the maximum buy should be the maximum between current sell[j-1]-prices[i] (balance of previous profit minus current price[i])
     * and previous balance buy[j], more information can be found in the note named:
     * E:\srxiaoj\����\COURSE\Knowledge\Computer Science\Best Time to Buy and Sell Stock.JPG
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        //DP for at most k trades
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                sell[j] = Math.max(sell[j], prices[i] + buy[j]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }
            System.out.print("sell: ");
            printArray(sell);
            System.out.print("buy: ");
            printArray(buy);
        }
        return sell[k];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
