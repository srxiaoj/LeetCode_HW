import java.util.*;

/**
 * Created by thanksgiving on 7/26/16.
 */
public class AlienDictionary {
    public static void main(String[] args) {
        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        String[] words2 = {"z","z"};
        String[] words3 = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        System.out.println(alienOrder(words1));
        System.out.println(alienOrder(words2));
        System.out.println(alienOrder(words3));

    }

    public static String alienOrder(String[] words) {
        Graph g = new Graph(26);
        Set<Character> set = new HashSet<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                set.add(c);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1];
            String b = words[i];
            int j = 0;
            while (j < Math.min(a.length(), b.length()) && a.charAt(j) == b.charAt(j)) {
                j++;
            }
            if (j == Math.min(a.length(), b.length())) continue;
            g.addEdge(a.charAt(j) - 'a', b.charAt(j) - 'a');
            set.remove(a.charAt(j));
            set.remove(b.charAt(j));
        }
        StringBuilder sb = new StringBuilder();
        // 如果有cycle，则直接返回""
        if (!g.topologicalSort(sb)) {
            return "";
        }
        // 如果没有cycle，还要将全部出现过的无法判断顺序的字符加上
        for (char s : set) {
            sb.append(s);
        }

        return sb.toString();

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

        void addEdge(int v, int u) {
            adj[v].add(u);
        }

        boolean topologicalSort(StringBuilder sb) {
            boolean[] visit = new boolean[V];
            boolean[] alreadyFinished = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < V; i++) {
                if (!adj[i].isEmpty() && !dfs(visit, alreadyFinished, i, stack)) {
                    return false;
                }
            }
            while (!stack.isEmpty()) {
                char c = (char) (stack.pop() + 'a');
                sb.append(c);
            }
            return true;
        }

        boolean dfs(boolean[] visit, boolean[] alreadyFinished, int last, Stack<Integer> stack) {
            if (visit[last]) return true;
            visit[last] = true;
            List<Integer> nextList = adj[last];
            for (int next : nextList) {
                if (visit[next] && !alreadyFinished[next] && next != last) {
                    return false;
                }
                if (!dfs(visit, alreadyFinished, next, stack)) {
                    return false;
                }
            }

            alreadyFinished[last] = true;
            stack.push(last);
            return true;
        }
    }
}
