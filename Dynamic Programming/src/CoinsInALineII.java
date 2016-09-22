/**
 * Created by thanksgiving on 9/22/16.
 */
public class CoinsInALineII {
    public static void main(String[] args) {
        System.out.println("------1st-------");
//        System.out.println(firstWillWinLintCode(new int[]{-1}));
//        System.out.println(firstWillWinLintCode(new int[]{-1, -2}));
//        System.out.println(firstWillWinLintCode(new int[]{1, 2, 2, 4}));
//        System.out.println(firstWillWinLintCode(new int[]{1, 2, 2}));
//        System.out.println(firstWillWinLintCode(new int[]{1, 2, 4}));
//        System.out.println(firstWillWinLintCode(new int[]{1, 2, 4, 3, 4, 8, 5, 6, 12}));
//        System.out.println(firstWillWinLintCode(new int[]{3, 4, 8, 5, 6, 12}));

        System.out.println("------2nd-------");
//        System.out.println(firstWillWinSegmentFaultSolution(new int[]{-1}));
//        System.out.println(firstWillWinSegmentFaultSolution(new int[]{-1, -2}));
//        System.out.println(firstWillWinSegmentFaultSolution(new int[]{1, 2, 2, 4}));
//        System.out.println(firstWillWinSegmentFaultSolution(new int[]{1, 2, 2}));
//        System.out.println(firstWillWinSegmentFaultSolution(new int[]{1, 2, 4}));
        System.out.println(firstWillWinSegmentFaultSolution(new int[]{1, 2, 4, 3, 4, 8, 5, 6, 12}));
        System.out.println(firstWillWinSegmentFaultSolution(new int[]{3, 4, 8, 5, 6, 12}));

        System.out.println("------3rd-------");
//        System.out.println(firstWillWinHW(new int[]{-1}));
//        System.out.println(firstWillWinHW(new int[]{-1, -2}));
//        System.out.println(firstWillWinHW(new int[]{1, 2, 2, 4}));
//        System.out.println(firstWillWinHW(new int[]{1, 2, 2}));
//        System.out.println(firstWillWinHW(new int[]{1, 2, 4}));
        System.out.println(firstWillWinHW(new int[]{1, 2, 4, 3, 4, 8, 5, 6, 12}));
        System.out.println(firstWillWinHW(new int[]{3, 4, 8, 5, 6, 12}));
    }

    /**
     * O(n^2)
     */
    public static boolean firstWillWinHW(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else if (i + 1 == j || i + 2 == j) {
                    dp[i][j] = Math.max(nums[i], nums[i] + nums[i + 1]);
                } else if (i + 2 < j) {
                    // choose 1
                    dp[i][j] = nums[i] + Math.min(dp[i + 2][j], dp[i + 3][j]);
                    // choose 2
                    dp[i][j] = Math.max(dp[i][j], nums[i] + nums[i + 1] + Math.min(dp[i + 3][j], dp[i + 4][j]));
                }
            }
        }
//        printArray(dp);
//        System.out.println(sum);
        return dp[0][n - 1] > sum - dp[0][n - 1];
    }

    // segment fault 解法
    public static boolean firstWillWinSegmentFaultSolution(int[] nums) {
        // write your code here
        int n = nums.length;
        if (n <= 2) {
            return true;
        }
        //dp[i] means the largest value you(the first player)
        //can get when you start from nums[i]
        int[] dp = new int[n + 1];
        //not even exist
        dp[n] = 0;
        //when you happen to have the last coin, yes, consider the last first
        dp[n - 1] = nums[n - 1];
        //sure we should get the last two for most value
        dp[n - 2] = nums[n - 1] + nums[n - 2];
        //same rules, why leave two(n-1, n-2) for the other player
        dp[n - 3] = nums[n - 2] + nums[n - 3];
        //next we are gonna sum up
        for (int i = n - 4; i >= 0; i--) {
            //you have to have nums[i] and the non-optimal later choice
            //because the other player is smart to leave you the worse one
            //between two of your optimal choices
            dp[i] = nums[i] + Math.min(dp[i + 2], dp[i + 3]);
            dp[i] = Math.max(dp[i], nums[i] + nums[i + 1] + Math.min(dp[i + 3], dp[i + 4]));
            //equals to: dp[i] = Math.max(nums[i] + Math.min(dp[i+2],dp[i+3]), nums[i] + nums[i+1] + Math.min(dp[i+3], dp[i+4]));
//            printArray(dp);
        }
        //compute the total value of coins
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
//        System.out.println(sum);
        //compare your final value to the other player's
        return dp[0] > sum - dp[0];
    }

    // lintcode 答案
    public static boolean firstWillWinLintCode(int[] nums) {
        // write your code here
        int[] dp = new int[nums.length + 1];
        boolean[] flag = new boolean[nums.length + 1];
        int sum = 0;
        for (int now : nums)
            sum += now;

        return sum < 2 * MemorySearch(nums.length, dp, flag, nums);
    }

    private static int MemorySearch(int n, int[] dp, boolean[] flag, int[] values) {
        if (flag[n] == true)
            return dp[n];
        flag[n] = true;
        if (n == 0) {
            dp[n] = 0;
        } else if (n == 1) {
            dp[n] = values[values.length - 1];
        } else if (n == 2) {
            dp[n] = values[values.length - 1] + values[values.length - 2];
        } else if (n == 3) {
            dp[n] = values[values.length - 2] + values[values.length - 3];
        } else {
            dp[n] = Math.max(
                    Math.min(MemorySearch(n - 2, dp, flag, values), MemorySearch(n - 3, dp, flag, values)) + values[values.length - n],
                    Math.min(MemorySearch(n - 3, dp, flag, values), MemorySearch(n - 4, dp, flag, values)) + values[values.length - n] + values[values.length - n + 1]
            );
        }
        printArray(dp);

        return dp[n];
    }

    /**
     * print 2D array.
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("]");
        }
        System.out.println("");
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
