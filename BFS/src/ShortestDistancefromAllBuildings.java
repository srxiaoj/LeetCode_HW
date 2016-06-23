import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thanksgiving on 6/23/16.
 */
public class ShortestDistancefromAllBuildings {
    public static void main(String[] args) {
        ShortestDistancefromAllBuildings obj = new ShortestDistancefromAllBuildings();
        int[][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(obj.shortestDistance(grid));
        int[][] grid2 = {{0, 2, 1}, {1, 0, 2}, {0, 1, 0}};
        System.out.println(obj.shortestDistance(grid2));
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] count = new int[m][n];
        int[][] total = new int[m][n];
        boolean[][] visit = new boolean[m][n];
        for (boolean[] sub : visit) {
            Arrays.fill(sub, false);
        }

        boolean[][] canTravel = new boolean[m][n];
        for (boolean[] sub : canTravel) {
            Arrays.fill(sub, true);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (boolean[] sub : visit) {
                        Arrays.fill(sub, false);
                    }
                    for (int[] sub : count) {
                        Arrays.fill(sub, 0);
                    }
                    helper(grid, i, j, count, total, visit, canTravel);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canTravel[i][j] && grid[i][j] == 0 && min > total[i][j]) {
                    min = total[i][j];
                }
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private void helper(int[][] grid, int i, int j, int[][] count, int[][] total, boolean[][] visit, boolean[][] canTravel) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) return;
        visit[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i * grid[0].length + j);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int x = num / n;
            int y = num % n;
            if (x + 1 < m && grid[x + 1][y] == 0 && !visit[x + 1][y]) {
                queue.offer((x + 1) * n + y);
                count[x + 1][y] = count[x][y] + 1;
                total[x + 1][y] += count[x + 1][y];
                visit[x + 1][y] = true;
            }

            if (x - 1 >= 0 && grid[x - 1][y] == 0 && !visit[x - 1][y]) {
                queue.offer((x - 1) * n + y);
                count[x - 1][y] = count[x][y] + 1;
                total[x - 1][y] += count[x - 1][y];
                visit[x - 1][y] = true;
            }

            if (y + 1 < n && grid[x][y + 1] == 0 && !visit[x][y + 1]) {
                queue.offer(x * n + y + 1);
                count[x][y + 1] = count[x][y] + 1;
                total[x][y + 1] += count[x][y + 1];
                visit[x][y + 1] = true;
            }

            if (y - 1 >= 0 && grid[x][y - 1] == 0 && !visit[x][y - 1]) {
                queue.offer(x * n + y - 1);
                count[x][y - 1] = count[x][y] + 1;
                total[x][y - 1] += count[x][y - 1];
                visit[x][y - 1] = true;
            }
        }

        for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
                if (grid[p][q] == 0 && count[p][q] == 0) {
                    canTravel[p][q] = false;
                }
            }
        }
    }
}
