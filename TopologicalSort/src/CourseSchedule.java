import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 7/26/16.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int n, int[][] prerequisites) {
        Graph g = new Graph(n);
        for (int i = 0; i < prerequisites.length; i++) {
            g.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        return g.topologicalSort();
    }

    static class Graph {
        int V;
        LinkedList<Integer>[] adj;
        public Graph(int v) {
            this.V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        public void addEdge(int v, int u) {
            adj[v].add(u);
        }

        public boolean topologicalSort() {
            boolean[] visit = new boolean[V];
            boolean[] alreadyFinished = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!dfs(visit, alreadyFinished, i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(boolean[] visit, boolean[] alreadyFinished, int last) {
            if (visit[last]) return true;
            visit[last] = true;
            List<Integer> nextList = adj[last];
            for (int next : nextList) {
                if (visit[next] && !alreadyFinished[next]) {
                    return false;
                }
                if (!dfs(visit, alreadyFinished, next)) {
                    return false;
                }
            }
            alreadyFinished[last] = true;
            return true;
        }
    }

}
