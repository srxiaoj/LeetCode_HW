/**
 * Created by thanksgiving on 7/24/16.
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(5, edges));
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(countComponents(5, edges2));
    }

    public static int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return 0;
        UnionFind uf = new UnionFind(n);
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            uf.union(edges[i][0], edges[i][1]);
//            printArray(uf.father);
        }

        return uf.countGroup();
    }

    static class UnionFind {
        int[] father;
        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
        }

        public void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            father[find1] = find2;
        }

        public int find(int p) {
            while (p != father[p]) {
                father[p] = father[father[p]];
                p = father[p];
            }
            return p;
        }

        public int countGroup() {
            int[] count = new int[father.length];
            for (int i = 0; i < father.length; i++) {
                count[find(i)]++;
            }
//            printArray(count);

            int num = 0;
            for (int i = 0; i < father.length; i++) {
                if (count[i] != 0) {
                    num++;
                }
            }
            return num;
        }
    }

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
