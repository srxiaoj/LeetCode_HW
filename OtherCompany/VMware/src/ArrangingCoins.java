/**
 * Created by thanksgiving on 9/23/16.
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins obj = new ArrangingCoins();

    }

    static void arrangeCoins(long[] coins) {
        if (coins == null || coins.length == 0) return;
        for (int i = 0; i < coins.length; i++) {
            System.out.println(helper(coins[i]));
        }
    }

    static long helper(long num) {
        long start = 1, end = 2 * (long) Math.sqrt((double) num);
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (total(mid) == num) {
                return mid;
            } else if (total(mid) > num) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (total(start) > num) {
            return start - 1;
        } else if (total(start) <= num && total(end) > num) {
            return start;
        } else {// if (total(end) <= num)
            return end;
        }
    }

    static long total(long n) {
        return (1 + n) * n / 2;
    }
}
