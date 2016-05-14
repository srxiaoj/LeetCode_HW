import java.util.*;

/**
 * Created by thanksgiving on 12/21/15.
 */
public class CloneGraph {
    public static void main(String[] args) {
        CloneGraph obj = new CloneGraph();
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        List<UndirectedGraphNode> list12 = new ArrayList<>(Arrays.asList(node1, node2));
        node0.neighbors = list12;
        List<UndirectedGraphNode> list2 = new ArrayList<>(Arrays.asList(node2));
        node1.neighbors = list2;
        node2.neighbors = list2;
        UndirectedGraphNode res = obj.cloneGraph(node0);
        UndirectedGraphNode.printGraph(res);

    }

    /**
     * dfs不断搜索node的neighbors,把新的neighbors放入map
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (!map.containsKey(node.label)) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(newNode.label, newNode);
            for (UndirectedGraphNode sub : node.neighbors) {
                newNode.neighbors.add(helper(sub, map));
            }
            return newNode;
        } else {
            return map.get(node.label);
        }
    }
}
