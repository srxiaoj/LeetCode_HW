/**
 * Created by thanksgiving on 8/5/16.
 */
public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[] {1, 2, 3}));
        System.out.println(candy(new int[] {3, 1, 2}));
        System.out.println(candy(new int[] {1, 2, 2, 2, 2, 3}));
        System.out.println(candy(new int[] {2, 2}));
        System.out.println(candy(new int[] {1, 2, 2}));
        System.out.println(candy(new int[] {2, 2, 1}));
        System.out.println(candy(new int[] {1, 2, 2, 2}));
        System.out.println(candy(new int[] {1, 0, 2}));
        System.out.println(candy(new int[] {4, 2, 3, 4, 1}));
        System.out.println(candy(new int[] {2, 3, 2}));
    }

    /**
     * Give 1st child one candy. For the subsequent children, cope with as follows:
     assuming the child i - 1 have been allocated candies, then the next child (child i) will be allocated candies as one of the following ways:
     (1) when ratings[i] == ratings[i-1], one candy ;
     (2) when ratings[i] > ratings[i-1], 1 + the candies of previous child (child i-1) ;
     (3) when ratings[i] < ratings[i-1], count length of the continuous decrease array (mark as len), and we could figure out the sum of candies for child i-1, i, i+1, i -1 + len -1.
     */
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int res = 0;
        int[] dp = new int[n];
        int i = 1;
        dp[0] = 1;
        res += dp[0];
        while (i < n) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
                i++;
            } else if (ratings[i] == ratings[i - 1]) {
                dp[i] = 1;
                res += 1;
                i++;
            } else {
                // res要减去dp[i - 1]避免重复计算
                res -= dp[i - 1];
                int len = 1;
                int start = i - 1;
                while (i < n && ratings[i] < ratings[i - 1]) {
                    len++;
                    i++;
                }

                int minVal = len;
                for (int k = start; k < start + len; k++) {
                    if (k == start) {
                        // handle [4, 2, 3, 4, 1] 特例， 4要比3和1都大
                        dp[k] = Math.max(dp[k], minVal);
                    } else {
                        dp[k] = minVal;
                    }
                    res += dp[k];
                    minVal--;
                }
            }
        }
        printArray(dp);
        return res;
    }

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
