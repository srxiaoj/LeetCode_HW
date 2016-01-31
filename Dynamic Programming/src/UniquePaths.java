/**
 * Created by thanksgiving on 1/31/16.
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths(1, 2));
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) return 0;
        // if (m == 0 || n == 0) return 1;
        int[][] sum = new int[m + 1][n + 1];
        sum[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != 1 || j != 1)
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m][n];
    }
}
