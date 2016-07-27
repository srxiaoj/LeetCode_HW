import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thanksgiving on 7/27/16.
 */
public class ShortestDistanceWithKey {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', 'a', '0', '2', '0'},
                {'0', '0', '1', '1', 'A'},
                {'0', '1', '0', '0', '3'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(shortestDistance(grid));

    }

    public static int shortestDistance(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0 ;
        int col = grid[0].length;
        int[][] step = new int[row][col];
        int[][] step2 = new int[row][col];
        for (int[] sub : step) Arrays.fill(sub, Integer.MAX_VALUE);
        for (int[] sub : step2) Arrays.fill(sub, Integer.MAX_VALUE);
        int[] distanceToKey = new int[1];
        int resNokey = -1, resWithKey = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '2') {
                    step[i][j] = 0;
                    resNokey = bfsFromStartToDoor(grid, i, j, step, distanceToKey);
                }
                if (grid[i][j] == 'a') {
                    step2[i][j] = 0;
                    resWithKey = bfsFromKeyToDoor(grid, i, j, step2);
                }
            }
        }
        printArray(step);
        printArray(step2);
        System.out.println("resNoKey: " + resNokey + ", resWithKey: " + resWithKey);
        if (resNokey != -1 && resWithKey != -1) {
            return Math.min(resNokey, resWithKey + distanceToKey[0]);
        } else if (resNokey != -1) {
            return resWithKey;
        } else if (resWithKey != -1) {
            return resNokey;
        }
        return 0;
    }

    /**
     * return shortest distance from 2 to 3, no key
     */
    private static int bfsFromKeyToDoor(char[][] grid, int i, int j, int[][] steps2) {
        int m = grid.length;
        int n = grid[0].length;
        int index = i * n + j;
        int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            int last = queue.poll();
            int indexI = last / n;
            int indexJ = last % n;
            for (int[] d : distance) {
                int x = indexI + d[0];
                int y = indexJ + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n
                        && (grid[x][y] == '0' || grid[x][y] == '2' || grid[x][y] == 'A' || grid[x][y] == '3')
                        && steps2[indexI][indexJ] + 1 < steps2[x][y]) {
                    queue.offer(x * n + y);
                    steps2[x][y] = steps2[indexI][indexJ] + 1;
                    if (grid[x][y] == '3') {
                        return steps2[x][y];
                    }
                }
            }
        }
        return -1;
    }

    /**
     * return shortest distance from 2 to 3, no key
     */
    private static int bfsFromStartToDoor(char[][] grid, int i, int j, int[][] steps, int[] distanceToKey) {
        int m = grid.length;
        int n = grid[0].length;
        int index = i * n + j;
        int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            int last = queue.poll();
            int indexI = last / n;
            int indexJ = last % n;
            for (int[] d : distance) {
                int x = indexI + d[0];
                int y = indexJ + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && (grid[x][y] == '0' || grid[x][y] == '3' || grid[x][y] == 'a') && steps[indexI][indexJ] + 1 < steps[x][y]) {
                    queue.offer(x * n + y);
                    steps[x][y] = steps[indexI][indexJ] + 1;
                    if (grid[x][y] == '3') {
                        return steps[x][y];
                    } else if (grid[x][y] == 'a') {
                        distanceToKey[0] = steps[x][y];
                    }
                }
            }
        }
        return -1;
    }

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
