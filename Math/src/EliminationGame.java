import java.util.TreeSet;

/**
 * Created by thanksgiving on 9/17/16.
 */
public class EliminationGame {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println(i + ": " + lastRemaining2(i) + " ");
        }
//        System.out.println(lastRemaining2(20));
    }


    /**
     * [1 2 3 4 5 6 7 8] -> [2 4 6 8] 正好为 [1 2 3 4] 从右过来的解 * 2
     * 那么怎么得到[1 2 3 4] 从由过来的解呢, 这个解为 (1 + 4) - [1 2] * 2
     * 所以[1 2 3 4 5 6 7 8] = (1 + 4 - [1 2 3 4]) * 2)
     *                      = (1 + 4 - ((1 + 2 - [1 2]) * 2) * 2
     *
     * 而且注意到 f(odd) == f(odd - 1)
     */
    public static int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }



    /**
     * O(n)
     */
    public static int lastRemaining2(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        boolean toRight = true;
        Integer start = 1;
        int numOfLoop = 1;
        while (set.size() > 1) {
            if (toRight) {
                set.remove(start);
                start += (1 << numOfLoop);
                int upperBound = set.floor(n);
                if (start > upperBound) {
                    toRight = false;
                    start = upperBound;
                    numOfLoop++;
                }
            } else {
                set.remove(start);
                start -= (1 << numOfLoop);
                int lowerBound = set.ceiling(1);
                if (start < lowerBound) {
                    toRight = true;
                    start = lowerBound;
                    numOfLoop++;
                }
            }
        }
        return set.ceiling(1);
    }
}
