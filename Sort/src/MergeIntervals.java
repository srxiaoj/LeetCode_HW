import java.util.*;

/**
 * Created by thanksgiving on 5/20/16.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(4, 5));
        list.add(new Interval(2, 4));
        list.add(new Interval(4, 6));
        list.add(new Interval(3, 4));
        list.add(new Interval(0, 0));
        list.add(new Interval(1, 1));
        list.add(new Interval(3, 5));
        list.add(new Interval(2, 2));
        List<Interval> res = obj.merge(list);
        System.out.println(res);

    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new MyComparator());
        System.out.println(intervals);

        Stack<Interval> stack = new Stack<>();
        stack.add(intervals.get(0));
        int i = 1;
        while (i < intervals.size()) {
            Interval prev = stack.pop();
            Interval next = new Interval();
            if (intervals.get(i).end < prev.end) {
                next = prev;
            } else if (intervals.get(i).start <= prev.end && intervals.get(i).end >= prev.end) {
                next.start = prev.start;
                next.end = intervals.get(i).end;
            } else {
                stack.add(prev);
                next = intervals.get(i);
            }
            stack.add(next);
            i++;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        Collections.sort(res, new MyComparator());
        return res;
    }

    private class MyComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        }
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
            return "["+ this.start + "," + this.end + "]";
        }
    }
}
