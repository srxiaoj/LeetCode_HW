/**
 * Created by thanksgiving on 4/26/16.
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown obj = new BestTimetoBuyandSellStockwithCooldown();
//        int[] prices = {1, 2, 3, 0, 2};
        int[] prices = {2, 4, 1, 5, 3, 4};
        System.out.println(obj.maxProfit(prices));

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

