import java.util.*;


public class ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary obj = new ReconstructItinerary();
        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] tickets2 = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
//        System.out.println(obj.findItinerary(tickets));
        System.out.println(obj.findItinerary(tickets2));
    }

    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return res;
        String from, to;
        Map<String, Queue<String>> map = new HashMap<>();
        for (String[] pair : tickets) {
            from = pair[0];
            to = pair[1];
            Queue<String> queue;
            if (!map.containsKey(from)) {
                queue = new LinkedList<>();
            } else {
                queue = map.get(from);
            }
            queue.offer(to);
            map.put(from, queue);
        }

        from = "JFK";
        while (map.containsKey(from) && !res.contains(from)) {
            res.add(from);
            from = map.get(from).peek();
        }
        res.add(from);
        return res;
    }
}
