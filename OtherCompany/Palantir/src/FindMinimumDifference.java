import java.util.Arrays;
import java.util.Comparator;

/**
 * Input: String[], HH:MM 格式, unsorted
 * return minimum minute difference, for example， 如果 11:00 和 11:01 差距最小 则返回1
 * note: 24小时制 23:59 和 00:00 差1min
 */
public class FindMinimumDifference {
    public static void main(String[] args) {
        System.out.println(getMinTimeDifference(new String[] {"00:00", "00:05", "23:50", "11:00"}));
        System.out.println(getMinTimeDifference(new String[] {"00:05", "23:50", "23:30"}));
    }

    public static int getMinTimeDifference(String[] times) {
        if (times == null || times.length <= 1) return -1;

        Arrays.sort(times, new Comparator<String>() {
            public int compare(String a, String b) {
                int aHour = Integer.parseInt(a.substring(0, 2));
                int aMin = Integer.parseInt(a.substring(3, 5));
                int bHour = Integer.parseInt(b.substring(0, 2));
                int bMin = Integer.parseInt(b.substring(3, 5));
                if (aHour != bHour) {
                    return aHour - bHour;
                }
                return aMin - bMin;
/*                if (aHour > bHour) {
                    return 1;
                } else if (aHour < bHour) {
                    return -1;
                } else if (aMin > bMin) {
                    return 1;
                } else if (aMin < bMin) {
                    return -1;
                } else {
                    return 0;
                }*/
            }
        });

        int start = Integer.parseInt(times[0].substring(0, 2)) * 60 + Integer.parseInt(times[0].substring(3, 5));
        int end = Integer.parseInt(times[times.length - 1].substring(0, 2)) * 60 + Integer.parseInt(times[times.length - 1].substring(3, 5));
        int min = start - end + 24 * 60;
        for (int i = 1; i < times.length; i++) {
            int curDiff = Integer.parseInt(times[i].substring(0, 2)) * 60 + Integer.parseInt(times[i].substring(3, 5))
                    - (Integer.parseInt(times[i - 1].substring(0, 2)) * 60 + Integer.parseInt(times[i - 1].substring(3, 5)));
            min = Math.min(min, curDiff);

            if (min == 0) return 0;
        }
        return min;
    }


    //print array
    public static void printArray(String[] A) {
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
