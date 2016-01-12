/**
 * Created by thanksgiving on 1/9/16.
 */
public class PaintHouseII {
    public static void main(String[] args) {
        PaintHouseII obj = new PaintHouseII();
        int[][] costs = {
                {3, 5, 3, 4},
                {6, 17, 6, 3},
                {7, 13, 18, 1},
                {9, 10, 10, 8}
        };
        System.out.println(obj.minCostII(costs));
    }

    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        int[][] expense = new int[n][k];
        for (int j = 0; j < k; j++) {
            expense[0][j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                expense[i][j] = getMin(expense, i - 1, j) + costs[i][j];
            }
        }
        return getMin(expense, n - 1, -1);
    }

    private int getMin(int[][] array, int row, int exclude) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < array[0].length; j++) {
            if (j == exclude)
                continue;
            min = Math.min(min, array[row][j]);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
