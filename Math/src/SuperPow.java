import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thanksgiving on 8/22/16.
 */
public class SuperPow {
    static int DIV = 1337;

    public static void main(String[] args) {
        System.out.println(superPow(2, new int[]{1, 0}));
        System.out.println(superPow(2, new int[]{3, 0, 0, 0}));
    }

    public static int superPow(int a, int[] b) {
        if (a == 0 || a == 1337 || b == null || b.length == 0) return 0;
        if (a == 1) return 1;

        if (a > DIV) {
            return superPow(a % DIV, b);
        }

        List<Integer> list = findLoop(a);
        int size = list.size();

        int rem = modBy(b, size);
        return list.get(rem - 1);
    }

    private static List<Integer> findLoop(int a) {
/*        List<Integer> index = new ArrayList<>();
        boolean[] set = new boolean[DIV];
        int remainder = a % DIV;
        while (!set[remainder]) {
            set[remainder] = true;
            index.add(remainder);
            remainder = (remainder * a) % DIV;
        }
        return index;*/
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int remainder = a % DIV;
        while (!set.contains(remainder)) {
            set.add(remainder);
            list.add(remainder);
            remainder = (remainder * a) % DIV;
        }
        return list;
    }

    private static int modBy(int[] b, int loopsize) {
        int res = 0;
        for (int i = 0; i < b.length; i++) {
            res = (res * 10 + b[i]) % loopsize;
        }
        return res;
    }
}
