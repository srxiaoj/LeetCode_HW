/**
 * Created by Administrator on 2016/10/21.
 */
public class BattleshipsinaBoard {
    public static void main(String[] args) {
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', 'X', '.', 'X'}
        };
        System.out.println(countBattleships(board));
    }

    public static int countBattleships(char[][] board) {
        int[][] dist = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (board == null || board.length == 0) return 0;
        int m = board.length, n = board[0].length;
        UnionFind uf = new UnionFind(board);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    int index = i * n + j;
                    for (int[] d : dist) {
                        int x = i + d[0];
                        int y = j + d[1];
                        int newIndex = x * n + y;
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'X') {
                            uf.union(index, newIndex);
                        }
                    }
                }
            }
        }
        return uf.count();

    }

    static class UnionFind {
        int[] father;
        int n;
        int count;

        public UnionFind(char[][] board) {
            int m = board.length, n = board[0].length;
            this.n = m * n;
            this.father = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X') {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }
            }
        }

        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (father[find1] != find2) {
                father[find1] = find2;
                count--;
            }
        }

        public int find(int p) {
            while (father[p] != p) {
                p = father[p];
                father[p] = father[father[p]];
            }
            return p;
        }

        public int count() {
            return count;
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
