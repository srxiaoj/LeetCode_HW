import java.util.*;

/**
 * 推荐方法4
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary obj = new ReconstructItinerary();
        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] tickets2 = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        System.out.println(obj.findItinerary1(tickets));
        System.out.println(obj.findItinerary1(tickets2));
    }


    public List<String> findItinerary1(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }

    public List<String> findItinerary2(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        List<String> route = new LinkedList();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        visit("JFK", targets, route);
        return route;
    }


    private void visit(String airport, Map<String, PriorityQueue<String>> targets, List<String> route) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll(), targets, route);
        route.add(0, airport);
    }

    /**
     * When you run random custom test cases in editor you will get to know that they require a topological sort to be done on the input.
     * For ex feeding [["JFK",NRT],["JFK",KUL]] returns ["JFK","NRT","KUL"] which seems wrong as per the explanation but since input is not a valid itinerary hence the result.
     * This problem needs a topological sort in short. Hence do a topological sort after storing nodes in a sorted order.
     * Note :-
     * *Topological sort is used only for DAGs** hence we need to *remove the edges* once it is visited. Thats why the solution uses a priority queue which sorts the nodes as well as helps in removing it in an efficient way.
     */
    public List<String> findItinerary3(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0]))
                graph.put(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        DFS("JFK", graph, result); // we need to do DFS/topological sort only from "JFK"
        return result;
    }

    /*DFS doing topological sort*/
    private void DFS(String node, HashMap<String, PriorityQueue<String>> graph, LinkedList<String> res) {
        PriorityQueue<String> nodes = graph.get(node);
        while (nodes != null && !nodes.isEmpty())
            DFS(nodes.poll(), graph, res);
        res.addFirst(node); // this is the key, instead of reversing add to the head of linkelist.
    }

    public static List<String> findItinerary4(String[][] tickets) {
        // construct graph
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        for (String[] ticket : tickets) {
            ArrayList<String> list;
            if (!graph.containsKey(ticket[0])) {
                list = new ArrayList<>();
                graph.put(ticket[0], list);
            } else {
                list = graph.get(ticket[0]);
            }
            list.add(ticket[1]);
        }
        for (ArrayList<String> curr : graph.values()) {
            Collections.sort(curr);
        }
        ArrayList<String> res = new ArrayList<>();
        itineraryHelper("JFK", res, graph, tickets.length + 1);
        return res;
    }

    // n is how many stops totally should contain
    public static boolean itineraryHelper(String part, List<String> res, HashMap<String, ArrayList<String>> graph, int n) {
        res.add(part);
        if (res.size() >= n) {
            return true;
        }
        if (!graph.containsKey(part) || graph.get(part).isEmpty()) {
            return false;
        }
        ArrayList<String> arrivals = graph.get(part);
        for (int i = 0; i < arrivals.size(); i++) { // iterate each arrival point
            String arrival = graph.get(part).remove(i);
            if (itineraryHelper(arrival, res, graph, n)) {
                return true;
            }
            res.remove(res.size() - 1); // backtrack
            arrivals.add(i, arrival);
        }
        return false;
    }
}
