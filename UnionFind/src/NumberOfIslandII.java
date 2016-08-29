import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 8/28/16.
 */
public class NumberOfIslandII {
    public static void main(String[] args) {
        int[][] positions = new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        System.out.println(numIslands2(3, 3, positions));
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if (positions == null || positions.length == 0 || positions[0].length == 0 || m <= 0 || n <= 0) {
            return res;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        UnionFind uf = new UnionFind(m, n);
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int pos = x * n + y;
            uf.count++;
            uf.father[pos] = pos;//这个新加入的点的parent先设定为是它自己
            for (int[] dir : directions) {//在这个新加入的点四周找有没有可以合并的岛屿
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                int pos1 = x1 * n + y1;
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || uf.father[pos1] == -1) {//如果周围的点是海水就不用管，不能合并
                    continue;
                }
                uf.union(pos1, pos);
            }
            res.add(uf.count);
        }
        return res;
    }

    static class UnionFind {
        int[] father;
        int count = 0;

        public UnionFind(int m, int n) {
            father = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    father[i * n + j] = -1;
                }
            }
        }

        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }

        public int find(int p) {
            while (p != father[p]) {
                father[p] = father[father[p]];
                p = father[p];
            }
            return p;
        }
    }
}
