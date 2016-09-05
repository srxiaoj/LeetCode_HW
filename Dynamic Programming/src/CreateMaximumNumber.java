/**
 * Created by thanksgiving on 9/2/16.
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
//        int[] a = {3, 4, 6, 5};
//        int[] b = {9, 1, 2, 5, 8, 3};
        int[] a = {3, 4};
        int[] b = {9, 1, 8, 2};
        printArray(maxNumber(a, b, 3));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[][][] dp = new int[k + 1][m][n];

        boolean[] visit1 = new boolean[m];
        boolean[] visit2 = new boolean[n];

        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[p][i][j] = Math.max(dp[p][i][j], dp[p - 1][i][j] * 10);
                    if (visit1[i] && visit2[j]) continue;
                    if (visit1[i]) {
                        if (dp[p][i][j] < dp[p - 1][i][j] * 10 + nums2[j]) {
                            visit2[j] = true;
                        }
                        dp[p][i][j] = Math.max(Math.max((i == 0 ? 0 : dp[p][i - 1][j]), (j == 0 ? 0 : dp[p][i][j - 1])), dp[p - 1][i][j] * 10 + nums2[j]);
                    } else if (visit2[j]) {
                        if (dp[p][i][j]< dp[p - 1][i][j] * 10 + nums1[i]) {
                            visit1[i] = true;
                        }
                        dp[p][i][j] = Math.max(Math.max((i == 0 ? 0 : dp[p][i - 1][j]), (j == 0 ? 0 : dp[p][i][j - 1])), dp[p - 1][i][j] * 10 + nums1[i]);
                    } else {
                        if (nums1[i] > nums2[j]) {
                            if (dp[p][i][j] < dp[p - 1][i][j] * 10 + Math.max(nums1[i], nums2[j])) {
                                visit1[i] = true;
                            }
                            dp[p][i][j] = Math.max(Math.max((i == 0 ? 0 : dp[p][i - 1][j]), (j == 0 ? 0 : dp[p][i][j - 1])), dp[p - 1][i][j] * 10 + Math.max(nums1[i], nums2[j]));
                        } else {
                            if (dp[p][i][j] < dp[p - 1][i][j] * 10 + Math.max(nums1[i], nums2[j])) {
                                visit2[j] = true;
                            }
                            dp[p][i][j] = Math.max(Math.max((i == 0 ? 0 : dp[p][i - 1][j]), (j == 0 ? 0 : dp[p][i][j - 1])), dp[p - 1][i][j] * 10 + Math.max(nums1[i], nums2[j]));
                        }
                    }
                }
            }
            System.out.println("p = " + p);
            printArray(dp[p]);
            printArray(visit1);
            printArray(visit2);
        }
        int[] res = new int[k];
        int fac = 1;
        for (int i = k - 1; i >= 0; i--) {
            res[i] = (dp[k][m - 1][n - 1] / fac) % 10;
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
    public static void printArray(boolean[] A) {
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
