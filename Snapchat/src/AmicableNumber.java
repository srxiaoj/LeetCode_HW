import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找Amicable Number Pairs, 就是 数A 的所有因数(包括1，不包括A) 之和 等于 B。B的所有因数之和又刚好为A。 且 A != B.
 * 求[1, N] 中所有符合条件的pair
 */
public class AmicableNumber {
    public static void main(String[] args) {
        System.out.println(getAmicablePair(10500));
        System.out.println(getAmicablePair(300));
    }

    public static List<Pair> getAmicablePair(int n) {
        List<Pair> res = new ArrayList<>();
        int[] array = new int[n + 1];
        Arrays.fill(array, 1);
       /* for (int i = 0; i <= n; i++) {
            array[i] += 1;
        }*/
        //这个循环关键，决定复杂度啊，用j来指代位置。
        for (int i = 2; i <= n / 2; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                array[j] += i;
            }
//            printArray(array);
        }
        for (int i = 1; i <= n; i++) {
            // 这里注意array[i]很有可能会越界。
            if (i < array[i] && array[i] <= n && array[array[i]] == i) {
                res.add(new Pair(i, array[i]));
            }
        }
        return res;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return first + "<->" + second;
        }
    }

    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
