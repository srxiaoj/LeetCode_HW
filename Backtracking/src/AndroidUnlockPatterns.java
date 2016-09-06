/**
 * Created by thanksgiving on 9/5/16.
 */
public class AndroidUnlockPatterns {
    public static void main(String[] args) {
        System.out.println(numberOfPatterns(2, 2));
    }

    /**
     * 1    2    3
     * 4    5    6
     * 7    8    9
     * The optimization idea is that 1,3,7,9 are symmetric, 2,4,6,8 are also symmetric.
     * Hence we only calculate one among each group and multiply by 4
     */
    public static int numberOfPatterns(int m, int n) {
        // Skip array represents number to skip between two pairs
        // 1和3中间隔2, 1和7中间隔4
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
//        printArray(skip);
        boolean visit[] = new boolean[10];
        int res = 0;
        // dfs search each length from m to n
        for (int i = m; i <= n; ++i) {
            res += dfs(visit, skip, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
            res += dfs(visit, skip, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
            res += dfs(visit, skip, 5, i - 1);        // 5
        }
        return res;
    }

    private static int dfs(boolean visit[], int[][] skip, int cur, int remain) {
        if (remain < 0) return 0;
        if (remain == 0) return 1;
        visit[cur] = true;
        int res = 0;
        for (int i = 1; i <= 9; ++i) {
            // If visit[i] is not visited and (two numbers are adjacent or skip number is already visited)
            if (!visit[i] && (skip[cur][i] == 0 || (visit[skip[cur][i]]))) {
                res += dfs(visit, skip, i, remain - 1);
            }
        }
        visit[cur] = false;
        return res;
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
}
