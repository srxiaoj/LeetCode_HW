import java.util.*;

/**
 * Created by thanksgiving on 9/17/16.
 */
public class GenerateSemiPrimes {
    public static void main(String[] args) {
//        System.out.println(getPrimeList(25));
        System.out.println(getSemiPrimeList(100));
        System.out.println(getSemiPrimeList2(100));
    }

    private static int[] getPrimeList(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 2) return new int[0];

        res.add(2);
        int i = 2;
        boolean[] prime = new boolean[n + 1];
        outer:
        while (i <= n) {
            for (int j = i; j <= n; j += i) {
                prime[j] = true;
            }

            for (int j = i + 1; j <= n; j++) {
                if (!prime[j]) {
                    i = j;
                    res.add(i);
                    continue outer;
                }
            }
            break;
        }
        int[] output = new int[res.size()];
        for (i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }
        return output;
    }

    /**
     * n (log(n))
     */
    public static List<Integer> getSemiPrimeList(int num) {
        int[] primes = getPrimeList(num / 2 + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = primes.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {primes[i] * primes[i], i, i});
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && pq.peek()[0] < num) {
            int[] last = pq.poll();
            res.add(last[0]);
            int a = last[1];
            int b = last[2];
            if (b == n - 1) continue;
            pq.offer(new int[] {primes[a] * primes[b + 1], a, b + 1});
        }

        return res;
    }

    public static List<Integer> getSemiPrimeList2(int n) {
        int[] primes = getPrimeList(n / 2);
        List<Integer> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(res, part, 0, n, primes);
        Collections.sort(res);
        return res;
    }

    private static void helper(List<Integer> res, List<Integer> part, int pos, int n, int[] primes) {
        if (part.size() > 2) return;
        if (part.size() == 2 && part.get(0) * part.get(1) < n) {
            res.add(part.get(0) * part.get(1));
            return;
        }

        for (int i = pos; i < primes.length; i++) {
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(primes[i]);
            helper(res, newPart, i, n, primes);
        }
    }
}
