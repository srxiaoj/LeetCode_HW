import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/10/12.
 */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        printDensityVector(pacificAtlantic(matrix));
    }

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null) return res;
        int m = matrix.length, n = matrix[0].length;

        Set<Integer> pacific = new HashSet<>();
        Set<Integer> atlantic = new HashSet<>();

        for (int i = 0; i < n; i++) {
            dfs(i, pacific, matrix);
            dfs((m - 1) * n + i, atlantic, matrix);
        }
        for (int i = 0; i < m; i++) {
            dfs(i * n, pacific, matrix);
            dfs(i * n + n - 1, atlantic, matrix);
        }
        pacific.retainAll(atlantic);
        for (int pos : pacific) {
            int i = pos / n;
            int j = pos % n;
            int[] tmpResult = {i, j};
            res.add(tmpResult);
        }
        return res;
    }

    public static void dfs(int pos, Set<Integer> set, int[][] matrix) {
        if (set.contains(pos)) return;
        int i = pos / matrix[0].length;
        int j = pos % matrix[0].length;
        set.add(pos);
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] >= matrix[i][j]) {
                dfs(x * matrix[0].length + y, set, matrix);
            }
        }
    }

    public static void printDensityVector(List<int[]> lists) {
        System.out.print("[");
        for (int j = 0; j < lists.size(); j++) {
            int[] temp = lists.get(j);
            System.out.print("[" + temp[0] + "," + temp[1] + "]");
        }
        System.out.println("]");
    }
}
