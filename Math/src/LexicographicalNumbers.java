import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 8/29/16.
 */
public class LexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
        System.out.println(lexicalOrder(22));
        System.out.println(lexicalOrder(234));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int next = 1;
        for (int i = 1; i <= n; i++) {
            res.add(next);
            next = getNext(n, next);
        }
        return res;
    }

    /**
     * 四种情况
     */
    private static int getNext(int n, int next) {
        if (next * 10 <= n) {
            return next * 10;
        } else if (next % 10 == 9) {
            while (next % 10 == 9) {
                next /= 10;
            }
            next++;
            return next;
        } else if (next + 1 <= n) {
            return next + 1;
        } else {
            return next / 10 + 1;
        }
    }
}
