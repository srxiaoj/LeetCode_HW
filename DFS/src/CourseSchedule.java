import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by thanksgiving on 12/23/15.
 */
public class CourseSchedule {

  public static void main(String[] args) {
    CourseSchedule obj = new CourseSchedule();
    int numCourses = 3;
    int[][] pre = {
        {1, 0},
        {2, 0},
        {1, 2}
    };
    System.out.println("can finish: " + obj.canFinish(numCourses, pre));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Graph g = new Graph(numCourses);
    for (int i = 0; i < prerequisites.length; i++) {
      g.addEdge(prerequisites[i][0], prerequisites[i][1]);
    }
    return g.topologicalSort();
  }

  class Graph {

    int v;
    LinkedList<Integer>[] adj;

    public Graph(int n) {
      this.v = n;
      adj = new LinkedList[n];
      for (int i = 0; i < n; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    private void addEdge(int u, int v) {
      adj[u].add(v);
    }

    private boolean topologicalSort() {
      boolean[] visit = new boolean[v];
      boolean[] hasFinished = new boolean[v];
      for (int i = 0; i < v; i++) {
        if (!dfs(visit, hasFinished, i)) {
          return false;
        }
      }
      return true;
    }

    private boolean dfs(boolean[] visit, boolean[] hasFinished, int i) {
      if (visit[i]) {
        return true;
      }
      visit[i] = true;

      for (int next : adj[i]) {
        if (visit[next] && !hasFinished[next]) {
          return false;
        }
        if (!dfs(visit, hasFinished, next)) {
          return false;
        }
      }
      hasFinished[i] = true;
      return true;
    }
  }
}
