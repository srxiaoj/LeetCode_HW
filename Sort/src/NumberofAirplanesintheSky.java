import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 7/4/16.
 */
public class NumberofAirplanesintheSky {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 10));
        list.add(new Interval(2, 3));
        list.add(new Interval(5, 8));
        list.add(new Interval(4, 7));
        System.out.println(countOfAirplanes(list));
    }

    public static int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) return 0;
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        for (int i = 0; i < airplanes.size(); i++) {
            if (!startList.contains(airplanes.get(i).start))
                startList.add(airplanes.get(i).start);
            if (!endList.contains(airplanes.get(i).end)) {
                endList.add(airplanes.get(i).end);
            }
        }
        Collections.sort(startList);
        Collections.sort(endList);
        int l = startList.get(0);
        int r = endList.get(endList.size() - 1);
        int[] array = new int[r + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < airplanes.size(); i++) {
            Interval inter = airplanes.get(i);
            for (int j = inter.start; j < inter.end; j++) {
                array[j]++;
                if (max < array[j]) {
                    max = array[j];
                }
            }
        }
        return max;
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
