public class BombEnemy {
    public static void main(String[] args) {
        char[][] grid = {{'0'}, {'E'}, {'0'}, {'W'}};
//        System.out.println(maxKilledEnemies(grid));

        char[][] grid2 = {{'E', 'E', 'E', 'E'},
                          {'0','0', '0', '0'},
                          {'E', 'E', 'E', 'E'}};
//        System.out.println(maxKilledEnemies(grid2));

        char[][] grid3 = {{'W', 'E', 'E', 'E', 'E', '0'},
                          {'E', 'E', 'E', 'E', 'E', 'W'}};
        System.out.println(maxKilledEnemies(grid3));

        char[][] grid4 = {
                {'W', 'W', 'W', 'W', 'E'},
                {'W', 'E', 'E', 'E', 'E'},
                {'W', 'E', '0', 'E', '0'},
                {'W', 'E', 'E', 'E', 'E'},
                {'W', 'W', 'W', 'W', 'W'}
        };
//        System.out.println(maxKilledEnemies(grid4));
    }

    public static int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        int max = 0;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    row[i] = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E')
                            row[i]++;
                    }
                }

                if (i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            col[j]++;
                        }
                    }
                }

                if (grid[i][j] == '0') {
                    max = Math.max(max, row[i] + col[j]);
                }
            }
        }

        return max;
        /*if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        int rowCache = 0;
        int[] colCache = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 只有在上一列为 W 或者新一行才重新计算当前行的rowCache
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCache = 0;
                    for (int k = j; k < col && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rowCache += 1;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCache[j] = 0;
                    for (int k = i; k < row && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            colCache[j] += 1;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowCache + colCache[j]);
                }
            }
        }
        return res;*/
    }

    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
