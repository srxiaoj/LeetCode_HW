import java.util.*;

/**
 * Created by thanksgiving on 6/14/16.
 */
public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(1, 2));
        list1.add(new Interval(3, 5));
        list1.add(new Interval(6, 7));
        list1.add(new Interval(8, 10));
        list1.add(new Interval(12, 16));
        System.out.println(obj.insert(list1, new Interval(4, 9)));

        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(1, 5));
        System.out.println(obj.insert(list2, new Interval(2, 7)));

        List<Interval> list3 = new ArrayList<>();
        list3.add(new Interval(1, 5));
        System.out.println(obj.insert(list3, new Interval(1, 5)));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int l = newInterval.start, r = newInterval.end;
        boolean inserted = false;
        List<Interval> res = new ArrayList<Interval>();

        for (Interval cur : intervals) {
            if (cur.end < l || inserted) {
                res.add(cur);
            } else if (cur.start > r) {
                res.add(new Interval(l, r));
                res.add(cur);
                inserted = true;
            } else {
                if (cur.start < l)
                    l = cur.start;
                if (cur.end > r)
                    r = cur.end;
            }
        }
        if (!inserted)
            res.add(new Interval(l, r));
        return res;



      /*  Deque<Interval> queue = new LinkedList<>();
        List<Interval> res = new ArrayList<>();
        if (newInterval == null) return intervals;
        for (int i = 0; i < intervals.size(); i++) {
            queue.offer(intervals.get(i));
        }
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        Stack<Interval> stack = new Stack<>();
        Interval prev;
        while (!queue.isEmpty()) {
            prev = queue.pollFirst();
            // prev 在 newInterval 左边
            if (prev.r < newInterval.l) {
                stack.add(prev);

                // prev 在 newInterval 右边
            } else if (prev.l > newInterval.r) {
                stack.add(newInterval);
                stack.add(prev);
                break;

                // prev 包含了 newInterval
            } else if (prev.r >= newInterval.r && prev.l <= newInterval.l) {
                stack.add(prev);
                break;

                // prev 与 newInterval 交叉
            } else if (prev.r >= newInterval.r && prev.l > newInterval.l) {
                newInterval = new Interval(newInterval.l, prev.r);

                // newInterval 包含了 prev
            } else if (prev.r <= newInterval.r && prev.l >= newInterval.l) {
                // do nothing

                // newInterval 与 prev 交叉
                // prev.r <= newInterval.r && prev.l < newInterval.l
            } else {
                newInterval = new Interval(prev.l, newInterval.r);
            }

            if (queue.isEmpty()) {
                stack.add(newInterval);
            }
        }

        while (!queue.isEmpty()) {
            stack.push(queue.pollFirst());
        }

        for (Interval l : stack) {
            res.add(l);
        }
        return res;*/
    }

    private static class Interval {
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
