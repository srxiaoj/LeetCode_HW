import java.util.*;

/**
 * Created by thanksgiving on 5/20/16.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        /*list.add(new Interval(4, 5));
        list.add(new Interval(2, 4));
        list.add(new Interval(4, 6));
        list.add(new Interval(3, 4));
        list.add(new Interval(0, 0));
        list.add(new Interval(1, 1));
        list.add(new Interval(3, 5));
        list.add(new Interval(2, 2));*/
        List<Interval> res = obj.merge(list);
        System.out.println(res);

    }

    /**
     * 利用扫描线的方法
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        List<Pair> list = new ArrayList<>();
        for (Interval sub : intervals) {
            Pair a = new Pair(sub.start, true);
            Pair b = new Pair(sub.end, false);
            list.add(a);
            list.add(b);
        }
        Collections.sort(list, new MyComparator());
        Interval next = new Interval(list.get(0).val, 0);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (count == 0) next = new Interval(list.get(i).val, 0);
            if (!list.get(i).isStart) {
                count--;
                if (count == 0) {
                    next.end = list.get(i).val;
                    res.add(next);
                }
            } else {
                count++;
            }
        }
        return res;
    }

    class Pair {
        boolean isStart;
        int val;
        public Pair(int val, boolean start) {
            this.val = val;
            isStart = start;
        }
    }

    class MyComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (a.val == b.val) {
                if (a.isStart && !b.isStart) {
                    return -1;
                } else if (!a.isStart && b.isStart) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return a.val - b.val;
        }
    }
   /* public List<Interval> merge(List<Interval> intervals) {
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
    }*/

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
