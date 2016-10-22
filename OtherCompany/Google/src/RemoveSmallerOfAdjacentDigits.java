import java.util.LinkedList;
import java.util.List;

/**
 * find the smallest number that can be obtained from X by replacing two adjacent digits with larger
 * of the two.
 */
public class RemoveSmallerOfAdjacentDigits {
    public static void main(String[] args) {
        System.out.println(solution(233614)); // 23364
        System.out.println(solution(321321)); // 31321
        System.out.println(solution(233641)); // 23361
        System.out.println(solution(123));    // 13
        System.out.println(solution(321));    // 31
        System.out.println(solution(213));    // 23
        System.out.println(solution(12));     // 2
        System.out.println(solution(1));      // 0
        System.out.println(solution(10));     // 1
        System.out.println(solution(100));    // 10
        System.out.println(solution(10001));  // 1001
        System.out.println(solution(100210)); // 10020
    }

    public static int solution2(int X) {
        if (X < 10) return 0;
        String s = String.valueOf(X);
        int n = s.length();
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.charAt(i);
        }
        char[] res = new char[n - 1];
        res[0] = num[0];
        int i = 1, j = 1;
        while (i < n - 1) {
            if (num[i - 1] >= num[i] && num[i] > num[i + 1]) {
                i++;
                while (j < res.length) {
                    res[j++] = num[i++];
                }
                String total = new String(res);
                return Integer.parseInt(total);
            }
            res[j++] = num[i++];
        }
        i--;
        j--;
        if (j == i) {
            if (num[i] > num[i + 1]) {
                res[j] = num[i];
            } else {
                res[j] = num[i + 1];
            }
        }

        String total = new String(res);
        return Integer.parseInt(total);
    }

    public static int solution(int num) {
        if (num < 10) {
            return 0;
        }

        List<Integer> digits = new LinkedList<>();
        while (num > 0) {
            digits.add(0, num % 10);
            num /= 10;
        }
        int lastRemovable = -1;
        for (int i = 1; i < digits.size(); ) {
            if (digits.get(i) < digits.get(i - 1)) {
                if (i == digits.size() - 1 || digits.get(i + 1) < digits.get(i)) {
                    digits.remove(i);
                    return getNum(digits);
                } else if (digits.get(i + 1) == digits.get(i)) {
                    lastRemovable = i;
                    i++;
                } else {
                    lastRemovable = i;
                    i++;
                }
            } else if (digits.get(i) == digits.get(i - 1)) {
                while (i + 1 < digits.size() && digits.get(i + 1) == digits.get(i)) {
                    i++;
                }
                if (i + 1 == digits.size() || digits.get(i + 1) < digits.get(i)) {
                    digits.remove(i);
                    return getNum(digits);
                } else {
                    lastRemovable = i + 1;
                    i++;
                }
            } else {
                lastRemovable = i - 1;
                i++;
            }
        }

        digits.remove(lastRemovable);
        return getNum(digits);
    }

    private static int getNum(List<Integer> digits) {
        int result = 0;
        for (int i = 0; i < digits.size(); i++) {
            result = result * 10 + digits.get(i);
        }
        return result;
    }

}
