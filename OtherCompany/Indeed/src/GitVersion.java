import java.util.*;

/**
 * Created by Administrator on 2016/10/24.
 */
public class GitVersion {
    public static void main(String[] args) {

    }

    Graph graph;

    public GitVersion(int n) {
        this.graph = new Graph(n);
    }

    public List<Integer> findAllCommits(int head) {

        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(head);
        int level = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!map.containsKey(cur)) {
                map.put(cur, level);
                res.add(cur);
            }
            level++;
            for (int next : graph.children[cur]) {
                if (!map.containsKey(next)) {
                    queue.offer(next);
                }
            }
        }
        return res;
    }

    public void findAllParents(int node, Map<Integer, Integer> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!map.containsKey(cur)) {
                map.put(cur, level);
            }
            level++;
            for (int next : graph.parent[cur]) {
                if (!map.containsKey(next)) {
                    queue.offer(next);
                }
            }
        }
    }

    public int getLowestCommonParent(int p, int q) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        findAllParents(p, map1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(q);
        int level = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map1.containsKey(cur)) return cur;
            if (!map2.containsKey(cur)) {
                map2.put(cur, level);
            }
            level++;
            for (int next : graph.parent[cur]) {
                if (!map2.containsKey(next)) {
                    queue.offer(next);
                }
            }
        }
        return -1;
    }


    class Graph {
        LinkedList<Integer>[] children;
        LinkedList<Integer>[] parent;
        int V;

        public Graph(int v) {
            this.V = v;
            this.children = new LinkedList[v];
        }


    }
}
