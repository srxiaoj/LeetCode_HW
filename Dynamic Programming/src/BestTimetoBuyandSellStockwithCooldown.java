/**
 * Created by thanksgiving on 4/26/16.
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
//        int[] prices = {2, 4, 1, 5, 3, 4};
//        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] sell = new int[len];
        int[] coolDown = new int[len];
        sell[0] = 0;
        coolDown[0] = 0;
        for (int i = 1; i < len; i++) {
            sell[i] = Math.max(sell[i - 1] + prices[i] - prices[i - 1], coolDown[i - 1]);
            coolDown[i] = Math.max(sell[i - 1], coolDown[i - 1]);
        }
        printArray(sell);
        printArray(coolDown);
        return Math.max(sell[len - 1], coolDown[len - 1]);
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //整个交易过程中，我们有两种状态，一种是手头只有钱没股票，一种是手头有股票没钱. 鍥磋鎴戜滑@1point 3 acres
        //而最后获得最大利润的状态肯定是手头只有钱，所有股票都被抛售的状态
        int[] sell = new int[prices.length];
        //sell position 就是空仓，表示在这个位置我们手头没有股票
        int[] buy = new int[prices.length];
        //buy position 就是满仓，表示在这个位置我们手头已经买了股票，在等待机会抛售
        sell[0] = 0;
        //初始情况，因为手头没股票，所以盈利是0
        buy[0] = 0 - prices[0];
        //初始情况，我们钱买了股票，所以是 0-prices[0]
        for (int i = 1; i < prices.length; i++) {
            //空仓的最大利润的递归式是：sell[i] = max(sell[i-1],buy[i-1]+prices[i]);
            //意思就是当前最大利润应该为前一天空仓的利润（既我们这一天不做任何买卖）和前一天满仓和今天卖出 两者中的最大值
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            if (i == 1) {
                //而对于满仓的话，递归式应该为 buy[i] = max(buy[i-1],sell[i-2]-prices[i])
                //意思即是 满仓的最大值应该是 前一天满仓，和两天之前空仓今天买入 中的最大值
                //因为题目限定了要隔一天才能买
                //对于第一天要单独考虑，因为之前没有买过股票
                buy[i] = Math.max(buy[0], 0 - prices[1]);
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            }
        }
        printArray(sell);
        printArray(buy);
        return sell[prices.length - 1];
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

