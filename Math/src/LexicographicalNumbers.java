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
    private static int getNext(int n, int cur) {
        if (cur * 10 <= n) { // 1 -> 10 -> 100
//            System.out.println("1st " + cur);
            return cur * 10;
        } else if (cur % 10 == 9) { // 199 -> 2
            int temp = cur;
            int level = 0;
            while (temp % 10 == 9) {
                temp = temp / 10;
                level++;
            }
//            System.out.println("2nd " + cur);
            return (cur + 1) / (int) Math.pow(10, level);
        } else if (cur + 1 <= n) { // 11 -> 12 -> 13
//            System.out.println("3rd " + cur);
            return cur + 1;
        } else { //cur + 1 > n: 13 -> 2
//            System.out.println("4th " + cur);
            return cur / 10 + 1;
        }
    }
}
