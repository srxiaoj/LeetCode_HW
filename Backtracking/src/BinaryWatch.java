import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 9/29/16.
 */
public class BinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(2));
    }

    public static List<String> readBinaryWatch(int num) {
        int[] hour = new int[]{1, 2, 4, 8};
        int[] min = new int[]{1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();

        for (int i = 0; i <= num; i++) {
            List<String> hourRes = new ArrayList<>();
            List<String> minRes = new ArrayList<>();
            helper(hour, hourRes, 0, new ArrayList<>(), i, false);
            helper(min, minRes, 0, new ArrayList<>(), num - i, true);
//            System.out.println(hourRes);
//            System.out.println(minRes);
            for (int k = 0; k < hourRes.size(); k++) {
                for (int j = 0; j < minRes.size(); j++) {
                    res.add(hourRes.get(k) + ":" + minRes.get(j));
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    private static void helper(int[] times, List<String> res, int pos, List<Integer> part, int n, boolean isMin) {
        if (part.size() == n) {
            int time = 0;
            for (int i : part) {
                time += i;
            }
            if ((time < 12 && !isMin) || isMin) {
                if (time < 10 && isMin) {
                    res.add("0" + time);
                } else {
                    res.add("" + time);
                }
            }
            return;
        }

        for (int i = pos; i < times.length; i++) {
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(times[i]);
            helper(times, res, i + 1, newPart, n, isMin);
        }
    }
}
