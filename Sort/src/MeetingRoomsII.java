import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by thanksgiving on 1/9/16.
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        Interval[] test = new Interval[3];
        test[0] = new Interval(0, 30);
        test[1] = new Interval(5, 10);
        test[2] = new Interval(15, 20);
        System.out.println(minMeetingRooms(test));

        Interval[] test2 = new Interval[3];
        test2[0] = new Interval(9, 10);
        test2[1] = new Interval(4, 9);
        test2[2] = new Interval(4, 17);
        System.out.println(minMeetingRooms(test2));

        Interval[] test3 = new Interval[4];
        test3[0] = new Interval(1, 3);
        test3[1] = new Interval(2, 9);
        test3[2] = new Interval(12, 16);
        test3[3] = new Interval(16, 20);
        System.out.println(minMeetingRooms(test3));
    }

    public static int minMeetingRooms(Interval[] intervals) {
        /**
         * 方法1： 将start与end分别提取出来，变成两个array，进行排序
         *        对比两个array有多少overlap的区间, 思维难度高, nlog(n)
         */
       /* if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        for (int i = 0; i < len; i++) {
            Interval curr = intervals[i];
            startTime[i] = curr.start;
            endTime[i] = curr.end;
        }

        // Sort the start and end time
        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int activeMeetings = 0;
        int numMeetingRooms = 0;

        int i = 0;
        int j = 0;

        while (i < len && j < len) {
            if (startTime[i] < endTime[j]) {
                activeMeetings++;
                numMeetingRooms = Math.max(numMeetingRooms, activeMeetings);
                i++;
            } else {
                activeMeetings--;
                j++;
            }
        }
        System.out.println(activeMeetings);
        return numMeetingRooms;
*/

        /**
         * 方法2: nlog(n)
         */
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numRooms = 1;
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < pq.peek()) {
                numRooms++;
                pq.offer(intervals[i].end);
            } else {
                pq.poll();
                pq.offer(intervals[i].end);
            }
        }
        // return pq.size() // priorityQueue的size也就是每个meeting room的所需end时间
        return numRooms;
    }

    public static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval l1, Interval l2) {
            if (l1.start == l2.start) {
                return l1.end - l2.end;
            } else {
                return l1.start - l2.start;
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

    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
