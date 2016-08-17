import java.util.*;

/**
 * 一个rooted tree 最多有两个点可以组成MHTs
 * bfs, 从degree为1的点往内找，知道只剩下一个或者两个点
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(findMinHeightTrees(6, edges));

        int[][] edges2 = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(findMinHeightTrees(4, edges2));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
