/**
 * Created by thanksgiving on 4/26/16.
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown obj = new BestTimetoBuyandSellStockwithCooldown();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(obj.maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        int[] sell = new int[len];
        int[] coolDown = new int[len];
        sell[0] = 0;
        coolDown[0] = 0;
        for (int i = 1; i < len; i++) {
            sell[i] = Integer.max(sell[i - 1] + prices[i] - prices[i - 1], coolDown[i - 1]);
            coolDown[i] = Integer.max(sell[i - 1], coolDown[i - 1]);
        }
        return Integer.max(sell[len - 1], coolDown[len - 1]);
    }
}
