/**
 * Created by thanksgiving on 9/2/16.
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 5};
        int[] b = {9, 1, 2, 5, 8, 3};
        printArray(maxNumber(a, b, 5));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[][][] dp = new int[m][n][k + 1];

        boolean[][] visit1 = new boolean[m][k + 1];
        boolean[][] visit2 = new boolean[n][k + 1];

        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j][p] = Math.max(dp[i][j][p], dp[i][j][p - 1] * 10);
                    if (visit1[i][p - 1] && visit2[j][p - 1]) continue;
                    if (visit1[i][p - 1]) {
                        if (dp[i][j][p] < dp[i][j][p - 1] * 10 + nums2[j]) {
                            dp[i][j][p] = dp[i][j][p - 1] * 10 + nums2[j];
                            visit2[j][p] = true;
                        }
                    } else if (visit2[j][p - 1]) {
                        if (dp[i][j][p] < dp[i][j][p - 1] * 10 + nums1[i]) {
                            dp[i][j][p] = dp[i][j][p - 1] * 10 + nums1[i];
                            visit1[i][p] = true;
                        }
                    } else {
                        if (nums1[i] > nums2[j]) {
                            if (dp[i][j][p] < dp[i][j][p - 1] * 10 + Math.max(nums1[i], nums2[j])) {
                                dp[i][j][p] = Math.max(dp[i][j][p], dp[i][j][p - 1] * 10 + Math.max(nums1[i], nums2[j]));
                                visit1[i][p] = true;
                            }
                        } else {
                            if (dp[i][j][p] < dp[i][j][p - 1] * 10 + Math.max(nums1[i], nums2[j])) {
                                dp[i][j][p] = Math.max(dp[i][j][p], dp[i][j][p - 1] * 10 + Math.max(nums1[i], nums2[j]));
                                visit2[j][p] = true;
                            }
                        }
                    }
                }
            }
        }
        int[] res = new int[k];
        int fac = 1;
        for (int i = k - 1; i >= 0; i--) {
            res[i] = (dp[m - 1][n - 1][k] / fac) % 10;
            fac *= 10;
        }
        return res;
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
