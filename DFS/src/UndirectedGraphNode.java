import java.util.*;

/**
 * Created by thanksgiving on 12/21/15.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    /**
     * print out graph in the form of adjacency list
     * @param aNode
     */
    public static void printGraph(UndirectedGraphNode aNode) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Stack<UndirectedGraphNode> visited = new Stack<>();
        queue.add(aNode);
        printAdjacencyList(aNode);
        visited.add(aNode);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            List<UndirectedGraphNode> neighborList = curNode.neighbors;
            int len = neighborList.size();
            int i = 0;
            while (i < len && !visited.contains(neighborList.get(i))) {
                printAdjacencyList(neighborList.get(i));
                visited.add(neighborList.get(i));
                queue.add(neighborList.get(i));
                i++;
            }
        }
    }

    private static void printAdjacencyList(UndirectedGraphNode node) {
        List<UndirectedGraphNode> neighbor = node.neighbors;
        System.out.print(node.label + " -> ");
        for (int i = 0; i < neighbor.size(); i++) {
            if (i < neighbor.size() - 1) {
                System.out.print(neighbor.get(i).label + " -> ");
            } else {
                System.out.print(neighbor.get(i).label);
            }
        }
        System.out.println("");
    }

}
