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

    private LinkedList<Integer>[] adj;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !isCyclic(numCourses, prerequisites);
    }

    private boolean isCyclic(int numCourses, int[][] prerequisites) {
        // initialize adjacency list
        adj = new LinkedList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<Integer>();
            visited[i] = false;
            recStack[i] = false;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclicUntil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUntil(int u, boolean[] visited, boolean[] recStack) {
        if (!visited[u]) {
            visited[u] = true;
            recStack[u] = true;
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (!visited[i] && isCyclicUntil(i, visited, recStack)) {
                    return true;
                } else if (recStack[i])
                    return true;
            }
        }
        recStack[u] = false;
        return false;
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
