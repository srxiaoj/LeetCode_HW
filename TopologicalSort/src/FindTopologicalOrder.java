import java.util.*;

/**
 * Created by thanksgiving on 7/26/16.
 */
public class FindTopologicalOrder {
    // This class represents a directed graph using adjacency
// list representation
    static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < V; i++) {
                sb.append(i + "->").append(adj[i]).append("\n");
            }
            return sb.toString();
        }

        // find topological sort order of a graph

        List<Integer> topologicalSort() {
            List<Integer> res = new ArrayList<>();
            Set<Integer> visit = new HashSet<>();
            boolean[] visitArray = new boolean[V];

            boolean[] instack = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < V; i++) {
                dfsDetectCycle(visitArray, instack, stack, i);
//                bfs(visit, stack, i);
            }
            while (!stack.isEmpty()) {
                res.add(stack.pop());
            }
            return res;
        }
        // alreadyFinishedPoints 用来存已经全部dfs跑完了的点，如果这个点已经跑完了，那么一定visit[i] = true, 而且一定先于其上一个点放在alreadyFinishedPoints里面，所以i
        // 如果碰到一个点alreadyFinishedPoints[i] = false 而 visit[i] = true则说明这个点一定由cycle产生的
        void dfsDetectCycle(boolean[] visit, boolean[] alreadyFinishedPoints, Stack<Integer> stack, int last) {
            if (visit[last]) return;
            visit[last] = true;
            List<Integer> nextList = adj[last];
            for (int next : nextList) {
                if (visit[next] && !alreadyFinishedPoints[next]) {
                    System.out.println("there is a cycle at " + next);
                }
                if (!visit[next])
                    dfsDetectCycle(visit, alreadyFinishedPoints, stack, next);
            }
            stack.push(last);
            alreadyFinishedPoints[last] = true;
        }

        void dfs(Set<Integer> visit, Stack<Integer> stack, int last) {
            if (visit.contains(last)) return;
            visit.add(last);
            List<Integer> nextList = adj[last];
            for (int i = 0; i < nextList.size(); i++) {
                dfs(visit, stack, nextList.get(i));
            }
            stack.push(last);
        }


    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
//        g.addEdge(3, 5);

        System.out.println(g.topologicalSort());

        // find cycle in DAG
        g = new Graph(4);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        System.out.println(g.topologicalSort());
    }
}
