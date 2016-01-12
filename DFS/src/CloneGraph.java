import java.util.*;

/**
 * Created by thanksgiving on 12/21/15.
 */
public class CloneGraph {
    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        List<UndirectedGraphNode> list12 = new ArrayList<>(Arrays.asList(node1, node2));
        node0.neighbors = list12;
        List<UndirectedGraphNode> list2 = new ArrayList<>(Arrays.asList(node2));
        node1.neighbors = list2;
        node2.neighbors = list2;

        CloneGraph obj = new CloneGraph();
        UndirectedGraphNode res = obj.cloneGraph(node0);

        UndirectedGraphNode.printGraph(res);

    }
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}
