/**
 * Created by thanksgiving on 1/3/16.
 */
public class FactorialTrailingZeroes {
    /**
     * Given an integer n, write a function that returns count of trailing zeroes in n!.
     * <p>
     * Examples:
     * Input: n = 5
     * Output: 1
     * Factorial of 5 is 20 which has one trailing 0.
     * <p>
     * Input: n = 20
     * Output: 4
     * Factorial of 20 is 2432902008176640000 which has
     * 4 trailing zeroes.
     * <p>
     * Input: n = 100
     * Output: 24
     * A simple method is to first calculate factorial of n, then count trailing 0s in the result (We can count trailing 0s by repeatedly dividing the factorial by 10 till the remainder is 0).
     * <p>
     * The above method can cause overflow for a slightly bigger numbers as factorial of a number is a big number (See factorial of 20 given in above examples). The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5. If we can count the number of 5s and 2s, our task is done. Consider the following examples.
     * <p>
     * n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So count of trailing 0s is 1.
     * <p>
     * n = 11: There are two 5s and three 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So count of trailing 0s is 2.
     * <p>
     * We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s. So if we count 5s in prime factors, we are done. How to count total number of 5s in prime factors of n!? A simple way is to calculate floor(n/5). For example, 7! has one 5, 10! has two 5s. It is done yet, there is one more thing to consider. Numbers like 25, 125, etc have more than one 5. For example if we consider 28!, we get one extra 5 and number of 0s become 6. Handling this is simple, first divide n by 5 and remove all single 5s, then divide by 25 to remove extra 5s and so on. Following is the summarized formula for counting trailing 0s.
     * <p>
     * Trailing 0s in n! = Count of 5s in prime factors of n!
     * = floor(n/5) + floor(n/25) + floor(n/125) + ....
     *
     *
     * 解释2: 实际上是5进制问题
     *    11          10        9           8              7           6           5       4      3      2     1
     * 2x5^1+1x5^0  2x5^1  1x5^1+4x5^0  1x5^1+3x5^0   1x5^1+2x5^0  1x5^1+1x5^0   1x5^1   4x5^0  3x5^0  2x5^0 1x5^0
     * 11表示为021, 10表示为020， 9表示为014
     * 1位以上的所有倍数都可以生成0
     */
    public static void main(String[] args) {
        int n = 1808548329;
        System.out.println("The factorial of " + n + " is: " + trailingZeroes(n));
        int n2 = 25;
        System.out.println("The factorial of " + n2 + " is: " + trailingZeroes(n2));
        int n3 = 100;
        System.out.println("The factorial of " + n3 + " is: " + trailingZeroes(n3));
        int n4 = 110;
        System.out.println("The factorial of " + n4 + " is: " + trailingZeroes(n4));

    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
