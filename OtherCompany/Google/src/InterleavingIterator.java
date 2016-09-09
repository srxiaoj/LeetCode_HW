import java.util.*;

public class InterleavingIterator {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList(Arrays.asList(4, 5, 6));
        List<Integer> l3 = new ArrayList(Arrays.asList(7, 8));
        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();
        Iterator<Integer> it3 = l3.iterator();
        Iterator<Integer> res = flattern(new ArrayList(Arrays.asList(it1, it2, it3)));
        while (res.hasNext()) {
            System.out.print(res.next() + " ");
        }
    }

    public static Iterator<Integer> flattern(List<Iterator<Integer>> list) {
        List<Integer> res = new ArrayList<>();
        Deque<Iterator> deque = new LinkedList<>();
        for (Iterator<Integer> i : list) {
            deque.addLast(i);
        }

        while (!deque.isEmpty()) {
            Iterator<Integer> cur = deque.pollFirst();
            if (cur.hasNext()) res.add(cur.next());
            if (cur.hasNext()) deque.addLast(cur);
        }
        return res.iterator();
    }
}
