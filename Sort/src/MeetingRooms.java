import java.util.*;

/**
 * Created by thanksgiving on 1/9/16.
 */
public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRooms obj = new MeetingRooms();
        Interval[] test = new Interval[3];
        test[0] = new Interval(15, 20);
        test[1] = new Interval(0, 30);
        test[2] = new Interval(5, 10);
        System.out.println(obj.canAttendMeetings(test));
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        List<Interval> list = sort(intervals);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start < list.get(i - 1).end) {
                return false;
            }
        }
        return true;
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
            return a.start - b.start;
        }
    }
}



