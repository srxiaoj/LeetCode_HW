/**
 * Created by thanksgiving on 1/21/16.
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        SuperUglyNumber obj = new SuperUglyNumber();
        int[] primes = {2, 7, 13, 19};
        int res = obj.nthSuperUglyNumber(12, primes);
        System.out.println(res);

        int[] primes2 = {3, 5, 7, 11, 19, 23, 29, 41, 43, 47};
        int res2 = obj.nthSuperUglyNumber(15, primes2);
        System.out.println(res2);
    }

    /**
     * 借用 UglyNumber2思路
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] index = new int[k];
        int[] product = new int[k];
        for (int i = 0; i < k; i++) {
            product[i] = primes[i];
        }
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min, product[j]);
            }
            ugly[i] = min;
            for (int j = 0; j < k; j++) {
                if (min == product[j]) {
                    index[j]++;
                    product[j] = (ugly[index[j]]) * primes[j];
                }
            }
        }
        return ugly[n - 1];
       /* List<Integer> list = new ArrayList<>();
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
        return list.get(list.size() - 1);*/
    }
}
