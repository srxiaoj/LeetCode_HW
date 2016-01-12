/**
 * Created by thanksgiving on 1/9/16.
 */
public class PaintHouse {
    public static void main(String[] args) {
        PaintHouse obj = new PaintHouse();
        int[][] costs = {
                {3, 5, 3},
                {6, 17, 6},
                {7, 13, 18},
                {9, 10, 18}
        };
        System.out.println(obj.minCost(costs));
    }
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int[][] expense = new int[n][3];
        for (int j = 0; j < 3; j++) {
            expense[0][j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    expense[i][0] = Math.min(expense[i - 1][1], expense[i - 1][2]) + costs[i][0];
                } else if (j == 1) {
                    expense[i][1] = Math.min(expense[i - 1][0], expense[i - 1][2]) + costs[i][1];
                } else {
                    expense[i][2] = Math.min(expense[i - 1][0], expense[i - 1][1]) + costs[i][2];
                }
            }
        }
        return Math.min(expense[n - 1][0], Math.min(expense[n - 1][1], expense[n - 1][2]));
    }

}
