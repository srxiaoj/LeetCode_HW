import java.util.HashSet;
import java.util.Set;

/**
 * Created by thanksgiving on 9/27/16.
 */
public class PerfectRectangle {
    public static void main(String[] args) {
        System.out.println(isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        }));
    }

    /**
     * 所有小rectangle的面积和应该等于最终合并的rectangle的和
     * 每个小rectangle的四个角都应该出现2次，除了四个大角
     */
    public static boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        Set<String> set = new HashSet<>();
        int sum = 0;
        for (int[] rec : rectangles) {
            x1 = Math.min(x1, rec[0]);
            x2 = Math.max(x2, rec[2]);
            y1 = Math.min(y1, rec[1]);
            y2 = Math.max(y2, rec[3]);
            sum += rangeSum(rec);

            String key1 = rec[0] + "," + rec[1];
            String key2 = rec[2] + "," + rec[3];
            String key3 = rec[0] + "," + rec[3];
            String key4 = rec[2] + "," + rec[1];
            if (set.contains(key1)) {
                set.remove(key1);
            } else {
                set.add(key1);
            }

            if (set.contains(key2)) {
                set.remove(key2);
            } else {
                set.add(key2);
            }

            if (set.contains(key3)) {
                set.remove(key3);
            } else {
                set.add(key3);
            }

            if (set.contains(key4)) {
                set.remove(key4);
            } else {
                set.add(key4);
            }
        }

        if (!set.contains(x1 + "," + y1) || !set.contains(x2 + "," + y2) || !set.contains(x1 + "," + y2) || !set.contains(x2 + "," + y1) || set.size() != 4)
            return false;
        return sum == (x2 - x1) * (y2 - y1);
    }

    private static int rangeSum(int[] rec) {
        return (rec[3] - rec[1]) * (rec[2] - rec[0]);
    }
}
