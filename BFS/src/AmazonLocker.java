import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AmazonLocker {
    static int[][] getLockerDistanceGridDfs(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] grid = new int[cityLength][cityWidth];
        for (int[] sub : grid) {
            Arrays.fill(sub, Integer.MAX_VALUE);
        }
        for (int i = 0; i < lockerXCoordinates.length; i++) {
            grid[lockerXCoordinates[i] - 1][lockerYCoordinates[i] - 1] = 0;
        }
        for (int i = 0; i < lockerXCoordinates.length; i++) {
            dfs(grid, lockerXCoordinates[i] - 1, lockerYCoordinates[i] - 1, 0);
        }
        return grid;
    }

    private static void dfs(int[][] grid, int i, int j, int level) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        // 非常重要的判断条件，防止无限循环dfs
        if (level <= grid[i][j]) {
            grid[i][j] = Math.min(grid[i][j], level);
            dfs(grid, i + 1, j, level + 1);
            dfs(grid, i - 1, j, level + 1);
            dfs(grid, i, j + 1, level + 1);
            dfs(grid, i, j - 1, level + 1);
        }
    }


    static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] board = new int[cityLength][cityWidth];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < cityLength; i++)
            for (int j = 0; j < cityWidth; j++) {
                board[i][j] = Integer.MIN_VALUE;
            }
        for (int i = 0; i < lockerXCoordinates.length; i++) {
            int tmp = cityWidth * (lockerXCoordinates[i] - 1) + lockerYCoordinates[i] - 1;
            q.add(tmp);
            board[lockerXCoordinates[i] - 1][lockerYCoordinates[i] - 1] = 0;
        }

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                int tx = cur / cityWidth;
                int ty = cur % cityWidth;
                if (tx + 1 < cityLength && board[tx + 1][ty] == Integer.MIN_VALUE) {
                    board[tx + 1][ty] = board[tx][ty] + 1;
                    q.add(cur + cityWidth);
                }
                if (tx - 1 >= 0 && board[tx - 1][ty] == Integer.MIN_VALUE) {
                    board[tx - 1][ty] = board[tx][ty] + 1;
                    q.add(cur - cityWidth);
                }
                if (ty + 1 < cityWidth && board[tx][ty + 1] == Integer.MIN_VALUE) {
                    board[tx][ty + 1] = board[tx][ty] + 1;
                    q.add(cur + 1);
                }
                if (ty - 1 >= 0 && board[tx][ty - 1] == Integer.MIN_VALUE) {
                    board[tx][ty - 1] = board[tx][ty] + 1;
                    q.add(cur - 1);
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        int[] dx = {2, 4};
        int[] dy = {3, 7};
        int x = 5;
        int y = 7;
//        int[][] ans = getLockerDistanceGrid(x, y, dx, dy);
        int[][] ans = getLockerDistanceGridDfs(x, y, dx, dy);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
