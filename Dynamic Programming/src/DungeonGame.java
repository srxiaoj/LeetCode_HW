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

        int[][] initHealth = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    initHealth[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    initHealth[i][j] = Math.max(1, initHealth[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    initHealth[i][j] = Math.max(1, initHealth[i + 1][j] - dungeon[i][j]);
                } else {
                    initHealth[i][j] = Math.max(Math.min(initHealth[i + 1][j], initHealth[i][j + 1]) - dungeon[i][j], 1);
                }
            }
            printArray(initHealth);
        }
        return initHealth[0][0];
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
