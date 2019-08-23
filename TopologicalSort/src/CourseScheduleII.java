import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by thanksgiving on 7/26/16.
 */
public class CourseScheduleII {

  public static void main(String[] args) {
    int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    int[] res = findOrder(4, prerequisites);
    Utils.printArray(res);
  }

  public static int[] findOrder(int n, int[][] prerequisites) {
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

    public int[] topologicalSort() {
      int[] res = new int[V];
      boolean[] visit = new boolean[V];
      boolean[] alreadyFinished = new boolean[V];
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < V; i++) {
        if (!dfs(visit, alreadyFinished, i, stack)) {
          return new int[0];
        }
      }
      int i = V - 1;
      while (!stack.isEmpty()) {
        res[i] = stack.pop();
        i--;
      }
      return res;
    }

    private boolean dfs(boolean[] visit, boolean[] alreadyFinished, int last,
        Stack<Integer> stack) {
      if (visit[last]) {
        return true;
      }
      visit[last] = true;
      List<Integer> nextList = adj[last];
      for (int next : nextList) {
        if (visit[next] && !alreadyFinished[next]) {
          return false;
        }
        if (!dfs(visit, alreadyFinished, next, stack)) {
          return false;
        }
      }
      stack.push(last);
      alreadyFinished[last] = true;
      return true;
    }
  }
}
