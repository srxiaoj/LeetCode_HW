import java.util.Arrays;
import java.util.LinkedList;

/**
 * if (!visited && grid[i][j] == '1'
 *  dfs(i, j, visited, grid);
 *  sum++
 */
public class NumberofIslands {
    public static void main(String[] args) {
        NumberofIslands obj = new NumberofIslands();
        char[][] test = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(obj.numIslandsBfs(test));
    }

    /**
     * bfs
     */
    public int numIslandsBfs(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void bfsFill(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        int code = x * n + y;
        grid[x][y] = '0';
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            // get the index of next block with '1'
            int i = code / n;
            int j = code % n;

            //search upward and mark adjacent '1's as '0'.
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * n + j);
                grid[i - 1][j] = '0';
            }
            //down
            if (i < m - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * n + j);
                grid[i + 1][j] = '0';
            }
            //left
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer(i * n + j - 1);
                grid[i][j - 1] = '0';
            }
            //right
            if (j < n - 1 && grid[i][j + 1] == '1') {
                queue.offer(i * n + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }

    /**
     * dfs
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int sum = 0;
        boolean[][] isVisited = new boolean[m][n];
        for (boolean[] a : isVisited) {
            Arrays.fill(a, false);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    dfs(grid, isVisited, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void dfs(char[][] grid, boolean[][] isVisited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || isVisited[i][j] == true || grid[i][j] == '0')
            return;
        isVisited[i][j] = true;
        dfs(grid, isVisited, i + 1, j);
        dfs(grid, isVisited, i - 1, j);
        dfs(grid, isVisited, i, j + 1);
        dfs(grid, isVisited, i, j - 1);
    }
}
