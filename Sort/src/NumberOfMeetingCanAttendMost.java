import java.util.Arrays;
import java.util.Comparator;

public class NumberOfMeetingCanAttendMost {

  public static void main(String[] args) {
    Interval[] test = new Interval[3];
    test[0] = new Interval(0, 30);
    test[1] = new Interval(5, 10);
    test[2] = new Interval(15, 20);
    NumberOfMeetingCanAttendMost obj = new NumberOfMeetingCanAttendMost();
    System.out.println(obj.numOfMeetingCanAttendMost(test));
  }

  public int numOfMeetingCanAttendMost(Interval[] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    int end = -1;
    Arrays.sort(intervals, new MyComparator());
    Utils.printArray(intervals);
    int num = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i].start > end) {
        end = intervals[i].end;
        num++;
      }
    }
    return num;
  }

  class MyComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval l1, Interval l2) {
      if (l1.end == l2.end) {
        return l1.start - l2.start;
      } else {
        return l1.end - l2.end;
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
      return "[" + start + "," + end + "]";
    }
  }
}
