/**
 * Created by thanksgiving on 7/21/16.
 */
public class Maze {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 5, 5, 5, 5, 0},
                {0, 5, 0, 5, 5, 0},
                {0, 5, 0, 0, 1, 0},
                {0, 5, 0, 0, 5, 0},
                {0, 0, 0, 5, 0, 9}
        };
        System.out.println(canTravel(grid));
    }

    public static boolean canTravel(int[][] grid) {
        if (grid == null) return false;
        int m = grid.length, n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        return dfs(grid, visit, 0, 0);
    }

    private static boolean dfs(int[][] grid, boolean[][] visit, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visit[i][j]) return false;
        if (grid[i][j] == 9) return true;
        if (grid[i][j] == 5) return false;
        visit[i][j] = true;

        if (dfs(grid, visit, i + 1, j) ||
                dfs(grid, visit, i - 1, j) ||
                dfs (grid, visit, i, j + 1) ||
                dfs(grid, visit, i, j - 1)) {
            return true;
        }
        visit[i][j] = false;
        return false;
    }
}
