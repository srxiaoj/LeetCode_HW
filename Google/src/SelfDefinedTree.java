import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelfDefinedTree {
    public static void main(String[] args) {
        String[] input = {"1 2", "1 3", "1 4", "2 5", "2 6", "3 7"};
        System.out.println(getTreeVal(1, input));
    }

    public static List<Integer> getTreeVal(int node, String[] input) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = input.length;
        String first = input[0];
        String[] a = first.split(" ");
        int root = Integer.parseInt(a[0]);
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(a[1]));
        map.put(root, list);
        map.put(Integer.parseInt(a[1]), new ArrayList<>());

        for (int i = 1; i < n; i++) {
            String[] next = input[i].split(" ");
            List<Integer> newlist;
            if (!map.containsKey(Integer.parseInt(next[0]))) {
                newlist = new ArrayList<>();
            } else {
                newlist = map.get(Integer.parseInt(next[0]));
            }
            newlist.add(Integer.parseInt(next[1]));
            map.put(Integer.parseInt(next[0]), newlist);
        }

        List<Integer> res = new ArrayList<>();
        res.add(node);
        res.addAll(map.get(node));
        return res;
    }
}
