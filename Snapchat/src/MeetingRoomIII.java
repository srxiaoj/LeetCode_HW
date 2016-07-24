import java.util.*;

/**
 * 需要输出每个meeting安排在哪个meeting room
 */
public class MeetingRoomIII {
    public static void main(String[] args) {
        Interval[] test = new Interval[3];
        test[0] = new Interval(0, 30);
        test[1] = new Interval(5, 10);
        test[2] = new Interval(15, 20);
        System.out.println(getRoomSchedule(test));

        Interval[] test2 = new Interval[3];
        test2[0] = new Interval(9, 10);
        test2[1] = new Interval(4, 9);
        test2[2] = new Interval(4, 17);
        System.out.println(getRoomSchedule(test2));

        Interval[] test3 = new Interval[4];
        test3[0] = new Interval(1, 3);
        test3[1] = new Interval(2, 9);
        test3[2] = new Interval(12, 16);
        test3[3] = new Interval(16, 20);
        System.out.println(getRoomSchedule(test3));
    }

    public static List<Integer> getRoomSchedule(Interval[] intervals) {
        List<Integer> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res;
        int n = intervals.length;
        int[] output = new int[n];

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(intervals[i], i);
        }
        Arrays.sort(pairs, new PairComparator());
        PriorityQueue<Room> pq = new PriorityQueue<>(new RoomComparator());
        int numRooms = 1;
        pq.offer(new Room(numRooms, pairs[0].interval.end));
        output[pairs[0].originIndex] = numRooms;
        for (int i = 1; i < pairs.length; i++) {
            Room lastRoom = pq.peek();
            if (pairs[i].interval.start < lastRoom.endTime) {
                numRooms++;
                output[pairs[i].originIndex] = numRooms;
            } else {
                pq.poll();
                output[pairs[i].originIndex] = lastRoom.roomIndex;
            }
            pq.offer(new Room(numRooms, pairs[i].interval.end));
        }
        System.out.println(pq);


        // output res
        for (int i = 0; i < n; i++) {
            res.add(output[i]);
        }
        return res;
    }


    private static class Pair {
        Interval interval;
        int originIndex;

        public Pair(Interval l, int i) {
            this.interval = l;
            this.originIndex = i;
        }

        public String toString() {
            return originIndex + ":" + interval.toString();
        }
    }

    private static class Room {
        int roomIndex;
        int endTime;

        public Room(int roomIndex, int endTime) {
            this.roomIndex = roomIndex;
            this.endTime = endTime;
        }

        public String toString() {
        return "Room " + roomIndex + ", endTime: " + endTime;
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

    private static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.interval.start - p2.interval.start;
        }
    }

    private static class RoomComparator implements Comparator<Room> {
        @Override
        public int compare(Room r1, Room r2) {
            return r1.endTime - r2.endTime;
        }
    }
}
