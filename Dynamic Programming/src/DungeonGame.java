/**
 * Created by thanksgiving on 8/14/16.
 */
public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(calculateMinimumHP(dungeon));

        int[][] dungeon2 = new int[][]{
                {1, -3, 3},
                {0, -2, 0},
                {-3, -3, -3}
        };
        System.out.println(calculateMinimumHP(dungeon2));

        int[][] dungeon3 = new int[][]{
                {1, -3, 2},
                {0, -1, 2},
                {0, 0, -2}
        };
        System.out.println(calculateMinimumHP(dungeon3));

        int[][] dungeon4 = new int[][]{
                {1, -2, 3},
                {2, -2, -2}
        };
        System.out.println(calculateMinimumHP(dungeon4));

    }


    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;

        int[][] cur = new int[m + 1][n + 1];
        int[][] minRequired = new int[m + 1][n + 1];
        int[][] maxCur = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    minRequired[i][j] = Math.max(minRequired[i][j - 1], -cur[i][j - 1] - dungeon[i - 1][j - 1] + 1);
                    cur[i][j] = cur[i][j - 1] + dungeon[i - 1][j - 1];
                    maxCur[i][j] = cur[i][j - 1] + dungeon[i - 1][j - 1];
                } else if (j == 1) {
                    minRequired[i][j] = Math.max(minRequired[i - 1][j], -cur[i - 1][j] - dungeon[i - 1][j - 1] + 1);
                    cur[i][j] = cur[i - 1][j] + dungeon[i - 1][j - 1];
                    maxCur[i][j] = cur[i - 1][j] + dungeon[i - 1][j - 1];
                } else {
                    if (minRequired[i - 1][j] < minRequired[i][j - 1]) {
                        minRequired[i][j] = Math.max(minRequired[i - 1][j], -cur[i - 1][j] - dungeon[i - 1][j - 1] + 1);
                        cur[i][j] = cur[i - 1][j] + dungeon[i - 1][j - 1];
                    } else {
                        minRequired[i][j] = Math.max(minRequired[i][j - 1], -cur[i][j - 1] - dungeon[i - 1][j - 1] + 1);
                        cur[i][j] = cur[i][j - 1] + dungeon[i - 1][j - 1];
                    }
                    maxCur[i][j] = Math.max(maxCur[i - 1][j], maxCur[i][j - 1]) + dungeon[i - 1][j - 1];
                    if (-maxCur[i][j] > 0) {
                        minRequired[i][j] = Math.min(-maxCur[i][j], minRequired[i][j]);
                    }
                }
            }
        }
        printArray(minRequired);
        printArray(cur);
        printArray(maxCur);
        return minRequired[m][n];
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
