import java.util.Stack;

public class GraphInterface {
    /* ------------------------------------------
       Data structure used to represent a graph
       ------------------------------------------ */
    private int[][] adjMatrix;
    private int NNodes;
    private boolean[] visited;

    /* -------------------------------
       Construct a graph of N nodes
       ------------------------------- */
    GraphInterface(int N) {
        NNodes = N;
        adjMatrix = new int[N][N];
        visited = new boolean[N];
    }

    GraphInterface(int[][] matrix) {
        NNodes = matrix.length;
        adjMatrix = new int[NNodes][NNodes];
        visited = new boolean[NNodes];
        for (int i = 0; i < NNodes; i++)
            for (int j = 0; j < NNodes; j++)
                adjMatrix[i][j] = matrix[i][j];
    }

    /**
     * recursive.
     */
    public void dfs(int i) {
        visited[i] = true;
        printNode(i);
        for (int j = 0; j < NNodes; j++) {
            if (adjMatrix[i][j] > 0 && !visited[j])
                dfs(j);
        }
    }

    /**
     * iterate using stack.
     */
    public void dfs() {
        // DFS uses Stack data structure
        int rootNode = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(rootNode);
        visited[rootNode] = true;

        printNode(rootNode);

        while (!stack.isEmpty()) {
            int n = stack.peek();
            int child = getUnvisitedChildNode(n);
            if (child != -1) {
                visited[child] = true;
                printNode(child);
                stack.push(child);
            } else {
                stack.pop();
            }
        }
        clearVisited(); // Clear visited property of nodes
    }

    /**
     * Return the next unvisited node, if all the node has been visited, return -1.
     */
    private int getUnvisitedChildNode(int n) {
        for (int j = 0; j < NNodes; j++) {
            if (adjMatrix[n][j] > 0 && !visited[j]) {
                return j;
            }
        }
        return -1;
    }

    private void clearVisited() {
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
    }

    private void printNode(int n) {
        System.out.println(n);
    }
}