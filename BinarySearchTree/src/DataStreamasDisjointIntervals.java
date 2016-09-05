import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by thanksgiving on 9/4/16.
 */
public class DataStreamasDisjointIntervals {
    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(1);
        obj.addNum(3);
        System.out.println(obj.getIntervals());
        obj.addNum(7);
        obj.addNum(2);
        System.out.println(obj.getIntervals());
        obj.addNum(6);
        System.out.println(obj.getIntervals());
    }

    public static class SummaryRanges {

        TreeMap<Integer, Interval> treeMap;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            if (treeMap.containsKey(val)) return;
            Integer l = treeMap.lowerKey(val);
            Integer h = treeMap.higherKey(val);

            // add 6 to merge [1, 5] and [7, 10]
            if (l != null && h != null && val == treeMap.get(l).end + 1 && val == treeMap.get(h).start - 1) {
                treeMap.get(l).end = treeMap.get(h).end;
                treeMap.remove(h);
                // add 6 to [1, 5] or [1, 7]
            } else if (l != null && val <= treeMap.get(l).end + 1) {
                treeMap.get(l).end = Math.max(val, treeMap.get(l).end);
            } else if (h != null && val == treeMap.get(h).start - 1) {
                treeMap.put(val, new Interval(val, treeMap.get(h).end));
                treeMap.remove(h);
            } else {
                treeMap.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(treeMap.values());
        }
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + this.start + "," + this.end + "]";
        }
    }
}
