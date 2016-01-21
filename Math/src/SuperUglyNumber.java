import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/21/16.
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        SuperUglyNumber obj = new SuperUglyNumber();
        int[] primes = {2, 7, 13, 19};
        int res = obj.nthSuperUglyNumber(12, primes);

        int[] primes2 = {3, 5, 7, 11, 19, 23, 29, 41, 43, 47};
        int res2 = obj.nthSuperUglyNumber(15, primes2);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int len = primes.length;
        int[] factors = new int[len];
        int[] primeTotal = new int[len];
        for (int i = 0; i < len; i++) {
            factors[i] = 0;
            primeTotal[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            int nextMin = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (primeTotal[j] == list.get(i)) {
                    primeTotal[j] = list.get(factors[j]++) * primes[j];
                }
                nextMin = Math.min(nextMin, primeTotal[j]);
            }
            list.add(nextMin);
        }
//        System.out.println("list is:" + list);
        return list.get(list.size() - 1);
    }
}
