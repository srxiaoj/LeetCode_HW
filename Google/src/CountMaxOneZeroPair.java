/**
 * Created by thanksgiving on 7/11/16.
 */
public class CountMaxOneZeroPair {
    public static void main(String[] args) {
        String s1 = "00000011111";
        String s2 = "01010101011";
        String s3 = "0000000001";
        String s4 = "100101000";
        String s5 = "11000000000111000000011111111111";
        String s6 = "1100000111";
        System.out.println(getMax(s1));
        System.out.println(getMax(s2));
        System.out.println(getMax(s3));
        System.out.println(getMax(s4));
        System.out.println(getMax(s5));
        System.out.println(getMax(s6));
        System.out.println(getMaxRecursive(s1));
        System.out.println(getMaxRecursive(s2));
        System.out.println(getMaxRecursive(s3));
        System.out.println(getMaxRecursive(s4));
        System.out.println(getMaxRecursive(s5));
        System.out.println(getMaxRecursive(s6));
    }

    /**
     * dp[i] 代表 i 位置前面 dp[i]个数字为 pair
     * 如果 i 位置和 i - dp[i - 1] - 1 可以组成pair, 那么dp[i] = dp[i - 1] + 2
     * 并且还要考虑 i - dp[i - 1] - 2位的pair个数，来保证组成的pair个数最大
     */
    public static int getMax(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i - 1 >= 0 && i - dp[i - 1] - 1 >= 0) {
                int cur = s.charAt(i) - '0';
                int last = s.charAt(i - dp[i - 1] - 1) - '0';
                if (cur + last == 1) {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static int getMaxRecursive(String s) {
        int len = s.length();
        int numOfZero = 0, numOfOne = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                numOfZero++;
            } else {
                numOfOne++;
            }
        }

        int maxPossibleResult = 2 * Math.min(numOfOne, numOfZero);
        char majorityElement = '0';
        if (maxPossibleResult == numOfZero) {
            majorityElement = '1';
        }

        int l = 0, r = len - 1;
        while (l <= r && r - l + 1 > 2 * maxPossibleResult && (s.charAt(l) == majorityElement || s.charAt(r) == majorityElement)) {
            if (s.charAt(l) == majorityElement) {
                l++;
            }
            if (r - l + 1 == maxPossibleResult) break;
            if (s.charAt(r) == majorityElement) {
                r--;
            }
        }

        if (r - l + 1 == maxPossibleResult) {
            return maxPossibleResult;
        }

        String left = s.substring(l + 1, r + 1);
        String right = s.substring(l, r);
        int leftRes = getMaxRecursive(left);
        int rightRes = getMaxRecursive(right);
        return Math.max(leftRes, rightRes);
    }
}
