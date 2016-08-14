/**
 * Created by thanksgiving on 8/14/16.
 */
public class SelfCrossing {
    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 10, 4, 4, 3, 3, 2, 2, 1, 1}));
        System.out.println(isSelfCrossing(new int[]{1, 2, 3, 4}));
    }

    /**
     * 要比较到第六条线
     */
    public static boolean isSelfCrossing(int[] x) {
        int n = x.length;
        if (n <= 3) return false;

        for (int i = 3; i < n; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;  //Fourth line crosses first line and onward
            if (i >= 4) {
                // Fifth line meets first line and onward
                // x[4] + x[0] >= x[2] && x[1] == x[3]
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                    return true;
            }
            if (i >= 5) {
                // Sixth line crosses first line and onward
                // x[3] - x[1] >= 0 && x[5] >= x[3] - x[1] && x[4] >= x[2] - x[0] && x[4] <= x[2]
                if (x[i - 2] - x[i - 4] >= 0 && x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3])
                    return true;
            }
        }
        return false;
    }
}

