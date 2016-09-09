import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 7/8/16.
 */
public class TripletsSmallerThanK {
    public static void main(String[] args) {
        int[] num = {5, 3, 6, 1, 8, 10};
        System.out.println(count(num, 13));
    }

    public static int count(int[] a, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(res, part, k, 0, a);
        System.out.println(res);
        return res.size();
    }

    private static void helper(List<List<Integer>> res, List<Integer> part, int k, int start, int[] a) {
        if (part.size() > 3 || k < 0) return;
        if (part.size() == 3 && k >= 0) {
            res.add(new ArrayList<Integer>(part));
            return;
        }

        for (int i = start; i < a.length; i++) {
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(a[i]);
            helper(res, newPart, k - a[i], i + 1, a);
        }
    }
}
