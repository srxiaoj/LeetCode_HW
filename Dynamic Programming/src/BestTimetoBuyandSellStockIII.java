/**
 * Created by thanksgiving on 1/4/16.
 */
public class BestTimetoBuyandSellStockIII {

  public static void main(String[] args) {
    BestTimetoBuyandSellStockIII obj = new BestTimetoBuyandSellStockIII();
//        int[] prices = {5, 4, 6, 3, 12, 7, 9, 2, 5, 1, 10, 6};
    int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
    int res = obj.maxProfit(prices);
    System.out.println("max profit for two transaction is: " + res);
  }

  public int maxProfit(int[] prices) {
    int size = prices.length;
    int k = 2;
    //if the size of prices is less than the number of transactions
    if (k >= size / 2) {
      return quickSolve(prices);
    }

    int[] sell = new int[k + 1];
    int[] buy = new int[k + 1];

    for (int i = 0; i < k + 1; i++) {
      sell[i] = 0;
      buy[i] = Integer.MIN_VALUE;
    }

    for (int i = 0; i < size; i++) {
      // 对于每个i,buy[2]为第二次买入后所剩收益,计算方法为取之前最大的buy[2]与sell[1]（第一次卖出后所得收益） - 当前价格的最大值
      // 同理,buy[1]为第一次买入后所剩收益,计算方法为取之前最大的buy[1]与 sell[0] (永远为0) - 当前价格的最大值
      // 对于每个i,sell[2]为第二次卖出后所得收益,计算方法为取之前最大的sell[2]与当前价格 + 第一次卖出后所剩收益的最大值
      for (int j = k; j > 0; j--) {
        // 计算buy[j]与sell[j]的顺序没有先后
        buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
        sell[j] = Math.max(sell[j], prices[i] + buy[j]);
      }
    }
    return sell[k];
  }

  private int quickSolve(int[] prices) {
    int size = prices.length;
    if (size == 0) {
      return 0;
    }
    int profit = 0;
    for (int i = 1; i < size; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }
}
