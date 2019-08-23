import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by thanksgiving on 7/26/16.
 */
public class CourseSchedule {

  public static void main(String[] args) {
    int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.out.println(canFinish(4, prerequisites));
  }

  public static boolean canFinish(int n, int[][] prerequisites) {
    Graph g = new Graph(n);
    for (int i = 0; i < prerequisites.length; i++) {
      g.addEdge(prerequisites[i][0], prerequisites[i][1]);
    }
    return g.topologicalSort();
  }

  public static boolean canFinishBfs(int n, int[][] prerequisites) {
    int[][] matrix = new int[n][n]; // i -> j
    int[] indegree = new int[n];

    for (int i = 0; i < prerequisites.length; i++) {
      int ready = prerequisites[i][0];
      int pre = prerequisites[i][1];
      if (matrix[pre][ready] == 0) {
        indegree[ready]++; //duplicate case
      }
      matrix[pre][ready] = 1;
    }
    Utils.printArray(matrix);

    int count = 0;
    Queue<Integer> queue = new LinkedList();
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      int course = queue.poll();
      count++;
      for (int i = 0; i < n; i++) {
        if (matrix[course][i] != 0) {
          if (--indegree[i] == 0) {
            queue.offer(i);
          }
        }
      }
    }
    return count == n;
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

    // if true, doesn't contain cycle
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
      if (visit[last]) {
        return true;
      }
      visit[last] = true;
      List<Integer> nextList = adj[last];
      for (int next : nextList) {
        // 0->1, 1->0, 又重新指回last，从而进入死循环
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
