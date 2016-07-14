import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandNumberWithDifferentShapes {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 0}};
//        System.out.println(getIslandNumberWithDifferentShapes(matrix));
        System.out.println(countIslands(matrix));
    }

    public static int countIslands(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];

        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visit[i][j]) {
                    List<Integer> shape = new ArrayList<>();
                    dfs(matrix, i, j, visit, shape);
                    String shapeKey = getShape(shape);
                    set.add(shapeKey);
                }
            }
        }
        return set.size();
    }

    private static String getShape(List<Integer> shape) {
        int diff = shape.get(0) - 0;
        StringBuilder sb = new StringBuilder();
        for (int val : shape) {
            sb.append(val - diff).append(",");
        }
        return sb.toString();
    }

    private static void dfs(int[][] matrix, int i, int j, boolean[][] visit, List<Integer> shape) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visit[i][j] || matrix[i][j] != 1) return;
        visit[i][j] = true;
        //dfs遍历的方向可以优化一下，只需要右边，右下，下，左下，右上五个方向即可。
//        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] d = {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, 1}};
        int n = matrix[0].length;
        shape.add(i * n + j);
        for (int[] sub : d) {
            int x = i + sub[0];
            int y = j + sub[1];
            dfs(matrix, x, y, visit, shape);
        }
    }








    /*public static int getIslandNumberWithDifferentShapes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    List<Integer> path = new ArrayList<Integer>();
                    helper(matrix, visited, i, j, path);
                    String str = transferToKey(path);
                    set.add(str);
                }
            }
        }

        return set.size();
    }

    private static String transferToKey(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        int diff = path.get(0) - 0;
        for (int i : path) {
            sb.append((i - diff) + "#");
        }
        return sb.toString();
    }

    private static void helper(int[][] matrix, boolean[][] visited, int x, int y, List<Integer> path) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] || matrix[x][y] != 1) {
            return;
        }
        int n = matrix[0].length;
        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
        visited[x][y] = true;
        path.add((x * n + y));
        for (int i = 0; i < dx.length; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            helper(matrix, visited, nx, ny, path);
        }
    }*/
}
