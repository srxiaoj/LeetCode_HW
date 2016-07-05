import java.util.ArrayList;
import java.util.Collections;

/**
 * 有两个人A和B 已知两个人的schedule
 * 让你给A和B安排一个持续时间为time的meeting，求meeting可以开始的最早的时间
 */
public class EarliestMeetingTime {
    private static class Schedule {
        int start;
        int end;
        Schedule() { start = 0; end = 0; }
        Schedule(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        Schedule[] test = new Schedule[4];
        test[0] = new Schedule(0, 10);
        test[1] = new Schedule(12, 20);
        test[2] = new Schedule(26, 28);
        test[3] = new Schedule(30, 33);

        Schedule[] test2 = new Schedule[3];
        test2[0] = new Schedule(0, 1);
        test2[1] = new Schedule(2, 3);
        test2[2] = new Schedule(5, 9);
        System.out.println(earliestTime2(test, test2, 2));

        Schedule[] a = new Schedule[4];
        a[0] = new Schedule(0, 2);
        a[1] = new Schedule(7, 20);
        a[2] = new Schedule(26, 28);
        a[3] = new Schedule(30, 33);

        Schedule[] b = new Schedule[3];
        b[0] = new Schedule(4, 5);
        b[1] = new Schedule(8, 13);
        b[2] = new Schedule(27, 30);
        System.out.println(earliestTime2(a, b, 1));
    }

    /**
     * 如果遇上start，count++，遇上end，count--，直到count=0时，两个人都结束了各自的schedule，这个位置往后加time，如果小于下一个point的time，就说明可以
     */
    public static int earliestTime2(Schedule[] a, Schedule[] b, int time) {
        ArrayList<Point> list = new ArrayList<Point>();
        for (int i = 0; i < a.length; i++) {
            list.add(new Point(a[i].start, true));
            list.add(new Point(a[i].end, false));
        }
        for (int i = 0; i < b.length; i++) {
            list.add(new Point(b[i].start, true));
            list.add(new Point(b[i].end, false));
        }
        Collections.sort(list);
        int start = 0;
        if (start + time <= list.get(0).time) {
            return start;
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isStart) {
                count++;
            } else {
                count--;
                if (count == 0 && i < list.size() - 1) {
                    if (list.get(i).time <= list.get(i + 1).time - time) {
                        return list.get(i).time;
                    }
                }
            }
        }
        return list.get(list.size() - 1).time;
    }

    private static class Point implements Comparable<Point> {
        boolean isStart;
        int time;
        public Point(int time, boolean flag) {
            this.time = time;
            this.isStart = flag;
        }
        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    /**
     * 假设时间从0开始安排，如果 0 + time比两人下一个最早开始的schedule时间要大，则这个安排不成立
     * 下一个寻找点为两人schedule结束的最大值
     */
    public static int earliestTime(Schedule[] a, Schedule[] b, int time) {
        int res = time;
        int i = 0, j = 0;
        if (a[0].end + time <= b[0].start) {
            return a[0].end;
        }
        if (b[0].end + time <= a[0].start) {
            return b[0].end;
        }
        while (i < a.length && j < b.length) {
            int nextStart = Math.min(a[i].start, b[j].start);
            if (res > nextStart) {
                int nextEnd = Math.max(a[i].end, b[j].end);
                res = nextEnd + time;
                while (i < a.length && nextEnd >= a[i].end) {
                    i++;
                }
                while (j < b.length && nextEnd >= b[j].end) {
                    j++;
                }
            } else {
                return res - time;
            }
        }
        while (i < a.length) {
            int nextStart = a[i].start;
            if (res > nextStart) {
                int nextEnd = a[i].end;
                res = nextEnd + time;
                i++;
            } else {
                return res - time;
            }
        }
        while (j < b.length) {
            int nextStart = b[j].start;
            if (res > nextStart) {
                int nextEnd = b[j].end;
                res = nextEnd + time;
                j++;
            } else {
                return res - time;
            }
        }
        return Math.max(a[a.length - 1].end, b[b.length - 1].end);
    }
}
