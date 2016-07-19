import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thanksgiving on 7/16/16.
 */
public class CountNumberswithUniqueDigits {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(3));
        System.out.println(countNumbersWithUniqueDigits(4));
        System.out.println(countNumbersWithUniqueDigits(5));
        System.out.println(countNumbersWithUniqueDigits(6));
        System.out.println(countNumbersWithUniqueDigits(8));
        System.out.println(countNumbersWithUniqueDigits(10));
        System.out.println(countNumbersWithUniqueDigits(11));
    }


    /**
     * f(1) = 10. (0, 1, 2, 3, ...., 9)
     * f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij
     * and there are 9 numbers that are different from i for j to choose from.
     * f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2, say ij,
     * we can pick k to form a 3 digit number ijk and there are 8 numbers that
     * are different from i and j for k to choose from.
     *
     * Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
     *
     * ...
     * f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
     * f(11) = 0 = f(12) = f(13)....
     */
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int availableDigit = 9;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * availableDigit;
            availableDigit--;
        }

//        printArray(dp);
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += dp[i];
        }
        return sum;

        /*if (n == 0) return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
            n--;
        }
        return res;*/
    }

    public static List<Integer> getNonDuplicateSequence(int n) {
        int num = (int) Math.pow(10, n);
        List<Integer> res = new ArrayList<>();
        int next = 0;
        while (next < num) {
            int ignore = getBadDigit(next);
            if (ignore == -1) {
                res.add(next);
                next++;
            } else {
                int ignoreNum = (int) Math.pow(10, ignore);
//                if (ignore > 0) System.out.println("last " + next + ", ignore " + ignoreNum);
                next += ignoreNum;
            }
        }
        return res;
    }

    private static int getBadDigit(int num) {
        String s = String.valueOf(num);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                return s.length() - i - 1;
            }
        }
        return -1;
    }

    //print array
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
