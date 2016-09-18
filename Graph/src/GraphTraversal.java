// Java program to print DFS traversal from a given given graph

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class GraphTraversal {
    public static void main(String args[]) {
        GraphTraversal g = new GraphTraversal(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        g.traversal(2);
    }

    private int V;
    private LinkedList<Integer> adj[];
    public GraphTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        List<Integer> nexts = adj[v];
        for (int next : nexts) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    private void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                System.out.print(node + " ");
                List<Integer> nexts = adj[node];
                for (int next : nexts) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }

        }
    }

    // The function to do traversal traversal. It uses recursive dfs()
    public void traversal(int v) {
        boolean visited[] = new boolean[V];
//        dfs(v, visited);
        bfs(v, visited);
    }
}
