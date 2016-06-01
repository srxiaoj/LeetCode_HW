/**
 * Created by thanksgiving on 5/31/16.
 */
public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        /*
        // slow
        int res = 0;
        outer:
        for (int i = 0; i < 32; i++) {
            for (int j = m; j <= n; j++) {
                if (((j >> i) & 1) == 0) continue outer;
            }
            res |= 1 << i;
        }
        return res;*/

        int i = 0;
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            i++;
        }
        return n << i;
    }
}
