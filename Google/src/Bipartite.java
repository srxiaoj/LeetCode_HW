import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public static void main(String[] args) {
        int G[][] = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        System.out.println(isBipartite(G));
    }

    // This function returns true if graph G[V][V] is Bipartite, else false
    public static boolean isBipartite(int G[][]) {
        // Create a color array to store colors assigned to all veritces.
        // Vertex number is used as index in this array. The value '-1'
        // of  colorArr[i] is used to indicate that no color is assigned
        // to vertex 'i'.  The value 1 is used to indicate first color
        // is assigned and value 0 indicates second color is assigned.
        int n = G.length;
        int colorArr[] = new int[n];
        for (int i = 0; i < n; i++) colorArr[i] = -1;

        // Assign first color to source
        colorArr[0] = 1;

        // Create a queue (FIFO) of vertex numbers and enqueue
        // source vertex for BFS traversal
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);

        // Run while there are vertices in queue (Similar to BFS)
        while (queue.size() != 0) {
            // Dequeue a vertex from queue
            int u = queue.poll();
            // Find all non-colored adjacent vertices
            for (int v = 0; v < n; v++) {
                // An edge from u to v exists and destination v is not colored
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    queue.add(v);
                // An edge from u to v exists and destination v is
                // colored with same color as u
                } else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        // If we reach here, then all adjacent vertices can
        //  be colored with alternate color
        return true;
    }
}