/**
 * Created by thanksgiving on 12/19/15.
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        System.out.println(bulbSwitch(99999));
    }
    public static int bulbSwitch(int n) {
        /**
         * A bulb ends up on iff it is switched an odd number of times.
         Bulb i is switched in round d iff d divides i. So bulb i ends up on iff it has an odd number of divisors.
         Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. Except if i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. So bulb i ends up on iff and only if i is a square.
         So just count the square numbers.
         */
        // method 1
//        return (int) Math.sqrt(n);

        // method 2
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int factor = numOfFactors(i);
//            System.out.println("Factor number of " + i + " is: " + factor);
            if (factor % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int numOfFactors(int n) {
        if (n == 1) return 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
//                System.out.print(i + " ");
            }
        }
        return count;
    }
}
