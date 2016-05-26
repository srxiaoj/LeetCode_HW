import java.util.Arrays;

/**
 * Created by thanksgiving on 1/31/16.
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths1D(3, 5));
        System.out.println(obj.uniquePathsMath(3, 5));
    }

    /**
     * 纯数学解法
     * 从起点到终点一共要走m + n - 2步，每一步有2种组合
     * 所以全部的方法一共是C(m + n - 2, 2);
     */
    public int uniquePathsMath(int m, int n) {
        if (m == 0 && n == 0) return 0;
        int fac1 = 1, fac2 = 1, fac3 = 1;
        for (int i = 1; i <= m + n - 2; i++) {
            fac1 *= i;
        }
        for (int i = 1; i <= m - 1; i++) {
            fac2 *= i;
        }
        for (int i = 1; i <= n - 1; i++) {
            fac3 *= i;
        }
        return fac1 / (fac2 * fac3);
    }


    /**
     * 1d 解法
     * 借用挪位的规律，每下一行的结果为上一行的前一个结果和当前行前一个结果的和
     */
    public int uniquePaths1D(int m, int n) {
        if (m == 0 && n == 0) return 0;
        int[] sum = new int[n];
        Arrays.fill(sum, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[j] += sum[j - 1];
            }
        }
        return sum[n - 1];
    }

    /**
     * 2d 解法
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) return 0;
        // if (m == 0 || n == 0) return 1;
        int[][] sum = new int[m + 1][n + 1];
        sum[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!(i == 1 && j == 1))
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m][n];
    }
}
