import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 9/18/16.
 */
public class DetectCycleInGraph {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 3}};
        int v = 6;
        Graph graph = new Graph(v);
        System.out.println(graph.hasCycle(edges, v));
    }

    static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public boolean hasCycle(int[][] edges, int V) {
            for (int[] edge : edges) {
                addEdge(edge[0], edge[1]);
            }

            boolean[] visit = new boolean[V];
            boolean[] finished = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (helper(visit, finished, i)) return true;
            }
            return false;
        }

        private boolean helper(boolean[] visit, boolean[] finished, int v) {
            if (visit[v]) return false;
            visit[v] = true;
            List<Integer> nexts = adj[v];

            for (int i : nexts) {
                if (visit[i] && !finished[i]) return true;
                if (helper(visit, finished, i)) {
                    return true;
                }
            }
            finished[v] = true;
            return false;
        }
    }


}
