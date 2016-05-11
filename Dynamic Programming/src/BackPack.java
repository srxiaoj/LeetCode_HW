import java.util.Arrays;

/**
 * Created by thanksgiving on 5/9/16.
 */
public class BackPack {
    public static void main(String[] args) {
        BackPack obj = new BackPack();
        int[] A = {2, 2, 3, 2};
        System.out.println(obj.backPack(8, A));
    }

    /**
     * dp[i]那一列代表放第i个item
     */
    public int backPack(int m, int[] A) {
        boolean dp[][] = new boolean[A.length + 1][m + 1];
        for (boolean[] sub : dp) {
            Arrays.fill(sub, false);
        }

        dp[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                // not include item i
                dp[i + 1][j] = dp[i][j];
                // include item i, j >= A[i] just to make sure no outOfBoundary error
                if (j >= A[i] && dp[i][j - A[i]]) {
                    dp[i + 1][j] = true;
                }
            }
        }

        for (int i = m; i >= 0; i--) {
            if (dp[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
}
