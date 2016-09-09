/**
 * Created by thanksgiving on 7/17/16.
 */
public class LeastWorseGuess {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print(getWorstGuess(i) + " ");
        }
    }

    public static int getWorstGuess(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                if (i + 2 == j) {
                    dp[i][j] = i + 1;
                } else if (i == j || i + 1 == j) {
                    dp[i][j] = i;
                } else {
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                    }
                }
            }
        }
        printArray(dp);
        return dp[0][n];
    }

    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
