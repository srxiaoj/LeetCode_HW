import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 下面是six degree的题目答案：
 * We can treat the problem as a graph. Each person represents a node. and if two people are friends,
 * there is a edge between the two nodes that represent them.
 * The problem becomes that find the shortest path between two node: start node and end node.
 *
 * We can adopt BFS, Dijkstra algorithm, Bidirectional BFS. |E| is the number of edges, and |V| is the number of vertex.
 * 1 BFS runs in time O(|V| + |E|)
 * 2 Dijkstra Algorithm with a priority queue runs in time O(|E| + |V|log|V| )
 * Since the weight of each edge in the search grap is same, Dijkstra algorithm will degenerate into BFS.
 * Besides, it needs more data structre than BFS to implement it. For example, Dijkstra algorithm needs
 * priority queue to keep track of every vertex and distance array to keep track of the distance from source vertex to other vertex.
 * 3 Bidirectional BFS is better than BFS.
 * I will talk about why Bidirectional BFS is better than BFS below.
 * assume the distance between source to target is k, and the branch factor is B [every vertex has B edges].
 * BFS will open: 1 + B + B^2 + ... + B^k vertices.
 * bi-directional BFS will open: 2 + 2B + 2B^2 + 2B^3 + .. + 2B^k/2 vertices.
 * for large B and k, the second is obviously much better the the first.
 * I will choose bidirectional BFS.
 * Algorithm idea: do a BFS search simultaneously from the source and the target level by level. (level 0 from source and target respectively , level 1 from source and target respectively....) The algorithm will end when the level from source meets the level from the target.
 *
 * We will use the following data structures:
 * 1 two queues to do BSF respectively from source and target node
 * 2 we need class Node to represent every node in the graph.
 */
public class SixDegree {
    public static void main(String[] args) {

    }

    public class Node {
        public String name;
        public ArrayList<Node> neighbors;
        public ArrayList<Node> predecessors;
        public boolean visited;
        public boolean visitedFromStart; //label node that are visited from start node

    }

    public void Bi_BFS(Node start, Node end) {
        Queue<Node> Q1 = new LinkedList();
        Queue<Node> Q2 = new LinkedList();
        Q1.offer(start);
        Q2.offer(end);
        start.visited = true;
        start.visitedFromStart = true;
        end.visited = true;
        while (!Q1.isEmpty() && !Q2.isEmpty()) {

            int LevelSize1 = Q1.size();
            for (int i = 0; i < LevelSize1; i++) {
                Node front1 = Q1.poll();
                for (Node next : front1.neighbors) {
                    if (!next.visited) {
                        Q1.offer(next);
                        next.visited = true;
                        next.visitedFromStart = true;
                        next.predecessors.add(front1);
                    }
                }
            }

            int LevelSize2 = Q2.size();
            for (int i = 0; i < LevelSize2; i++) {
                Node front2 = Q2.poll();
                if (front2.visitedFromStart) {
                    return;
                    //we find the shortest path
                }
                for (Node next : front2.neighbors) {
                    if (next.visited == false) {
                        Q2.offer(next);
                        front2.predecessors.add(next);
                        next.visited = true;
                    }
                }
            }
        }
    }
}
