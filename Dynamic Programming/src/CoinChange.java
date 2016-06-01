import java.util.Arrays;

/**
 * Created by thanksgiving on 2/11/16.
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(obj.coinChange(coins, amount));
    }

    /**
     * 如果dp[i - coins[j]] == Integer.MAX_VALUE 则说明i - coins[j]无法由coins[] 组合拼出来
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount)
                dp[coins[i]] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] < i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        printArray(dp);

        if (dp[amount] != Integer.MAX_VALUE)
            return dp[amount];
        else return -1;
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
