/**
 * Created by thanksgiving on 9/23/16.
 */
public class LargestConnectedArea {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 1}
        };
        System.out.println(maxArea(matrix));
    }

    private static int[][] dist = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int maxArea(int[][] matrix) {
        UnionFind uf = new UnionFind(matrix);
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dist) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] == matrix[x][y]) {
                        uf.unoin(i * n + j, x * n + y);
                    }
                }
            }
        }
        return uf.count();
    }

    static class UnionFind {
        int[] father;

        public UnionFind(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            father = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    father[i * n + j] = i * n + j;
                }
            }
        }

        public void unoin(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 != find2)
                father[find1] = find2;
        }

        public int find(int p) {
            while (p != father[p]) {
                p = father[p];
                father[p] = father[father[p]];
            }
            return p;
        }

        public int count() {
            int[] count = new int[father.length];
            int max = 1;
            for (int i = 0; i < father.length; i++) {
                count[find(i)]++;
                max = Math.max(max, count[find(i)]);
            }
            printArray(count);
            return max;
        }
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
