import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 7/4/16.
 */
public class FindAllPrime {
    public static void main(String[] args) {
//        System.out.println(findPrime(5000).size());
        System.out.println(findPrime(50));
    }

    public static List<Integer> findPrime(int n) {
        List<Integer> res = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
//        prime[2] = true;
        res.add(2);
        int i = 2;
        outer:
        while (i <= n) {
            for (int j = i; j <= n; j += i) {
                prime[j] = false;
            }
            for (int j = i + 1; j <= n; j++) {
                if (prime[j]) {
                    i = j;
                    res.add(i);
                    continue outer;
                }
            }
            break;
        }
        return res;
    }
}
