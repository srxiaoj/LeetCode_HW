import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 9/17/16.
 */
public class GenerateSemiPrimes {
    public static void main(String[] args) {
//        System.out.println(getPrimeList(25));
        System.out.println(getSemiPrimeList(100));
    }

    private static List<Integer> getPrimeList(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 2) return res;

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
        return res;
    }

    public static List<Integer> getSemiPrimeList(int n) {
        List<Integer> primes = getPrimeList(n / 2);
        List<Integer> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(res, part, 0, n, primes);
        Collections.sort(res);
        return res;
    }

    private static void helper(List<Integer> res, List<Integer> part, int pos, int n, List<Integer> primes) {
        if (part.size() > 2) return;
        if (part.size() == 2 && part.get(0) * part.get(1) < n) {
            res.add(part.get(0) * part.get(1));
            return;
        }

        for (int i = pos; i < primes.size(); i++) {
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(primes.get(i));
            helper(res, newPart, i, n, primes);
        }
    }
}
