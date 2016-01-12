import java.util.*;

/**
 * Created by thanksgiving on 1/9/16.
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        MeetingRoomsII obj = new MeetingRoomsII();
        Interval[] test = new Interval[2];
        test[0] = new Interval(13, 15);
        test[1] = new Interval(1, 3);
//        test[2] = new Interval(5, 10);
        System.out.println(obj.minMeetingRooms(test));

        Interval[] test2 = new Interval[3];
        test2[0] = new Interval(9, 10);
        test2[1] = new Interval(4, 9);
        test2[2] = new Interval(4, 17);
        System.out.println(obj.minMeetingRooms(test2));

        Interval[] test3 = new Interval[3];
        test3[0] = new Interval(2, 11);
        test3[1] = new Interval(6, 16);
        test3[2] = new Interval(11, 16);
        System.out.println(obj.minMeetingRooms(test3));
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        List<Interval> list = sort(intervals);
        List<Interval> combine = new ArrayList<>();
        combine.add(list.get(0));
        int count = 1;
        outer:
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < combine.size(); j++) {
                if (canCombine(combine.get(j), list.get(i))) {
                    Interval newRange = new Interval(combine.get(j).start, list.get(i).end);
                    combine.set(j, newRange);
                    continue outer;
                }
            }
            combine.add(list.get(i));
        }
        return combine.size();
    }

    private boolean canCombine(Interval a, Interval b) {
        if (a == null) return true;
        if (a.start > b.start) return false;
        if (a.end <= b.start) return true;
        return false;
    }
    private List<Interval> sort(Interval[] intervals) {
        List<Interval> list = new ArrayList<>(Arrays.asList(intervals));
        Collections.sort(list, new myComparator());
        return list;
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private class myComparator implements Comparator<Interval> {
        @Override
        public int compare (Interval a, Interval b) {
            if (a.start < b.start) {
                return -1;
            } else if (a.start > b.start) {
                return 1;
            } else {
                return b.end - a.end;
            }
        }
    }
}
